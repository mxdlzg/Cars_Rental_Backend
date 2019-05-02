package com.mxdlzg.rental.dao.service;

import com.mxdlzg.rental.dao.respository.*;
import com.mxdlzg.rental.domain.entity.*;
import com.mxdlzg.rental.domain.model.OrderPriceDetail;
import com.mxdlzg.rental.domain.model.OrderSubmitForm;
import com.mxdlzg.rental.domain.model.OrderSubmitResult;
import com.mxdlzg.rental.domain.model.enums.ResponseEnums;
import com.mxdlzg.rental.utils.Converter;
import com.mxdlzg.rental.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataAccessException;
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
    CarRepository carRepository;
    @Autowired
    BookingRepository bookingRepository;
    @Autowired
    OrderRepository orderRepository;
    BaseRepository<RtOrderCustomerEntity, Integer> orderCustomerEntityRepository;
    BaseRepository<RtOrderPriceEntity, Integer> orderPriceEntityIntegerBaseRepository;
    BaseRepository<RtOrderStateEntity, Integer> orderStateEntityIntegerBaseRepository;

    public OrderPriceDetail queryOrderDetail(int carId, Long startDate, Long endDate, int start, int end) {
        //定价条目
        List<RtPriceEntity> detail = priceRepository.findAllByCarId(carId);
        List<RtOrderPriceEntity> realDetail = new ArrayList<>();

        //amount
        int days = Converter.diffDays(startDate, endDate);
        float amount = 0;
        for (RtPriceEntity rtPriceEntity : detail) {
            RtOrderPriceEntity orderPriceEntity = new RtOrderPriceEntity();
            orderPriceEntity.setPriceId(rtPriceEntity.getId());
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

    private RtOrderEntity submit(OrderPriceDetail priceDetail, RtOrderEntity orderEntity, RtCustomerEntity customerEntity, RtBookingEntity preBooking, RtBookingEntity nextBooking)  {
        //upsssssssssssdate booking
        RtBookingEntity bookingEntity = new RtBookingEntity();
        bookingEntity.setBelongUserId(orderEntity.getBelongUserId());
        bookingEntity.setCarId(orderEntity.getCarId());
        bookingEntity.setStartDate(orderEntity.getStartDate());
        bookingEntity.setEndDate(orderEntity.getEndDate());
        bookingEntity.setRentDays(orderEntity.getRentDays());
        bookingEntity.setPreId(preBooking==null?-1:preBooking.getId());
        bookingEntity.setNextId(nextBooking==null?-1:nextBooking.getId());
        bookingEntity = bookingRepository.save(bookingEntity);
        if (preBooking!=null){
            preBooking.setNextId(bookingEntity.getId());
        }
        if (nextBooking!=null){
            nextBooking.setPreId(bookingEntity.getId());
        }
        bookingRepository.flush();  //update end

        //main order
        orderEntity = orderRepository.save(orderEntity);

        if (orderEntity.getId() > 222) {
            //customer relation
            RtOrderCustomerEntity orderCustomerEntity = new RtOrderCustomerEntity();
            orderCustomerEntity.setOrderId(orderEntity.getId());
            orderCustomerEntity.setCustomerId(customerEntity.getId());
            orderCustomerEntityRepository.save(orderCustomerEntity);

            //price item relation
            for (RtOrderPriceEntity orderPriceEntity : priceDetail.getDetail()) {
                orderPriceEntity.setOrderId(orderEntity.getId());
            }
            List<RtOrderPriceEntity> list = orderPriceEntityIntegerBaseRepository.saveAll(priceDetail.getDetail());

            //state relation
            orderStateEntityIntegerBaseRepository.save(new RtOrderStateEntity(orderEntity.getId(),
                    1, "OrderSystem"));
            return orderEntity;
        } else {
            throw new NullPointerException("订单插入失败，执行回滚");
        }
    }

    @Transactional
    public OrderSubmitResult submitOrder(String token, OrderSubmitForm map) {
        OrderSubmitResult orderSubmitResult;
        String username = JwtTokenUtils.getUsername(token);
        RtUserEntity userEntity = userRepository.findByUsername(username);

        //check rentAble
        int carId = (int) map.getCarId();
        int start = map.getStart();
        int end = map.getEnd();
        Long startDate = map.getStartDate();
        Long endDate = map.getEndDate();
        Timestamp startTime = Converter.toTimestamp(startDate);
        Timestamp endTime = Converter.toTimestamp(endDate);
        int days = Converter.diffDays(startDate, endDate);

        //booking
        boolean bookingExist = bookingRepository.existsByCarId(carId);
        List<RtBookingEntity> list = null;
        RtBookingEntity preBooking = null;
        RtBookingEntity nextBooking = null;
        if (bookingExist){
            list = carRepository.isRentAble(map.getCarId(),startTime,days);
            if (list.size()<=0){
                return new OrderSubmitResult(ResponseEnums.RESOURCE_UNAVAILABLE);
            }
            preBooking = list.get(0);
            if (preBooking.getNextId()!=-1){
                nextBooking = bookingRepository.getOne(preBooking.getNextId());
            }
        }

        //customer
        RtCustomerEntity customerEntity = new RtCustomerEntity(map.getName(), map.getCardId(), map.getPhone(), map.getEmail());
        if (!customerRepository.existsByCardId(customerEntity.getCardId())) {
            customerEntity = customerRepository.saveAndFlush(customerEntity);
        }

        //re calc price
        OrderPriceDetail priceDetail = queryOrderDetail(carId, startDate, endDate, start, end);

        //create order
        RtOrderEntity orderEntity = new RtOrderEntity(userEntity.getId(), priceDetail.getTotal(), days,
                priceDetail.getFetchCarDate(), priceDetail.getReturnCarDate(), carId, 1, true);

        //if car rent able
        RtOrderEntity submitOrderEntity = submit(priceDetail, orderEntity, customerEntity,preBooking,nextBooking);
        if (submitOrderEntity != null) {
            orderSubmitResult = new OrderSubmitResult(submitOrderEntity.getId(), submitOrderEntity.getCreatedDate());
        } else {
            orderSubmitResult = new OrderSubmitResult(ResponseEnums.DATABASE_ERROR);
        }
        return orderSubmitResult;
    }
}
