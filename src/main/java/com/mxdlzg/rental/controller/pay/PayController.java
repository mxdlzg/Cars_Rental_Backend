package com.mxdlzg.rental.controller.pay;

import com.mxdlzg.rental.dao.service.OrderService;
import com.mxdlzg.rental.dao.service.PayService;
import com.mxdlzg.rental.domain.model.OrderPayInfo;
import com.mxdlzg.rental.domain.model.RestResult;
import com.mxdlzg.rental.domain.model.enums.ResponseEnums;
import com.mxdlzg.rental.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

@RestController
public class PayController {
    @Autowired
    OrderService orderService;
    @Autowired
    PayService payService;

    @GetMapping("/api/order/queryPayInfo")
    public RestResult<OrderPayInfo> queryPayInfo(@RequestParam(value = "id")Integer id){
        OrderPayInfo payInfo = orderService.getOrderPayInfo(id);
        RestResult<OrderPayInfo> restResult;
        if (payInfo!=null){
            restResult = new RestResult<>(payInfo);
        }else {
            restResult = new RestResult<>(false, ResponseEnums.SYSTEM_ERROR);
        }
        return restResult;
    }

    @PutMapping("/api/pay/payment")
    public RestResult<?> payment(@RequestHeader("Authorization") String token,
                                 @RequestParam(value = "id")int id){
        int userId = JwtTokenUtils.getUserId(token);

        return new RestResult<>(payService.payment(id,userId));
    }

    @PutMapping("/api/pay/checkout")
    public RestResult<?> checkout(@RequestParam(value = "id")Integer id){

        return null;
    }

}
