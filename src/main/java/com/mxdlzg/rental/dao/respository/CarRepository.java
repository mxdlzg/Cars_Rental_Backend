package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtBookingEntity;
import com.mxdlzg.rental.domain.entity.RtCarEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.persistence.criteria.CriteriaBuilder;
import java.sql.Timestamp;
import java.util.List;

@Repository
public interface CarRepository extends BaseRepository<RtCarEntity, Integer> {

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

    @Query(value = "select book from RtBookingEntity book where book.carId=:id and book.endDate<:start and book.nextSpaceDays>=:days")
    List<RtBookingEntity> isRentAble(@Param("id") Integer carId, @Param("start") Timestamp startTime, @Param("days") int days);
}
