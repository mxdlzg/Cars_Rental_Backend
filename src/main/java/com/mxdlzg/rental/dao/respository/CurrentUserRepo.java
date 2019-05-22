package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtCurrentUserEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface CurrentUserRepo extends BaseRepository<RtCurrentUserEntity,Integer> {
    RtCurrentUserEntity findByUserId(int id);
}
