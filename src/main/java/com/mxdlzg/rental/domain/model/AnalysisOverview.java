package com.mxdlzg.rental.domain.model;

import com.mxdlzg.rental.domain.entity.RtvAnalysisDayAccessEntity;
import com.mxdlzg.rental.domain.entity.RtvAnalysisDaySaleEntity;

import java.util.List;

public class AnalysisOverview {
    private double totalSale,todaySale;
    private long totalAccess,todayAccess;
    private long totalPaidCount,todayPaidCount;
    private List<RtvAnalysisDayAccessEntity> accessDetailList;
    private List<RtvAnalysisDaySaleEntity> paidDetailList;

    public AnalysisOverview(double totalSale, double todaySale, int totalAccess, int todayAccess, int totalPaidCount, int todayPaidCount) {
        this.totalSale = totalSale;
        this.todaySale = todaySale;
        this.totalAccess = totalAccess;
        this.todayAccess = todayAccess;
        this.totalPaidCount = totalPaidCount;
        this.todayPaidCount = todayPaidCount;
    }

    public AnalysisOverview(double totalSale, long paidCount) {
        this.totalSale = totalSale;
        this.totalPaidCount = paidCount;
    }

    public double getTotalSale() {
        return totalSale;
    }

    public void setTotalSale(double totalSale) {
        this.totalSale = totalSale;
    }

    public double getTodaySale() {
        return todaySale;
    }

    public void setTodaySale(double todaySale) {
        this.todaySale = todaySale;
    }

    public long getTotalAccess() {
        return totalAccess;
    }

    public void setTotalAccess(long totalAccess) {
        this.totalAccess = totalAccess;
    }

    public long getTodayAccess() {
        return todayAccess;
    }

    public void setTodayAccess(long todayAccess) {
        this.todayAccess = todayAccess;
    }

    public long getPaidCount() {
        return totalPaidCount;
    }

    public void setPaidCount(int paidCount) {
        this.totalPaidCount = paidCount;
    }

    public long getTodayPaidCount() {
        return todayPaidCount;
    }

    public void setTodayPaidCount(long todayPaidCount) {
        this.todayPaidCount = todayPaidCount;
    }

    public void setAccessDetailList(List<RtvAnalysisDayAccessEntity> accessDetailList) {
        this.accessDetailList = accessDetailList;
    }

    public void setPaidDetailList(List<RtvAnalysisDaySaleEntity> paidDetailList) {
        this.paidDetailList = paidDetailList;
    }

    public long getTotalPaidCount() {
        return totalPaidCount;
    }

    public List<RtvAnalysisDayAccessEntity> getAccessDetailList() {
        return accessDetailList;
    }

    public List<RtvAnalysisDaySaleEntity> getPaidDetailList() {
        return paidDetailList;
    }
}
