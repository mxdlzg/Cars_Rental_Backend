package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtvOrderCarInfoEntity;
import com.mxdlzg.rental.domain.model.OptionsKV;
import com.mxdlzg.rental.domain.model.OptionsXY;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;

import java.sql.Timestamp;
import java.util.List;

public interface OrderCarInfoRepo extends BaseRepository<RtvOrderCarInfoEntity,Integer> {
    Page<RtvOrderCarInfoEntity> findAllByBelongUserIdOrderByCreatedDateDesc(int id, Pageable pageable);

    @Query("select new com.mxdlzg.rental.domain.model.OptionsKV(r.storeName,sum (r.totalPrice)) from RtvOrderCarInfoEntity r where r.createdDate>=WEEK(NOW()) group by r.startStoreId")
    List<OptionsKV<Double>> statisticDetailRankingWeek();

    @Query("select new com.mxdlzg.rental.domain.model.OptionsKV(r.storeName,sum (r.totalPrice)) from RtvOrderCarInfoEntity r where r.createdDate>=MONTH(NOW()) group by r.startStoreId")
    List<OptionsKV<Double>> statisticDetailRankingMonth();

    @Query("select new com.mxdlzg.rental.domain.model.OptionsKV(r.storeName,sum (r.totalPrice)) from RtvOrderCarInfoEntity r where r.createdDate>=YEAR(NOW()) group by r.startStoreId")
    List<OptionsKV<Double>> statisticDetailRankingYear();

    @Query("select new com.mxdlzg.rental.domain.model.OptionsKV(r.storeName,sum (r.totalPrice)) from RtvOrderCarInfoEntity r where r.createdDate>=:start and r.createdDate<=:end group by r.startStoreId")
    List<OptionsKV<Double>> statisticDetailRankingBetween(@Param("start")Timestamp start, @Param("end")Timestamp end);

    @Query("select new com.mxdlzg.rental.domain.model.OptionsXY(r.brandName,count(r)) from RtvOrderCarInfoEntity r group by r.brandName order by count(r) desc")
    List<OptionsXY<Long>> querySalesType();

}
