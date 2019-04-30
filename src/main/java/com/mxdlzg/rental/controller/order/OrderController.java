package com.mxdlzg.rental.controller.order;

import com.mxdlzg.rental.dao.service.OrderService;
import com.mxdlzg.rental.dao.service.RentalService;
import com.mxdlzg.rental.domain.entity.RtCarEntity;
import com.mxdlzg.rental.domain.model.OrderPriceDetail;
import com.mxdlzg.rental.domain.model.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import java.util.Map;

@RestController
public class OrderController {
    @Autowired
    RentalService rentalService;
    @Autowired
    OrderService orderService;

    @GetMapping(value = "/api/car/{carId}")
    public RestResult<RtCarEntity> queryCarDetail(@PathVariable int carId) {
        // TODO: 2019/4/30 处理query null 情况
        return new RestResult<RtCarEntity>(rentalService.queryCarDetail(carId));
    }

    @GetMapping("/api/order/queryPrice")
    public RestResult<OrderPriceDetail> queryPrice(@RequestParam("carId")int carId,
                                                   @RequestParam("startDate")long startDate,
                                                   @RequestParam("endDate")long endDate,
                                                   @RequestParam("start")int start,
                                                   @RequestParam("end")int end){
        OrderPriceDetail detail = orderService.queryOrderDetail(carId,startDate,endDate,start,end);

        return new RestResult<>(detail);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/api/order/submitOrder")
    public RestResult<?> submitOrder(@RequestHeader("Authorization") String token, @RequestBody Map<String,Object> map){
        orderService.submitOrder(token,map);
        return new RestResult<>(null);
    }
}
