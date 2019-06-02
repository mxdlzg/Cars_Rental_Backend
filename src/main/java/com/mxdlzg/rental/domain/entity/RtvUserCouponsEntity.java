package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rtv_user_coupons", schema = "rental", catalog = "")
public class RtvUserCouponsEntity {
    private String name;
    private Timestamp createDate;
    private Timestamp endDate;
    private Integer minCreditType;
    private Boolean precondition;
    private BigDecimal preconditionPrice;
    private Boolean isSuperposition;
    private Integer userId;
    private Integer couponId;
    private Double price;

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "create_date", nullable = true)
    public Timestamp getCreateDate() {
        return createDate;
    }

    public void setCreateDate(Timestamp createDate) {
        this.createDate = createDate;
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
    @Column(name = "min_credit_type", nullable = true)
    public Integer getMinCreditType() {
        return minCreditType;
    }

    public void setMinCreditType(Integer minCreditType) {
        this.minCreditType = minCreditType;
    }

    @Basic
    @Column(name = "precondition", nullable = true)
    public Boolean getPrecondition() {
        return precondition;
    }

    public void setPrecondition(Boolean precondition) {
        this.precondition = precondition;
    }

    @Basic
    @Column(name = "precondition_price", nullable = true, precision = 2)
    public BigDecimal getPreconditionPrice() {
        return preconditionPrice;
    }

    public void setPreconditionPrice(BigDecimal preconditionPrice) {
        this.preconditionPrice = preconditionPrice;
    }

    @Basic
    @Column(name = "is_superposition", nullable = true)
    public Boolean getSuperposition() {
        return isSuperposition;
    }

    public void setSuperposition(Boolean superposition) {
        isSuperposition = superposition;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtvUserCouponsEntity that = (RtvUserCouponsEntity) o;
        return  Objects.equals(name, that.name) &&
                Objects.equals(createDate, that.createDate) &&
                Objects.equals(endDate, that.endDate) &&
                Objects.equals(minCreditType, that.minCreditType) &&
                Objects.equals(precondition, that.precondition) &&
                Objects.equals(preconditionPrice, that.preconditionPrice) &&
                Objects.equals(isSuperposition, that.isSuperposition) &&
                Objects.equals(userId, that.userId)&&
                Objects.equals(couponId,that.couponId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, createDate, endDate, minCreditType, precondition, preconditionPrice, isSuperposition, couponId, userId);
    }

    @Id
    @Column(name = "coupon_id", nullable = true)
    public Integer getCouponId() {
        return couponId;
    }

    public void setCouponId(Integer couponId) {
        this.couponId = couponId;
    }

    @Basic
    @Column(name = "price", nullable = true, precision = 2)
    public Double getPrice() {
        return price;
    }

    public void setPrice(Double price) {
        this.price = price;
    }
}
