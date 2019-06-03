package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtOrderCommentsEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderCommentsRepository extends BaseRepository<RtOrderCommentsEntity,Integer> {
    RtOrderCommentsEntity findByUserIdAndOrderId(int userId,int orderId);
}
