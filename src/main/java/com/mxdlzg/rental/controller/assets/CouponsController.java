package com.mxdlzg.rental.controller.assets;

import com.mxdlzg.rental.dao.service.AssetsService;
import com.mxdlzg.rental.domain.entity.RtvOrderCarInfoEntity;
import com.mxdlzg.rental.domain.entity.RtvUserCouponsEntity;
import com.mxdlzg.rental.domain.model.RestResult;
import com.mxdlzg.rental.domain.model.enums.ResponseEnums;
import com.mxdlzg.rental.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class CouponsController {
    @Autowired
    AssetsService assetsService;

    @GetMapping("/api/assets/queryCouponsList")
    public RestResult<?> queryCouponsList(@RequestHeader("Authorization") String token,
                                          @RequestParam("name") String name,
                                          @RequestParam("page") int page) {
        RestResult<?> restResult = null;
        if (JwtTokenUtils.isValidUser(name,token)){
            Page<RtvUserCouponsEntity> list = assetsService.queryCouponsList(name,page);
            restResult = new RestResult<>(list);
        }else {
            restResult = new RestResult<>(false, ResponseEnums.INVALID_USER);
        }
        return restResult;
    }
}
