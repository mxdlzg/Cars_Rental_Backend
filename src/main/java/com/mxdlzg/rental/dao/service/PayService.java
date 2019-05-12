package com.mxdlzg.rental.dao.service;

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.mxdlzg.rental.dao.respository.*;
import com.mxdlzg.rental.domain.entity.*;
import com.mxdlzg.rental.domain.model.CheckoutResult;
import com.mxdlzg.rental.domain.model.OrderPayInfo;
import com.mxdlzg.rental.domain.model.PayResult;
import com.mxdlzg.rental.utils.Pair;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.sql.Timestamp;
import java.util.Date;

@Service
public class PayService {
    @Autowired
    NotifyRepository notifyRepository;
    @Autowired
    OrderService orderService;
    @Autowired
    InvoiceRepository invoiceRepository;
    @Autowired
    PayOrderRepository payOrderRepository;
    @Autowired
    OrderRepository orderRepository;
    @Autowired
    OrderStateRepository orderStateRepository;
    @Autowired
    UserService userService;
    @Autowired
    CheckoutRepository checkoutRepository;

    @Transactional(rollbackFor = Exception.class)
    public PayResult payment(int id, int userId){
        //info
        OrderPayInfo orderPayInfo = orderService.getOrderPayInfo(id);
        //check
        if (orderPayInfo.isFinished()){
            return PayResult.hasFinished();
        }

        //do pay
        //order
        RtOrderEntity orderEntity = orderRepository.getOne(id);
        if (!orderEntity.getValid()){
            return new PayResult(false,"无效的订单");
        }

        orderEntity.setTypeId(4);
        orderEntity.setCurrentStateId(2);
        orderRepository.flush();
        //order state
        orderStateRepository.save(new RtOrderStateEntity(orderEntity.getId(),2,"PaySystem"));
        //order pay
        RtPayOrderEntity payOrderEntity = payOrderRepository.findByOrderId(orderEntity.getId());
        payOrderEntity.setFinished(true);
        payOrderEntity.setPayDate(new Timestamp(new Date().getTime()));
        payOrderRepository.flush();
        //user
        userService.increaseIntegral(userId,5);
        //invoice
        invoiceRepository.save(new RtInvoiceEntity("普通增值税发票",orderPayInfo.getInvoiceType(),orderEntity.getId()));
        //notify
        notifyRepository.save(new RtNotifyEntity("订单支付成功",
                "订单"+orderEntity.getId()+"支付成功，详情请点击进入订单界面查询",
                "/order/OrderDetail?id="+orderEntity.getId(),
                userId));

        PayResult result = new PayResult(true,"支付成功");
        result.setRealPayPrice(orderPayInfo.getTotalPrice());
        return result;
    }

    @Transactional(rollbackFor = Exception.class)
    public CheckoutResult checkout(Integer id, int userId) {
        //order
        RtOrderEntity orderEntity = orderRepository.getOne(id);
        if (orderEntity.getTypeId() == 3){
            return new CheckoutResult(false,orderEntity.getTotalPrice(),"此订单已被结算，操作无效");
        }
        if (!orderEntity.getValid()){
            return new CheckoutResult(false,orderEntity.getTotalPrice(),"无效的订单");
        }
        orderEntity.setTypeId(3);
        orderEntity.setCurrentStateId(4);

        orderStateRepository.save(new RtOrderStateEntity(orderEntity.getId(),4,"PaySystem"));

        //user
        userService.increaseIntegral(userId,5);

        //invoice
        RtInvoiceEntity invoiceEntity = invoiceRepository.save(new RtInvoiceEntity("普通增值税发票-结算",3,orderEntity.getId()));

        //checkout
        checkoutRepository.save(new RtCheckoutEntity(orderEntity.getId(),orderEntity.getTotalPrice(),new Timestamp(new Date().getTime()),invoiceEntity.getId()));

        //notify
        notifyRepository.save(new RtNotifyEntity("订单结算成功",
                "订单"+orderEntity.getId()+"结算成功，详情请点击进入订单界面查询",
                "/order/OrderDetail?id="+orderEntity.getId(),
                userId));

        return new CheckoutResult(true,orderEntity.getTotalPrice(),"结算成功");
    }
}
