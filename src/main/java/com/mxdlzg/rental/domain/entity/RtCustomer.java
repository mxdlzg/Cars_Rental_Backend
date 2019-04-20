package com.mxdlzg.rental.domain.entity;

import javax.persistence.Entity;
import javax.persistence.Table;

@Entity
@Table(name = "rt_customer")
public class RtCustomer extends BaseEntity{
    private Integer name;
    private boolean sex;
}
