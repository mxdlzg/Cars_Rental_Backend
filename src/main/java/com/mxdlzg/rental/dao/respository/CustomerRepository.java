package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtCustomerEntity;

public interface CustomerRepository extends BaseRepository<RtCustomerEntity,Integer> {
    boolean existsByCardId(String id);
}
