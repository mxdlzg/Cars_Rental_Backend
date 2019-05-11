package com.mxdlzg.rental.controller.management;

import com.mxdlzg.rental.dao.service.AnalysisService;
import com.mxdlzg.rental.domain.model.AnalysisOverview;
import com.mxdlzg.rental.domain.model.RestResult;
import com.mxdlzg.rental.domain.model.SalesCard;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnalysisController {
    @Autowired
    AnalysisService analysisService;

    @GetMapping("/api/analysis/overview")
    public RestResult<AnalysisOverview> overview(){
        return new RestResult<>(analysisService.queryOverview());
    }

    @GetMapping("/api/analysis/saleStatistic")
    public RestResult<SalesCard> salesCard(@RequestParam("type")String type,
                                           @RequestParam(value = "start",required = false)Long start,
                                           @RequestParam(value = "end",required = false)Long end){

        return new RestResult<SalesCard>(analysisService.querySalesCard(type,start,end));
    }

}
