package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtvStateCurrentEntity;

public interface StateCurrentRepo extends BaseRepository<RtvStateCurrentEntity,Integer> {
    RtvStateCurrentEntity findByOrderIdAndStateId(int orderId,int stateId);

}
