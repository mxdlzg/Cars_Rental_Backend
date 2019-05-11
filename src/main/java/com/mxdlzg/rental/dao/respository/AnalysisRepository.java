package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtvAnalysisDaySaleEntity;
import com.mxdlzg.rental.domain.model.AnalysisOverview;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;

public interface AnalysisRepository extends BaseRepository<RtvAnalysisDaySaleEntity,Integer> {

    @Query("select rv from RtvAnalysisDaySaleEntity rv where rv.dayTime>=CURDATE()")
    RtvAnalysisDaySaleEntity findTopByDayTime();

    @Query("select new com.mxdlzg.rental.domain.model.AnalysisOverview(sum(rv.dayTotal),sum(rv.dayPaidCount)) from RtvAnalysisDaySaleEntity rv")
    AnalysisOverview statisticTotal();
}
