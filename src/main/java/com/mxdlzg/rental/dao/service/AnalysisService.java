package com.mxdlzg.rental.dao.service;

import com.mxdlzg.rental.dao.respository.*;
import com.mxdlzg.rental.domain.entity.RtvAnalysisDaySaleEntity;
import com.mxdlzg.rental.domain.model.AnalysisOverview;
import com.mxdlzg.rental.domain.model.OptionsKV;
import com.mxdlzg.rental.domain.model.SalesCard;
import com.mxdlzg.rental.utils.Converter;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Collections;
import java.util.Comparator;
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
    @Autowired
    OrderCarInfoRepo orderCarInfoRepo;

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

    public SalesCard querySalesCard(String type, Long start, Long end) {
        //sales
        List<OptionsKV> sales = null;
        //ranking
        List<OptionsKV<Double>> storesRanking = null;
        switch (type){
            case "week":
                sales = analysisRepository.statisticDetailWeek();
                storesRanking = orderCarInfoRepo.statisticDetailRankingWeek();
                break;
            case "month":
                sales = analysisRepository.statisticDetailMonth();
                storesRanking = orderCarInfoRepo.statisticDetailRankingMonth();
                break;
            case "year":
                sales = analysisRepository.statisticDetailYear();
                storesRanking = orderCarInfoRepo.statisticDetailRankingYear();
                break;
                default:
                    sales = analysisRepository.statisticDetailBetween(Converter.toTimestamp(start),Converter.toTimestamp(end));
                    break;
        }
        storesRanking.sort(new Comparator<OptionsKV<Double>>() {
            @Override
            public int compare(OptionsKV<Double> o1, OptionsKV<Double> o2) {
                return o1.getValue()>o2.getValue()?1:0;
            }
        });

        return new SalesCard(sales,storesRanking);
    }
}
