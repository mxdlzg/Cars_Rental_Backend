package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtvStrategyEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface StrategyPostRepo extends BaseRepository<RtvStrategyEntity,Integer> {
    Page<RtvStrategyEntity> findByOrderByUpadteAtDesc(Pageable pageable);
}
