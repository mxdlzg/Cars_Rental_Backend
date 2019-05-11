package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtvAnalysisDaySaleEntity;
import com.mxdlzg.rental.domain.model.AnalysisOverview;
import com.mxdlzg.rental.domain.model.OptionsKV;
import org.springframework.data.jpa.repository.Query;

import java.sql.Timestamp;
import java.util.List;

public interface AnalysisRepository extends BaseRepository<RtvAnalysisDaySaleEntity,Integer> {

    @Query("select rv from RtvAnalysisDaySaleEntity rv where rv.dayTime>=CURDATE()")
    RtvAnalysisDaySaleEntity findTopByDayTime();

    @Query("select new com.mxdlzg.rental.domain.model.AnalysisOverview(sum(rv.dayTotal),sum(rv.dayPaidCount)) from RtvAnalysisDaySaleEntity rv")
    AnalysisOverview statisticTotal();

    List<RtvAnalysisDaySaleEntity> findTop14ByOrderByDayTime();
}
