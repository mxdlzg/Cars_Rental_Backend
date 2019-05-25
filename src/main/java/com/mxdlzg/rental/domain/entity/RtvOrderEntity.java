package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rtv_order", schema = "rental", catalog = "")
public class RtvOrderEntity {
    private int id;
    private Integer belongUserId;
    private Double totalPrice;
    private Integer rentDays;
    private Timestamp startDate;
    private Timestamp endDate;
    private Integer carId;
    private Integer typeId;
    private Timestamp createdDate;
    private Boolean isValid;
    private String description;
    private Timestamp payDate;
    private Integer currentStateId;
    private Integer startStoreId;
    private Integer endStoreId;
    private String stateName;
    private Integer current;
    private String orderTypeName;
    private String orderType;
    private Boolean isPaid;
    private int orderTypeId;
    private String typeName;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "belong_user_id", nullable = true)
    public Integer getBelongUserId() {
        return belongUserId;
    }

    public void setBelongUserId(Integer belongUserId) {
        this.belongUserId = belongUserId;
    }

    @Basic
    @Column(name = "total_price", nullable = true, precision = 2)
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Basic
    @Column(name = "rent_days", nullable = true)
    public Integer getRentDays() {
        return rentDays;
    }

    public void setRentDays(Integer rentDays) {
        this.rentDays = rentDays;
    }

    @Basic
    @Column(name = "start_date", nullable = true)
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date", nullable = true)
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "car_id", nullable = true)
    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    @Basic
    @Column(name = "type_id", nullable = true)
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
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
    @Column(name = "is_valid", nullable = true)
    public Boolean getValid() {
        return isValid;
    }

    public void setValid(Boolean valid) {
        isValid = valid;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "pay_date", nullable = true)
    public Timestamp getPayDate() {
        return payDate;
    }

    public void setPayDate(Timestamp payDate) {
        this.payDate = payDate;
    }

    @Basic
    @Column(name = "current_state_id", nullable = true)
    public Integer getCurrentStateId() {
        return currentStateId;
    }

    public void setCurrentStateId(Integer currentStateId) {
        this.currentStateId = currentStateId;
    }

    @Basic
    @Column(name = "start_store_id", nullable = true)
    public Integer getStartStoreId() {
        return startStoreId;
    }

    public void setStartStoreId(Integer startStoreId) {
        this.startStoreId = startStoreId;
    }

    @Basic
    @Column(name = "end_store_id", nullable = true)
    public Integer getEndStoreId() {
        return endStoreId;
    }

    public void setEndStoreId(Integer endStoreId) {
        this.endStoreId = endStoreId;
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
    @Column(name = "current", nullable = true)
    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    @Basic
    @Column(name = "order_type_name", nullable = true, length = 255)
    public String getOrderTypeName() {
        return orderTypeName;
    }

    public void setOrderTypeName(String orderTypeName) {
        this.orderTypeName = orderTypeName;
    }

    @Basic
    @Column(name = "order_type", nullable = true, length = 255)
    public String getOrderType() {
        return orderType;
    }

    public void setOrderType(String orderType) {
        this.orderType = orderType;
    }

    @Basic
    @Column(name = "is_paid", nullable = true)
    public Boolean getPaid() {
        return isPaid;
    }

    public void setPaid(Boolean paid) {
        isPaid = paid;
    }

    @Basic
    @Column(name = "order_type_id", nullable = false)
    public int getOrderTypeId() {
        return orderTypeId;
    }

    public void setOrderTypeId(int orderTypeId) {
        this.orderTypeId = orderTypeId;
    }

    @Basic
    @Column(name = "type_name", nullable = true, length = 255)
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtvOrderEntity that = (RtvOrderEntity) o;
        return id == that.id &&
                orderTypeId == that.orderTypeId &&
                Objects.equals(belongUserId, that.belongUserId) &&
                Objects.equals(totalPrice, that.totalPrice) &&
                Objects.equals(rentDays, that.rentDays) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(carId, that.carId) &&
                Objects.equals(typeId, that.typeId) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(isValid, that.isValid) &&
                Objects.equals(description, that.description) &&
                Objects.equals(payDate, that.payDate) &&
                Objects.equals(currentStateId, that.currentStateId) &&
                Objects.equals(startStoreId, that.startStoreId) &&
                Objects.equals(endStoreId, that.endStoreId) &&
                Objects.equals(stateName, that.stateName) &&
                Objects.equals(current, that.current) &&
                Objects.equals(orderTypeName, that.orderTypeName) &&
                Objects.equals(orderType, that.orderType) &&
                Objects.equals(isPaid, that.isPaid) &&
                Objects.equals(typeName, that.typeName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, belongUserId, totalPrice, rentDays, startDate, endDate, carId, typeId, createdDate, isValid, description, payDate, currentStateId, startStoreId, endStoreId, stateName, current, orderTypeName, orderType, isPaid, orderTypeId, typeName);
    }
}
