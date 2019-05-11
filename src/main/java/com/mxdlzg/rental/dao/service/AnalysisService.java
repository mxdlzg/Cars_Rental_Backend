package com.mxdlzg.rental.dao.service;

import com.mxdlzg.rental.dao.respository.AccessAnalysisRepo;
import com.mxdlzg.rental.dao.respository.AnalysisRepository;
import com.mxdlzg.rental.dao.respository.PageAccessRepository;
import com.mxdlzg.rental.domain.entity.RtvAnalysisDaySaleEntity;
import com.mxdlzg.rental.domain.model.AnalysisOverview;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.sql.Timestamp;
import java.util.List;

@Service
public class AnalysisService {
    @Autowired
    AnalysisRepository analysisRepository;
    @Autowired
    PageAccessRepository pageAccessRepository;
    @Autowired
    AccessAnalysisRepo accessAnalysisRepo;

    public AnalysisOverview queryOverview(){
        RtvAnalysisDaySaleEntity saleEntity = analysisRepository.findTopByDayTime();
        AnalysisOverview overview = analysisRepository.statisticTotal();
        overview.setTodaySale(saleEntity.getDayTotal());
        overview.setTodayPaidCount(saleEntity.getDayPaidCount());
        overview.setTodayAccess(pageAccessRepository.todayCount());
        overview.setTotalAccess(pageAccessRepository.count());

        //detail
        overview.setAccessDetailList(accessAnalysisRepo.findTop14ByOrderByDate());
        overview.setPaidDetailList(analysisRepository.findTop14ByOrderByDayTime());
        return overview;
    }

}
