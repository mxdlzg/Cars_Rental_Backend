package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtCarStructureEntity;
import com.mxdlzg.rental.domain.model.OptionsKV;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface CarStructureRepository extends BaseRepository<RtCarStructureEntity,Long> {
    @Query(value = "select new com.mxdlzg.rental.domain.model.OptionsKV(u.structure,u.structure) " +
            "from RtCarStructureEntity u")
    List<OptionsKV> findStructures();
}
