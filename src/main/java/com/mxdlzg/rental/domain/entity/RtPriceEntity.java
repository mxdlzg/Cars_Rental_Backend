package com.mxdlzg.rental.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rt_price", schema = "rental", catalog = "")
public class RtPriceEntity {
    private int id;
    private Integer carId;
    private String description;
    private double price;
    private Integer num;
    private Double amount;
    @JsonIgnore
    private Boolean priceByDay;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "price", nullable = false, precision = 0)
    public double getPrice() {
        return price;
    }

    public void setPrice(double price) {
        this.price = price;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtPriceEntity that = (RtPriceEntity) o;
        return id == that.id &&
                Double.compare(that.price, price) == 0 &&
                Objects.equals(carId, that.carId) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, carId, description, price);
    }

    @Basic
    @Column(name = "num", nullable = true)
    public Integer getNum() {
        return num;
    }

    public void setNum(Integer num) {
        this.num = num;
    }

    @Basic
    @Column(name = "amount", nullable = true, precision = 0)
    public Double getAmount() {
        return amount;
    }

    public void setAmount(Double amount) {
        this.amount = amount;
    }

    @Basic
    @Column(name = "price_by_day", nullable = true)
    public Boolean getPriceByDay() {
        return priceByDay;
    }

    public void setPriceByDay(Boolean priceByDay) {
        this.priceByDay = priceByDay;
    }
}
