package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtBookingEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface BookingRepository extends BaseRepository<RtBookingEntity,Integer> {
    boolean existsByCarId(int carId);
    RtBookingEntity getById(int id);
}
