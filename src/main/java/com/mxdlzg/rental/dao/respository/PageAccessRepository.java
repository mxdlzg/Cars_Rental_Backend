package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtPageAccessEntity;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface PageAccessRepository extends BaseRepository<RtPageAccessEntity,Integer> {
    @Query("select count(rtv) from RtPageAccessEntity rtv where rtv.accessDate>=CURDATE()")
    long todayCount();

}
