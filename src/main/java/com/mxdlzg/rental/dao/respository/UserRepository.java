package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtUserEntity;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface UserRepository extends CrudRepository<RtUserEntity,Long> {
    RtUserEntity findUserBeanById(Integer id);
    RtUserEntity findByUsername(String name);
    RtUserEntity findById(int id);
}
