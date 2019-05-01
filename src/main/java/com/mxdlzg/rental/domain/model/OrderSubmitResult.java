package com.mxdlzg.rental.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mxdlzg.rental.domain.model.enums.ResponseEnums;

import java.sql.Timestamp;

public class OrderSubmitResult extends BaseDaoResult{
    private Integer orderId;
    private Timestamp date;
    private boolean isExist;

    public OrderSubmitResult(ResponseEnums enums) {
        super(enums);
    }

    public OrderSubmitResult(boolean isExist) {
        this.isExist = isExist;
    }

    public OrderSubmitResult(Integer orderId, Timestamp date) {
        this.orderId = orderId;
        this.date = date;
    }

    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    public Timestamp getDate() {
        return date;
    }

    public void setDate(Timestamp date) {
        this.date = date;
    }

    public boolean isExist() {
        return isExist;
    }

    public void setExist(boolean exist) {
        isExist = exist;
    }
}
