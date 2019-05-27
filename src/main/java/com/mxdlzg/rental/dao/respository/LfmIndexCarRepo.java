package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtvLfmIndexCarEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface LfmIndexCarRepo extends BaseRepository<RtvLfmIndexCarEntity,Integer> {
    Page<RtvLfmIndexCarEntity> findByUserIdOrderByUpdateAtDesc(long userId, Pageable pageable);
}
