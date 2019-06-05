package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtvOrderEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface RtvOrderRepo extends BaseRepository<RtvOrderEntity,Integer>{
    RtvOrderEntity findByBelongUserIdAndId(int userId,int orderId);
    RtvOrderEntity findById(int id);
}
