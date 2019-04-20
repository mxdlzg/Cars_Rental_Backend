package com.mxdlzg.rental.domain.entity;

import javax.persistence.Entity;
import javax.persistence.JoinColumn;
import javax.persistence.Table;

@Entity
@Table(name = "rt_price")
public class RtRentPrice extends BaseEntity{
    private Integer car_id;
    private double price;
    private String description;

}
