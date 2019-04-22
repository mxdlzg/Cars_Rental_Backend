package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtStoresEntity;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StoreRepository extends BaseRepository<RtStoresEntity,Long> {
    public List<RtStoresEntity> findRtStoresEntitiesByAreaId(@Param("area_id")int areaID);
}
