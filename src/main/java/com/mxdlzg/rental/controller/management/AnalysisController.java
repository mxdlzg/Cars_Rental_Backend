package com.mxdlzg.rental.controller.management;

import com.mxdlzg.rental.dao.service.AnalysisService;
import com.mxdlzg.rental.domain.model.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.client.RestTemplate;

import java.io.IOException;
import java.util.List;

@RestController
public class AnalysisController {
    @Autowired
    AnalysisService analysisService;

    @GetMapping("/api/analysis/overview")
    public RestResult<AnalysisOverview> overview() {
        return new RestResult<>(analysisService.queryOverview());
    }

    @GetMapping("/api/analysis/saleStatistic")
    public RestResult<SalesCard> salesCard(@RequestParam("type") String type,
                                           @RequestParam(value = "start", required = false) Long start,
                                           @RequestParam(value = "end", required = false) Long end) {

        return new RestResult<SalesCard>(analysisService.querySalesCard(type, start, end));
    }

    @GetMapping("/api/analysis/saleType")
    public RestResult<List<OptionsKV<Long>>> salesType() {
        return new RestResult<List<OptionsKV<Long>>>(analysisService.querySalesType());
    }


    @GetMapping("/api/analysis/storesSale")
    public RestResult<List<OptionsKV<Float>>> storesSale() {
        return new RestResult<>(analysisService.queryStoreSale());
    }

    @GetMapping("/api/analysis/storesSale/{storeId}")
    public RestResult<List<StoreSalesChartData>> storesSaleDetail(@PathVariable Long storeId) {
        return new RestResult<>(analysisService.queryStoreSale(storeId));
    }

    @GetMapping("/api/recommendation/{userId}")
    public RestResult<?> recommendation(@PathVariable Long userId){
        return new RestResult<>(analysisService.queryRecommendation(userId));
    }
}
