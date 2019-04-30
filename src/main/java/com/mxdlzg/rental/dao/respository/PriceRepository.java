package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtPriceEntity;

import java.util.List;

public interface PriceRepository extends BaseRepository<RtPriceEntity,Integer> {
    public List<RtPriceEntity> findAllByCarId(int carId);
}
