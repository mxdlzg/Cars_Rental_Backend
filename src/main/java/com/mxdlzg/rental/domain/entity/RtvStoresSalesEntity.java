package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rtv_stores_sales", schema = "rental", catalog = "")
public class RtvStoresSalesEntity {
    private Integer startStoreId;
    private Integer orderId;
    private String stateName;
    private String storeName;
    private String typeName;
    private Timestamp createdDate;
    private Timestamp payDate;

    @Basic
    @Column(name = "start_store_id", nullable = true)
    public Integer getStartStoreId() {
        return startStoreId;
    }

    public void setStartStoreId(Integer startStoreId) {
        this.startStoreId = startStoreId;
    }

    @Id
    @Column(name = "order_id", nullable = true)
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "state_name", nullable = true, length = 255)
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
    }

    @Basic
    @Column(name = "store_name", nullable = true, length = 255)
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Basic
    @Column(name = "type_name", nullable = true, length = 255)
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Basic
    @Column(name = "created_date", nullable = true)
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "pay_date", nullable = true)
    public Timestamp getPayDate() {
        return payDate;
    }

    public void setPayDate(Timestamp payDate) {
        this.payDate = payDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtvStoresSalesEntity that = (RtvStoresSalesEntity) o;
        return Objects.equals(startStoreId, that.startStoreId) &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(stateName, that.stateName) &&
                Objects.equals(storeName, that.storeName) &&
                Objects.equals(typeName, that.typeName) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(payDate, that.payDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(startStoreId, orderId, stateName, storeName, typeName, createdDate, payDate);
    }
}
