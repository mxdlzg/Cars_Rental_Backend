package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rt_invoice", schema = "rental", catalog = "")
public class RtInvoiceEntity {
    private int id;
    private String name;
    private int invoiceType;
    private Integer orderId;
    private String href;

    public RtInvoiceEntity() {
    }

    public RtInvoiceEntity(String name, int invoiceType, Integer orderId) {
        this.name = name;
        this.invoiceType = invoiceType;
        this.orderId = orderId;
    }

    @Id
    @GeneratedValue
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
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
        RtInvoiceEntity that = (RtInvoiceEntity) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(invoiceType, that.invoiceType);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, invoiceType);
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
    @Column(name = "href", nullable = true, length = 255)
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }
}
