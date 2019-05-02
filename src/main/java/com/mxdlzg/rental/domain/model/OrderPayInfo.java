package com.mxdlzg.rental.domain.model;

import com.mxdlzg.rental.domain.entity.RtvOrderPayInfoEntity;

import java.sql.Timestamp;

public class OrderPayInfo {
    private int id;
    private String description;
    private double totalPrice;
    private Timestamp createdDate;
    private boolean finished;
    private Timestamp payDate;

    public OrderPayInfo(int id, String description, double totalPrice, Timestamp createdDate, boolean finished, Timestamp payDate) {
        this.id = id;
        this.description = description;
        this.totalPrice = totalPrice;
        this.createdDate = createdDate;
        this.finished = finished;
        this.payDate = payDate;
    }

    public static OrderPayInfo valueOf(RtvOrderPayInfoEntity infoEntity) {
        return new OrderPayInfo(infoEntity.getId(),
                infoEntity.getDescription(),
                infoEntity.getTotalPrice(),
                infoEntity.getCreatedDate(),
                infoEntity.getFinished(),
                infoEntity.getPayDate());
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public Timestamp getPayDate() {
        return payDate;
    }

    public void setPayDate(Timestamp payDate) {
        this.payDate = payDate;
    }
}
