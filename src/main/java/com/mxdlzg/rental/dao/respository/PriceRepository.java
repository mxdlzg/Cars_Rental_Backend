package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtPriceEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PriceRepository extends BaseRepository<RtPriceEntity,Integer> {
    public List<RtPriceEntity> findAllByCarId(int carId);
}
