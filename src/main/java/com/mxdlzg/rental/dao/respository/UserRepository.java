package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtUserEntity;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<RtUserEntity,Long> {
    RtUserEntity findUserBeanById(Integer id);
    RtUserEntity findByUsername(String name);
}
