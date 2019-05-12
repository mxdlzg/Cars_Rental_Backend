package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rtv_order_pay_info", schema = "rental", catalog = "")
public class RtvOrderPayInfoEntity {
    private int id;
    private Double totalPrice;
    private Timestamp createdDate;
    private Boolean finished;
    private Timestamp payDate;
    private Double realPrice;
    private String description;
    private Integer invoiceType;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "created_date", nullable = true)
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "finished", nullable = true)
    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
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
    @Column(name = "real_price", nullable = true, precision = 2)
    public Double getRealPrice() {
        return realPrice;
    }

    public void setRealPrice(Double realPrice) {
        this.realPrice = realPrice;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtvOrderPayInfoEntity that = (RtvOrderPayInfoEntity) o;
        return id == that.id &&
                Objects.equals(totalPrice, that.totalPrice) &&
                Objects.equals(createdDate, that.createdDate) &&
                Objects.equals(finished, that.finished) &&
                Objects.equals(payDate, that.payDate) &&
                Objects.equals(realPrice, that.realPrice) &&
                Objects.equals(description, that.description);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, totalPrice, createdDate, finished, payDate, realPrice, description);
    }

    @Basic
    @Column(name = "invoice_type", nullable = true)
    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }
}
