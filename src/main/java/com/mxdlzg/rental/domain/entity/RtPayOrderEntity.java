package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rt_pay_order", schema = "rental", catalog = "")
public class RtPayOrderEntity {
    private int id;
    private String description;
    private Timestamp payDate;
    private Boolean finished;
    private Double realPrice;
    private Integer orderId;
    private Integer invoiceType;

    public RtPayOrderEntity() {
    }

    public RtPayOrderEntity(String description, Boolean finished, Double realPrice, Integer orderId, Integer invoiceType) {
        this.description = description;
        this.finished = finished;
        this.realPrice = realPrice;
        this.orderId = orderId;
        this.invoiceType = invoiceType;
    }

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "finished", nullable = true)
    public Boolean getFinished() {
        return finished;
    }

    public void setFinished(Boolean finished) {
        this.finished = finished;
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
    @Column(name = "order_id", nullable = true)
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "invoice_type", nullable = true)
    public Integer getInvoiceType() {
        return invoiceType;
    }

    public void setInvoiceType(Integer invoiceType) {
        this.invoiceType = invoiceType;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtPayOrderEntity that = (RtPayOrderEntity) o;
        return id == that.id &&
                Objects.equals(description, that.description) &&
                Objects.equals(payDate, that.payDate) &&
                Objects.equals(finished, that.finished) &&
                Objects.equals(realPrice, that.realPrice) &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(invoiceType, that.invoiceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, description, payDate, finished, realPrice, orderId, invoiceType);
    }
}
