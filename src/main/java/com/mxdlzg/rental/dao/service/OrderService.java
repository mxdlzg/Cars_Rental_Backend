package com.mxdlzg.rental.dao.service;

import com.mxdlzg.rental.dao.respository.*;
import com.mxdlzg.rental.domain.entity.*;
import com.mxdlzg.rental.domain.model.OrderPriceDetail;
import com.mxdlzg.rental.domain.model.OrderSubmitResult;
import com.mxdlzg.rental.utils.Converter;
import com.mxdlzg.rental.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import java.util.Map;

@Service
public class OrderService {
    @Autowired
    PriceRepository priceRepository;
    @Autowired
    StoreRepository storeRepository;
    @Autowired
    UserRepository userRepository;
    @Autowired
    CustomerRepository customerRepository;
    @Autowired
    OrderRepository orderRepository;
    BaseRepository<RtOrderCustomerEntity, Integer> orderCustomerEntityRepository;

    public OrderPriceDetail queryOrderDetail(int carId, Long startDate, Long endDate, int start, int end) {
        //定价条目
        List<RtPriceEntity> detail = priceRepository.findAllByCarId(carId);
        List<RtOrderPriceEntity> realDetail = new ArrayList<>();

        //amount
        int days = Converter.diffDays(startDate, endDate);
        float amount = 0;
        for (RtPriceEntity rtPriceEntity : detail) {
            RtOrderPriceEntity orderPriceEntity = new RtOrderPriceEntity();
            orderPriceEntity.setNum(rtPriceEntity.getPriceByDay() ? days : 1);
            orderPriceEntity.setAmount(rtPriceEntity.getPriceByDay() ? rtPriceEntity.getPrice() : days * rtPriceEntity.getPrice());
            amount += orderPriceEntity.getAmount();
        }

        //time
        Timestamp startTime = Converter.toTimestamp(startDate);
        Timestamp endTime = Converter.toTimestamp(endDate);
        //location
        RtStoresEntity startStore = storeRepository.findById(start).orElse(null);
        RtStoresEntity endStore = storeRepository.findById(end).orElse(null);

        return new OrderPriceDetail(realDetail, amount, startTime, endTime, startStore.getLocation(), endStore.getLocation());
    }

    @Transactional
    boolean submit(OrderPriceDetail priceDetail, RtOrderEntity orderEntity, RtCustomerEntity customerEntity) {
        //main order
        orderEntity = orderRepository.save(orderEntity);
        //customer relation
        RtOrderCustomerEntity orderCustomerEntity = new RtOrderCustomerEntity();
        orderCustomerEntity.setOrderId(orderEntity.getId());
        orderCustomerEntity.setCustomerId(customerEntity.getId());
        orderCustomerEntityRepository.save(orderCustomerEntity);
        //price item relation
        for (RtOrderPriceEntity orderPriceEntity : priceDetail.getDetail()) {

        }

        return false;
    }

    public OrderSubmitResult submitOrder(String token, Map<String, Object> map) {
        String username = JwtTokenUtils.getUsername(token);
        RtUserEntity userEntity = userRepository.findByUsername(username);
        //customer
        RtCustomerEntity customerEntity = new RtCustomerEntity(map.get("info_name").toString(),
                map.get("info_id").toString(),
                map.get("phone").toString(),
                map.get("email").toString());
        customerRepository.save(customerEntity);

        //re calc price
        int carId = (int) map.get("carId");
        Long startDate = (Long) map.get("startDate");
        Long endDate = (Long) map.get("endDate");
        int start = (int) map.get("start");
        int end = (int) map.get("end");
        int days = Converter.diffDays(startDate, endDate);
        OrderPriceDetail priceDetail = queryOrderDetail(carId, startDate, endDate, start, end);

        //create order
        RtOrderEntity orderEntity = new RtOrderEntity(userEntity.getId(), priceDetail.getTotal(), days,
                priceDetail.getFetchCarDate(), priceDetail.getReturnCarDate(), carId, 1, true);

        boolean isSubmitSuccess = submit(priceDetail, orderEntity, customerEntity);
        if (isSubmitSuccess) {

        } else {

        }
        return null;
    }
}
