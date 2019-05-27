package com.mxdlzg.rental.domain.model;

import com.mxdlzg.rental.domain.entity.RtvLfmIndexCarEntity;
import com.mxdlzg.rental.domain.entity.RtvStrategyEntity;
import org.springframework.data.domain.Page;

import java.util.List;

public class IndexBundle {
    private Page<RtvLfmIndexCarEntity> recommendation;
    private Page<RtvStrategyEntity> strategy;
    private Page<?> data;

    public IndexBundle() {
    }

    public Page<?> getData() {
        return data;
    }

    public void setData(Page<?> data) {
        this.data = data;
    }

    public IndexBundle(Page<RtvLfmIndexCarEntity> recommendation) {
        this.recommendation = recommendation;
    }

    public Page<RtvLfmIndexCarEntity> getRecommendation() {
        return recommendation;
    }

    public void setRecommendation(Page<RtvLfmIndexCarEntity> recommendation) {
        this.recommendation = recommendation;
    }

    public Page<RtvStrategyEntity> getStrategy() {
        return strategy;
    }

    public void setStrategy(Page<RtvStrategyEntity> strategy) {
        this.strategy = strategy;
    }
}
