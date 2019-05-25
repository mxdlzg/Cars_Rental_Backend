package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtvAnalysisDaySaleEntity;
import com.mxdlzg.rental.domain.model.AnalysisOverview;
import com.mxdlzg.rental.domain.model.OptionsKV;
import com.mxdlzg.rental.domain.model.OptionsXY;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface AnalysisRepository extends BaseRepository<RtvAnalysisDaySaleEntity,Integer> {

    @Query("select rv from RtvAnalysisDaySaleEntity rv where rv.dayTime>=CURDATE()")
    RtvAnalysisDaySaleEntity findTopByDayTime();

    @Query("select new com.mxdlzg.rental.domain.model.AnalysisOverview(sum(rv.dayTotal),sum(rv.dayPaidCount)) from RtvAnalysisDaySaleEntity rv")
    AnalysisOverview statisticTotal();

    List<RtvAnalysisDaySaleEntity> findTop14ByOrderByDayTime();

    @Query("select new com.mxdlzg.rental.domain.model.OptionsXY(r.dayOfWeek,r.dayPaidCount,'week') from RtvAnalysisDaySaleEntity r where WEEK(r.dayTime)>=WEEK(NOW())")
    List<OptionsXY> statisticDetailWeek();

    @Query("select new com.mxdlzg.rental.domain.model.OptionsXY(r.dayOfMonth,r.dayPaidCount,'month') from RtvAnalysisDaySaleEntity r where MONTH(r.dayTime)>=MONTH(NOW())")
    List<OptionsXY> statisticDetailMonth();

    @Query("select new com.mxdlzg.rental.domain.model.OptionsXY(r.monthOfYear,r.dayPaidCount,'year') from RtvAnalysisDaySaleEntity r where YEAR(r.dayTime)>=YEAR(NOW())")
    List<OptionsXY> statisticDetailYear();

    @Query("select new com.mxdlzg.rental.domain.model.OptionsXY(r.dayOfMonth,r.dayPaidCount,'month') from RtvAnalysisDaySaleEntity r where r.dayTime>=:start and r.dayTime<=:end")
    List<OptionsXY> statisticDetailBetween(@Param("start")Timestamp start, @Param("end")Timestamp end);
}
