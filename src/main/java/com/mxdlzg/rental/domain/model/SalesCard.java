package com.mxdlzg.rental.domain.model;

import java.util.List;

public class SalesCard {
    private List<OptionsXY> list;
    private List<OptionsKV<Double>> storeRankingList;

    public SalesCard(List<OptionsXY> list, List<OptionsKV<Double>> storeRankingList) {
        this.list = list;
        this.storeRankingList = storeRankingList;
    }

    public List<OptionsXY> getList() {
        return list;
    }

    public void setList(List<OptionsXY> list) {
        this.list = list;
    }

    public List<OptionsKV<Double>> getStoreRankingList() {
        return storeRankingList;
    }

    public void setStoreRankingList(List<OptionsKV<Double>> storeRankingList) {
        this.storeRankingList = storeRankingList;
    }
}
