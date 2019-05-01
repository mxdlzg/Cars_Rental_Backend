package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtOrderEntity;
import org.springframework.stereotype.Repository;

@Repository
public interface OrderRepository extends BaseRepository<RtOrderEntity,Integer> {
}
