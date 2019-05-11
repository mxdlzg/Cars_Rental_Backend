package com.mxdlzg.rental.domain.model;

import java.util.List;

public class SalesCard {
    private List<OptionsKV> list;
    private List<OptionsKV<Double>> storeRankingList;

    public SalesCard(List<OptionsKV> list, List<OptionsKV<Double>> storeRankingList) {
        this.list = list;
        this.storeRankingList = storeRankingList;
    }

    public List<OptionsKV> getList() {
        return list;
    }

    public void setList(List<OptionsKV> list) {
        this.list = list;
    }

    public List<OptionsKV<Double>> getStoreRankingList() {
        return storeRankingList;
    }

    public void setStoreRankingList(List<OptionsKV<Double>> storeRankingList) {
        this.storeRankingList = storeRankingList;
    }
}
