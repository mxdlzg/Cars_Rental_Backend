package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.math.BigInteger;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rt_order", schema = "rental", catalog = "")
public class RtOrderEntity {
    private int id;
    private Integer belongUserId;
    private double totalPrice;
    private Integer rentDays;
    private Timestamp startDate;
    private Timestamp endDate;
    private Integer carId;
    private Timestamp createdDate;
    private Boolean isValid;
    private String description;
    private Timestamp payDate;
    private Integer currentStateId;
    private Integer startStoreId;
    private Integer endStoreId;
    private Integer typeId;
    private BigInteger servicePrice;
    private BigInteger vehiclePrice;
    private Integer bookingId;

    public RtOrderEntity() {
    }

    public RtOrderEntity(Integer belongUserId, float totalPrice, Integer rentDays, Timestamp startDate, Timestamp endDate, Integer carId, Integer typeId, Boolean isValid) {
        this.belongUserId = belongUserId;
        this.totalPrice = totalPrice;
        this.rentDays = rentDays;
        this.startDate = startDate;
        this.endDate = endDate;
        this.carId = carId;
        this.typeId = typeId;
        this.isValid = isValid;
        this.currentStateId = 1;
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
    public double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    public void setTotalPrice(double totalPrice) {
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
                Objects.equals(typeId, that.typeId) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(isValid, that.isValid) &&
                Objects.equals(description, that.description) &&
                Objects.equals(payDate, that.payDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, belongUserId, totalPrice, rentDays, startDate, endDate, carId, typeId, createdDate, isValid, description, payDate);
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
    @Column(name = "type_id", nullable = true)
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "service_price", nullable = true, precision = 0)
    public BigInteger getServicePrice() {
        return servicePrice;
    }

    public void setServicePrice(BigInteger servicePrice) {
        this.servicePrice = servicePrice;
    }

    @Basic
    @Column(name = "vehicle_price", nullable = true, precision = 0)
    public BigInteger getVehiclePrice() {
        return vehiclePrice;
    }

    public void setVehiclePrice(BigInteger vehiclePrice) {
        this.vehiclePrice = vehiclePrice;
    }

    @Basic
    @Column(name = "booking_id", nullable = true)
    public Integer getBookingId() {
        return bookingId;
    }

    public void setBookingId(Integer bookingId) {
        this.bookingId = bookingId;
    }
}
