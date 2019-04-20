package com.mxdlzg.rental.domain.entity;

import org.springframework.context.annotation.Bean;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.util.Date;

@Entity
@Table(name = "rt_car")
public class RtCar extends BaseEntity{
    private Integer type_id;
    private String type_name,brand_name;
    private String engine_id,carcase_id;
    private String manufacture_date,buy_date;
    private double default_rent_price;
    private Integer insurance_id;
    private Integer capability;
    private Integer fuel_id;
    private boolean rent_able,book_able;
    private String description;

    public Integer getType_id() {
        return type_id;
    }

    public void setType_id(Integer type_id) {
        this.type_id = type_id;
    }

    public String getType_name() {
        return type_name;
    }

    public void setType_name(String type_name) {
        this.type_name = type_name;
    }

    public String getBrand_name() {
        return brand_name;
    }

    public void setBrand_name(String brand_name) {
        this.brand_name = brand_name;
    }

    public String getEngine_id() {
        return engine_id;
    }

    public void setEngine_id(String engine_id) {
        this.engine_id = engine_id;
    }

    public String getCarcase_id() {
        return carcase_id;
    }

    public void setCarcase_id(String carcase_id) {
        this.carcase_id = carcase_id;
    }

    public String getManufacture_date() {
        return manufacture_date;
    }

    public void setManufacture_date(String manufacture_date) {
        this.manufacture_date = manufacture_date;
    }

    public String getBuy_date() {
        return buy_date;
    }

    public void setBuy_date(String buy_date) {
        this.buy_date = buy_date;
    }

    public double getDefault_rent_price() {
        return default_rent_price;
    }

    public void setDefault_rent_price(double default_rent_price) {
        this.default_rent_price = default_rent_price;
    }

    public Integer getInsurance_id() {
        return insurance_id;
    }

    public void setInsurance_id(Integer insurance_id) {
        this.insurance_id = insurance_id;
    }

    public Integer getCapability() {
        return capability;
    }

    public void setCapability(Integer capability) {
        this.capability = capability;
    }

    public Integer getFuel_id() {
        return fuel_id;
    }

    public void setFuel_id(Integer fuel_id) {
        this.fuel_id = fuel_id;
    }

    public boolean isRent_able() {
        return rent_able;
    }

    public void setRent_able(boolean rent_able) {
        this.rent_able = rent_able;
    }

    public boolean isBook_able() {
        return book_able;
    }

    public void setBook_able(boolean book_able) {
        this.book_able = book_able;
    }
}
