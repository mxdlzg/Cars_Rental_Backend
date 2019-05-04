package com.mxdlzg.rental.controller.order;

import com.mxdlzg.rental.dao.service.OrderService;
import com.mxdlzg.rental.dao.service.RentalService;
import com.mxdlzg.rental.domain.entity.RtCarEntity;
import com.mxdlzg.rental.domain.entity.RtvOrderCarInfoEntity;
import com.mxdlzg.rental.domain.model.*;
import com.mxdlzg.rental.domain.model.enums.ResponseEnums;
import com.mxdlzg.rental.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

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
    public RestResult<OrderPriceDetail> queryPrice(@RequestParam("carId") int carId,
                                                   @RequestParam("startDate") long startDate,
                                                   @RequestParam("endDate") long endDate,
                                                   @RequestParam("start") int start,
                                                   @RequestParam("end") int end) {
        OrderPriceDetail detail = orderService.queryOrderRentDetail(carId, startDate, endDate, start, end);

        return new RestResult<>(detail);
    }

    @PreAuthorize("hasRole('USER')")
    @PostMapping("/api/order/submitOrder")
    public RestResult<OrderSubmitResult> submitOrder(@RequestHeader("Authorization") String token,
                                                     @Validated
                                                     @RequestBody OrderSubmitForm form,
                                                     BindingResult validatorResult) {

        if (!validatorResult.hasErrors()) {
            OrderSubmitResult result = orderService.submitOrder(token, form);
            if (result.isSuccess()) {
                return new RestResult<>(result);
            } else {
                return new RestResult<>(false, result.getEnums());
            }
        } else {
            return new RestResult<>(false, ResponseEnums.PARAMS_ERROR);
        }
    }

    @GetMapping("/api/order/queryOrderList")
    public RestResult<?> orderList(@RequestHeader("Authorization") String token,
                                   @RequestParam("name") String name,
                                   @RequestParam("page") int page) {
        RestResult<?> restResult = null;

        if (JwtTokenUtils.isValidUser(name, token)) {
            Page<RtvOrderCarInfoEntity> list = orderService.queryOrderList(name, page);
            restResult = new RestResult<>(list);
        } else {
            restResult = new RestResult<>(false, ResponseEnums.INVALID_USER);
        }
        return restResult;
    }

    @GetMapping("/api/order/orderDetail")
    public RestResult<?> orderDetail(@RequestHeader("Authorization") String token,
                                     @RequestParam("id") int id) {
        int userId = JwtTokenUtils.getUserId(token);
        RestResult<OrderDetail> restResult = null;
        OrderDetail orderDetail = orderService.queryOrderDetail(userId, id);
        if (orderDetail.isSuccess()) {
            restResult = new RestResult<>(orderDetail);
        } else {
            restResult = new RestResult<>(false,orderDetail.getEnums());
        }
        return restResult;
    }
}
