package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtvCarEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface RtvCarRepo extends BaseRepository<RtvCarEntity,Integer> {
    RtvCarEntity findById(int id);
}
