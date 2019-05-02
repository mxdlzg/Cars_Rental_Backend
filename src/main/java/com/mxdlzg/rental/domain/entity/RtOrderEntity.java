package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rt_order", schema = "rental", catalog = "")
public class RtOrderEntity {
    private int id;
    private Integer belongUserId;
    private float totalPrice;
    private Integer rentDays;
    private Timestamp startDate;
    private Timestamp endDate;
    private Integer carId;
    private BigDecimal servicePrice;
    private BigDecimal vehiclePrice;
    private Integer type;
    private Timestamp createdDate;
    private Boolean isValid;
    private String description;
    private Timestamp payDate;

    public RtOrderEntity() {
    }

    public RtOrderEntity(Integer belongUserId, float totalPrice, Integer rentDays, Timestamp startDate, Timestamp endDate, Integer carId, Integer type, Boolean isValid) {
        this.belongUserId = belongUserId;
        this.totalPrice = totalPrice;
        this.rentDays = rentDays;
        this.startDate = startDate;
        this.endDate = endDate;
        this.carId = carId;
        this.type = type;
        this.isValid = isValid;
    }

    @Id
    @Column(name = "id", nullable = false)
    @GeneratedValue
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
    public float getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(float totalPrice) {
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
    @Column(name = "service_price", nullable = true, precision = 2)
    public BigDecimal getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(BigDecimal servicePrice) {
        this.servicePrice = servicePrice;
    }

    @Basic
    @Column(name = "vehicle_price", nullable = true, precision = 2)
    public BigDecimal getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(BigDecimal vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    @Basic
    @Column(name = "type", nullable = true)
    public Integer getType() {
        return type;
    }

    public void setType(Integer type) {
        this.type = type;
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtOrderEntity that = (RtOrderEntity) o;
        return id == that.id &&
                Objects.equals(belongUserId, that.belongUserId) &&
                Objects.equals(totalPrice, that.totalPrice) &&
                Objects.equals(rentDays, that.rentDays) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(carId, that.carId) &&
                Objects.equals(servicePrice, that.servicePrice) &&
                Objects.equals(vehiclePrice, that.vehiclePrice) &&
                Objects.equals(type, that.type) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(isValid, that.isValid) &&
                Objects.equals(description, that.description) &&
                Objects.equals(payDate, that.payDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, belongUserId, totalPrice, rentDays, startDate, endDate, carId, servicePrice, vehiclePrice, type, createdDate, isValid, description, payDate);
    }
}
