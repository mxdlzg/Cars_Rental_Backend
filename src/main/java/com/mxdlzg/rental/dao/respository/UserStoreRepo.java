package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtvUserStoreEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface UserStoreRepo extends BaseRepository<RtvUserStoreEntity,Integer> {
    List<RtvUserStoreEntity> findAllByUserId(int user);
    RtvUserStoreEntity findByStoreIdAndUserId(int storeId,int userId);
}
