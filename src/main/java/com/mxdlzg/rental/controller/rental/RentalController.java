package com.mxdlzg.rental.controller.rental;

import com.mxdlzg.rental.dao.service.RentalService;
import com.mxdlzg.rental.dao.service.StoreService;
import com.mxdlzg.rental.domain.model.FilterParams;
import com.mxdlzg.rental.domain.model.RestResult;
import com.mxdlzg.rental.domain.model.enums.ResponseEnums;
import org.apache.catalina.core.ApplicationContext;
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
    @Autowired
    RentalService rentalService;

    @GetMapping("/filter-conditions")
    public RestResult<?> queryFilter() {
        FilterParams filterParams = rentalService.queryFilter();
        return null;
    }

    @GetMapping("/stores")
    public RestResult<?> queryStores(@RequestParam("1") int province,
                                     @RequestParam("2") int city,
                                     @RequestParam("3") int area) {
        List<?> list = storeService.fetchStores(area);
        return new RestResult<List<?>>(list);
    }

}
