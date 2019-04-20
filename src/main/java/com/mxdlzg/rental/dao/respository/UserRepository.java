package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtUser;
import org.springframework.data.repository.CrudRepository;

public interface UserRepository extends CrudRepository<RtUser,Long> {
    RtUser findUserBeanById(Integer id);
    RtUser findByUsername(String name);
}
