package com.mxdlzg.rental.dao.respository;

import com.mxdlzg.rental.domain.entity.RtvAnalysisDayAccessEntity;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface AccessAnalysisRepo extends BaseRepository<RtvAnalysisDayAccessEntity,Integer> {
    List<RtvAnalysisDayAccessEntity> findTop14ByOrderByDate();

}
