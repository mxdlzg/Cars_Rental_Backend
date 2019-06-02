package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtvCarEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface RtvCarRepo extends BaseRepository<RtvCarEntity,Integer> {
    RtvCarEntity findById(int id);
    List<RtvCarEntity> findAllByStoreId(int storeId);
    List<RtvCarEntity> findAllByStoreIdAndTypeNameLike(Integer storeId, String typeName);
    List<RtvCarEntity> findAllByStoreIdAndRentAbleAndTypeNameLike(Integer storeId, boolean rentAble, String typeName);
}
