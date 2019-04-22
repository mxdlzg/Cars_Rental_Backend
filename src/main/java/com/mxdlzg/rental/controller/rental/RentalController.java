package com.mxdlzg.rental.controller.rental;

import com.mxdlzg.rental.dao.service.StoreService;
import com.mxdlzg.rental.domain.model.RestResult;
import com.mxdlzg.rental.domain.model.enums.ResponseEnums;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;
import java.util.Map;

@RestController
@RequestMapping("/api/rental")
public class RentalController {
    @Autowired
    StoreService storeService;

    @GetMapping("/stores")
    public RestResult<?> queryStores(@RequestParam("1") String province,
                                                 @RequestParam("2") String area,
                                                 @RequestParam("3") int city) {
        List<?> list = storeService.fetchStores(city);
        return new RestResult<List<?>>(list);
    }
}
