package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtCarMakerEntity;
import com.mxdlzg.rental.domain.model.OptionsKV;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarMakerRepository extends BaseRepository<RtCarMakerEntity,Long> {

    @Query(value = "select new com.mxdlzg.rental.domain.model.OptionsKV(u.maker,u.maker) " +
            "from RtCarMakerEntity u")
    public List<OptionsKV> findAllMakers();
}
