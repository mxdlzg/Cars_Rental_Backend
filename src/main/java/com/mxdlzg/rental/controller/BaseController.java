package com.mxdlzg.rental.controller;

import com.mxdlzg.rental.dao.service.AccessPointService;
import com.mxdlzg.rental.domain.entity.RtPageAccessEntity;
import com.mxdlzg.rental.utils.JwtTokenUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class BaseController {
    @Autowired
    AccessPointService _accessPointService;

    protected String _token, _referer;

    @ModelAttribute
    public void buriedPoint(@RequestHeader("Authorization") String token,
                            @RequestHeader(value = "Referer", required = false) String referer) {
        this._token = token;
        this._referer = referer;
    }

    protected void doBury() {
        if (_referer != null) {
            int userId = JwtTokenUtils.getUserId(_token);
            _accessPointService.saveOne(new RtPageAccessEntity(_referer, 1, userId));
        }
    }

    protected void doGuestBury() {
        if (_referer != null)
            _accessPointService.saveOne(new RtPageAccessEntity(_referer, 1, 1));
    }
}
