package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtCarEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.sql.Timestamp;
import java.util.List;

@Repository
public interface CarRepository extends BaseRepository<RtCarEntity, Long> {
    List<RtCarEntity> findRtCarEntitiesByLatestAvailableDateAfterAndStoreId(Timestamp latestAvailableDate, int id);

    @Query(value = "select car from RtCarEntity car,RtBookingEntity book where car.storeId=:id and car.serviceTypeId=:type and " +
            "(car.latestAvailableDate<:start or " +
            "   (" +
            "       ((select count(b) from RtBookingEntity b where b.endDate<:start and b.nextSpaceDays>=:days)>0) " +
            "       and " +
            "       (car.id=book.carId)" +
            "   )" +
            ")"
    )
    Page<RtCarEntity> findRtCarEntitiesAvailableMore(@Param("start") Timestamp start, @Param("days") int days, @Param("id") int id, @Param("type") int type, Pageable pageable);
}
