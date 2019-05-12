package com.mxdlzg.rental.dao.service;

import com.fasterxml.jackson.databind.exc.InvalidDefinitionException;
import com.mxdlzg.rental.dao.respository.*;
import com.mxdlzg.rental.domain.entity.*;
import com.mxdlzg.rental.domain.model.OrderPayInfo;
import com.mxdlzg.rental.domain.model.PayResult;
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
}
