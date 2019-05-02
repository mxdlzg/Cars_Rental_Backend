package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtvOrderCarInfoEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import java.util.List;

public interface OrderCarInfoRepo extends BaseRepository<RtvOrderCarInfoEntity,Integer> {
    Page<RtvOrderCarInfoEntity> findAllByBelongUserId(int id, Pageable pageable);
}
