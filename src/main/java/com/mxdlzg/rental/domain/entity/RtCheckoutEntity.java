package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.math.BigDecimal;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rt_checkout", schema = "rental", catalog = "")
public class RtCheckoutEntity {
    private int id;
    private Integer customerId;
    private Integer orderId;
    private double settlementPrice;
    private Timestamp finishedDate;
    private Integer invoiceId;

    public RtCheckoutEntity() {
    }

    public RtCheckoutEntity(Integer orderId, double settlementPrice, Timestamp finishedDate, Integer invoiceId) {
        this.orderId = orderId;
        this.settlementPrice = settlementPrice;
        this.finishedDate = finishedDate;
        this.invoiceId = invoiceId;
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
    @Column(name = "customer_id", nullable = true)
    public Integer getCustomerId() {
        return customerId;
    }

    public void setCustomerId(Integer customerId) {
        this.customerId = customerId;
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
    @Column(name = "settlement_price", nullable = true, precision = 2)
    public double getSettlementPrice() {
        return settlementPrice;
    }

    public void setSettlementPrice(double settlementPrice) {
        this.settlementPrice = settlementPrice;
    }

    @Basic
    @Column(name = "finished_date", nullable = true)
    public Timestamp getFinishedDate() {
        return finishedDate;
    }

    public void setFinishedDate(Timestamp finishedDate) {
        this.finishedDate = finishedDate;
    }

    @Basic
    @Column(name = "invoice_id", nullable = true)
    public Integer getInvoiceId() {
        return invoiceId;
    }

    public void setInvoiceId(Integer invoiceId) {
        this.invoiceId = invoiceId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtCheckoutEntity that = (RtCheckoutEntity) o;
        return id == that.id &&
                Objects.equals(customerId, that.customerId) &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(settlementPrice, that.settlementPrice) &&
                Objects.equals(finishedDate, that.finishedDate) &&
                Objects.equals(invoiceId, that.invoiceId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, customerId, orderId, settlementPrice, finishedDate, invoiceId);
    }
}
