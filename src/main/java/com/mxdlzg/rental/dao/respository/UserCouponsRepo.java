package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtvUserCouponsEntity;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Repository;

@Repository
public interface UserCouponsRepo extends BaseRepository<RtvUserCouponsEntity,Integer> {
    Page<RtvUserCouponsEntity> findAllByUserIdOrderByEndDateDesc(int id, Pageable pageable);
}
