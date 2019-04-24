package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rt_booking", schema = "rental", catalog = "")
public class RtBookingEntity {
    private int id;
    private Integer belongUserId;
    private Integer rentDays;
    private Timestamp startDate;
    private Timestamp endDate;
    private Integer carId;
    private BigDecimal bookingPrice;
    private Integer nextSpaceDays;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "belong_user_id")
    public Integer getBelongUserId() {
        return belongUserId;
    }

    public void setBelongUserId(Integer belongUserId) {
        this.belongUserId = belongUserId;
    }

    @Basic
    @Column(name = "rent_days")
    public Integer getRentDays() {
        return rentDays;
    }

    public void setRentDays(Integer rentDays) {
        this.rentDays = rentDays;
    }

    @Basic
    @Column(name = "start_date")
    public Timestamp getStartDate() {
        return startDate;
    }

    public void setStartDate(Timestamp startDate) {
        this.startDate = startDate;
    }

    @Basic
    @Column(name = "end_date")
    public Timestamp getEndDate() {
        return endDate;
    }

    public void setEndDate(Timestamp endDate) {
        this.endDate = endDate;
    }

    @Basic
    @Column(name = "car_id")
    public Integer getCarId() {
        return carId;
    }

    public void setCarId(Integer carId) {
        this.carId = carId;
    }

    @Basic
    @Column(name = "booking_price")
    public BigDecimal getBookingPrice() {
        return bookingPrice;
    }

    public void setBookingPrice(BigDecimal bookingPrice) {
        this.bookingPrice = bookingPrice;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtBookingEntity that = (RtBookingEntity) o;
        return id == that.id &&
                Objects.equals(belongUserId, that.belongUserId) &&
                Objects.equals(rentDays, that.rentDays) &&
                Objects.equals(startDate, that.startDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(carId, that.carId) &&
                Objects.equals(bookingPrice, that.bookingPrice);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, belongUserId, rentDays, startDate, endDate, carId, bookingPrice);
    }

    @Basic
    @Column(name = "next_space_days")
    public Integer getNextSpaceDays() {
        return nextSpaceDays;
    }

    public void setNextSpaceDays(Integer nextSpaceDays) {
        this.nextSpaceDays = nextSpaceDays;
    }
}
