package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtStoresEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends BaseRepository<RtStoresEntity,Integer> {
    public List<RtStoresEntity> findRtStoresEntitiesByAreaId(@Param("area_id")int areaID);

    @Query(value = "SELECT COUNT(*) FROM rt_order WHERE start_store_id=:id " +
            "union " +
            "SELECT COUNT(*) FROM rt_stores " +
            "union " +
            "SELECT count(*) FROM rt_order WHERE start_store_id=:id AND rt_order.pay_date is not NULL",nativeQuery = true)
    List<Long> fetchRanking(@Param("id") int id);
}
