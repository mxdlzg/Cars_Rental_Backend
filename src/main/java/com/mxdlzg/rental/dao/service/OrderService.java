package com.mxdlzg.rental.dao.service;

import com.mxdlzg.rental.dao.respository.*;
import com.mxdlzg.rental.domain.entity.*;
import com.mxdlzg.rental.domain.model.*;
import com.mxdlzg.rental.domain.model.enums.ResponseEnums;
import com.mxdlzg.rental.utils.Converter;
import com.mxdlzg.rental.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

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
    @Autowired
    OrderCustomerRepository orderCustomerRepository;
    @Autowired
    OrderPriceRepository orderPriceRepository;
    @Autowired
    OrderStateRepository orderStateRepository;

    //view
    @Autowired
    OrderPayInfoRepo orderPayInfoRepo;
    @Autowired
    OrderCarInfoRepo orderCarInfoRepo;
    @Autowired
    StateCurrentRepo stateCurrentRepo;

    public OrderPriceDetail queryOrderRentDetail(int carId, Long startDate, Long endDate, int start, int end) {
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

    private RtOrderEntity submit(OrderPriceDetail priceDetail, RtOrderEntity orderEntity, RtCustomerEntity customerEntity, RtBookingEntity preBooking, RtBookingEntity nextBooking) {
        //upsssssssssssdate booking
        RtBookingEntity bookingEntity = new RtBookingEntity();
        bookingEntity.setBelongUserId(orderEntity.getBelongUserId());
        bookingEntity.setCarId(orderEntity.getCarId());
        bookingEntity.setStartDate(orderEntity.getStartDate());
        bookingEntity.setEndDate(orderEntity.getEndDate());
        bookingEntity.setRentDays(orderEntity.getRentDays());
        bookingEntity.setPreId(preBooking == null ? -1 : preBooking.getId());
        bookingEntity.setNextId(nextBooking == null ? -1 : nextBooking.getId());
        if (preBooking != null) {
            preBooking.setNextId(bookingEntity.getId());
            int preMidDays = Converter.diffDays(preBooking.getEndDate().getTime() * 1000, bookingEntity.getStartDate().getTime() * 1000);
            preBooking.setNextSpaceDays(preBooking.getNextSpaceDays() - preMidDays);
        }
        if (nextBooking != null) {
            nextBooking.setPreId(bookingEntity.getId());
            int midNextDays = Converter.diffDays(bookingEntity.getEndDate().getTime() * 1000, nextBooking.getStartDate().getTime() * 1000);
            bookingEntity.setNextSpaceDays(midNextDays);
        }
        bookingEntity = bookingRepository.save(bookingEntity);
        bookingRepository.flush();  //update end

        //main order
        orderEntity = orderRepository.save(orderEntity);

        if (orderEntity.getId() > 0) {
            //customer relation
            RtOrderCustomerEntity orderCustomerEntity = new RtOrderCustomerEntity();
            orderCustomerEntity.setOrderId(orderEntity.getId());
            orderCustomerEntity.setCustomerId(customerEntity.getId());
            orderCustomerRepository.save(orderCustomerEntity);

            //price item relation
            for (RtOrderPriceEntity orderPriceEntity : priceDetail.getDetail()) {
                orderPriceEntity.setOrderId(orderEntity.getId());
            }
            List<RtOrderPriceEntity> list = orderPriceRepository.saveAll(priceDetail.getDetail());

            //state relation
            orderStateRepository.save(new RtOrderStateEntity(orderEntity.getId(),
                    1, "OrderSystem"));
            return orderEntity;
        } else {
            throw new IndexOutOfBoundsException("订单插入失败，执行回滚");
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
        if (bookingExist) {
            list = carRepository.isRentAble(map.getCarId(), startTime, days);
            if (list.size() <= 0) {
                return new OrderSubmitResult(ResponseEnums.RESOURCE_UNAVAILABLE);
            }
            preBooking = list.get(0);
            if (preBooking.getNextId() != -1) {
                nextBooking = bookingRepository.getOne(preBooking.getNextId());
            }
        }

        //customer
        RtCustomerEntity customerEntity = new RtCustomerEntity(map.getName(), map.getCardId(), map.getPhone(), map.getEmail());
        if (!customerRepository.existsByCardId(customerEntity.getCardId())) {
            customerEntity = customerRepository.save(customerEntity);
        } else {
            customerEntity = customerRepository.findByCardId(customerEntity.getCardId());
        }

        //re calc price(service)
        OrderPriceDetail priceDetail = queryOrderRentDetail(carId, startDate, endDate, start, end);

        //create order( default state =-----> 1<ORDER_STATE_ORDERED>)
        RtOrderEntity orderEntity = new RtOrderEntity(userEntity.getId(), priceDetail.getTotal(), days,
                priceDetail.getFetchCarDate(), priceDetail.getReturnCarDate(), carId, 1, true);
        orderEntity.setCreatedDate(new Timestamp(new Date().getTime()));
        orderEntity.setStartStoreId(map.getStart());
        orderEntity.setEndStoreId(map.getEnd());


        //if car rent able
        RtOrderEntity submitOrderEntity = submit(priceDetail, orderEntity, customerEntity, preBooking, nextBooking);
        if (submitOrderEntity != null) {
            orderSubmitResult = new OrderSubmitResult(submitOrderEntity.getId(), submitOrderEntity.getCreatedDate());
        } else {
            orderSubmitResult = new OrderSubmitResult(ResponseEnums.DATABASE_ERROR);
        }
        return orderSubmitResult;
    }

    public OrderPayInfo getOrderPayInfo(Integer id) {
        RtvOrderPayInfoEntity infoEntity = orderPayInfoRepo.getOne(id);
        return OrderPayInfo.valueOf(infoEntity);
    }

    public Page<RtvOrderCarInfoEntity> queryOrderList(String name, int page) {
        RtUserEntity userEntity = userRepository.findByUsername(name);
        return orderCarInfoRepo.findAllByBelongUserId(userEntity.getId(), PageRequest.of(page, 10));
    }


    /**
     * query order detail
     *
     * @param userId user id
     * @param id     order id
     * @return order
     */
    public OrderDetail queryOrderDetail(int userId, int id) {
        OrderDetail orderDetail = null;
        RtOrderEntity orderEntity = orderRepository.findByBelongUserIdAndId(userId, id);
        if (orderEntity != null) {
            RtvStateCurrentEntity currentEntity = stateCurrentRepo.findByOrderIdAndStateId(orderEntity.getId(), orderEntity.getCurrentStateId());
            //new result
            orderDetail = new OrderDetail(currentEntity.getCurrent(),currentEntity.getChangedDate());
            //user info
            List<RtCustomerEntity> customerEntityList = customerRepository.findAllByOrderId(orderEntity.getId());
            orderDetail.setUserInfo(customerEntityList);
            //location
            List<RtStoresEntity> stores = storeRepository.findAllById(Arrays.asList(orderEntity.getStartStoreId(),orderEntity.getEndStoreId()));
            RtStoresEntity start = stores.get(0);
            orderDetail.setStartLocation(start.getId(),start.getName(),start.getLocation(),"",orderEntity.getStartDate());
            if (!orderEntity.getStartStoreId().equals(orderEntity.getEndStoreId())){
                RtStoresEntity end = stores.get(1);
                orderDetail.setEndLocation(end.getId(),end.getName(),end.getLocation(),"",orderEntity.getEndDate());
            }else {
                //same with start
                orderDetail.setEndLocation();
            }
        }
        return orderDetail;
    }
}
