package com.mxdlzg.rental.controller.management;

import com.mxdlzg.rental.dao.service.AnalysisService;
import com.mxdlzg.rental.domain.model.AnalysisOverview;
import com.mxdlzg.rental.domain.model.RestResult;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class AnalysisController {
    @Autowired
    AnalysisService analysisService;

    @GetMapping("/api/analysis/overview")
    public RestResult<AnalysisOverview> overview(){
        return new RestResult<>(analysisService.queryOverview());
    }
}
