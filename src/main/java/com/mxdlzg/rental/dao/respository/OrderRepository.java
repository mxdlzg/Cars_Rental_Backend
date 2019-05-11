package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtOrderEntity;
import com.mxdlzg.rental.domain.model.OptionsKV;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface OrderRepository extends BaseRepository<RtOrderEntity,Integer> {
    RtOrderEntity findByBelongUserIdAndId(int userId,int id);

}
