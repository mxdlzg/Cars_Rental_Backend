package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtCustomerEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface CustomerRepository extends BaseRepository<RtCustomerEntity,Integer> {
    boolean existsByCardId(String id);
    RtCustomerEntity findByCardId(String id);
}
