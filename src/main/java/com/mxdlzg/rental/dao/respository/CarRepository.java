package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtCarEntity;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface CarRepository extends BaseRepository<RtCarEntity,Long> {
    List<RtCarEntity> findRtCarEntitiesByLatestAvailableDateAfterAndStoreId(Timestamp latestAvailableDate,int id);
}
