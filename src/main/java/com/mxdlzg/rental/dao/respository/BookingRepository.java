package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtBookingEntity;

public interface BookingRepository extends BaseRepository<RtBookingEntity,Integer> {
    boolean existsByCarId(int carId);
}
