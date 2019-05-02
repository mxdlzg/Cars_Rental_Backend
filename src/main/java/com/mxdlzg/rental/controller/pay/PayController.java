package com.mxdlzg.rental.controller.pay;

import com.mxdlzg.rental.dao.service.OrderService;
import com.mxdlzg.rental.domain.model.OrderPayInfo;
import com.mxdlzg.rental.domain.model.RestResult;
import com.mxdlzg.rental.domain.model.enums.ResponseEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class PayController {
    @Autowired
    OrderService orderService;

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

}
