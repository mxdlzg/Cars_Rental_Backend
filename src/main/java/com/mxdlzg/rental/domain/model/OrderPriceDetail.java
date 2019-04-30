package com.mxdlzg.rental.domain.model;

import com.mxdlzg.rental.domain.entity.RtPriceEntity;

import java.sql.Timestamp;
import java.util.List;

public class OrderPriceDetail {
    private List<RtPriceEntity> detail;
    private String amount;
    private Timestamp fetchCarDate,returnCarDate;
    private String fetchLocation,returnLocation;

    public OrderPriceDetail(List<RtPriceEntity> detail, float price, Timestamp fetchCarDate, Timestamp returnCarDate, String fetchLocation, String returnLocation) {
        this.detail = detail;
        this.amount = convertPrice(price);
        this.fetchCarDate = fetchCarDate;
        this.returnCarDate = returnCarDate;
        this.fetchLocation = fetchLocation;
        this.returnLocation = returnLocation;
    }

    public List<RtPriceEntity> getDetail() {
        return detail;
    }

    public void setDetail(List<RtPriceEntity> detail) {
        this.detail = detail;
    }

    public String getAmount() {
        return amount;
    }

    public void setAmount(float price) {
        this.amount = convertPrice(price);
    }

    public Timestamp getFetchCarDate() {
        return fetchCarDate;
    }

    public void setFetchCarDate(Timestamp fetchCarDate) {
        this.fetchCarDate = fetchCarDate;
    }

    public Timestamp getReturnCarDate() {
        return returnCarDate;
    }

    public void setReturnCarDate(Timestamp returnCarDate) {
        this.returnCarDate = returnCarDate;
    }

    public String getFetchLocation() {
        return fetchLocation;
    }

    public void setFetchLocation(String fetchLocation) {
        this.fetchLocation = fetchLocation;
    }

    public String getReturnLocation() {
        return returnLocation;
    }

    public void setReturnLocation(String returnLocation) {
        this.returnLocation = returnLocation;
    }

    private String convertPrice(float price){
        return "￥"+String.valueOf(price);
    }
}
