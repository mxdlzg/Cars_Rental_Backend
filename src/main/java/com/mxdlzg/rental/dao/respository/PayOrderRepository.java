package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtPayOrderEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface PayOrderRepository extends BaseRepository<RtPayOrderEntity,Integer> {
    RtPayOrderEntity findByOrderId(int id);
}
