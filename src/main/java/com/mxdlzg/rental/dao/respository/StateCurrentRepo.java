package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtvStateCurrentEntity;

public interface StateCurrentRepo extends BaseRepository<RtvStateCurrentEntity,Integer> {
    RtvStateCurrentEntity findTopByOrderIdAndStateIdOrderByChangedDateDesc(int orderId,int stateId);

}
