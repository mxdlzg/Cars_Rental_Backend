package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rtv_state_current", schema = "rental", catalog = "")
public class RtvStateCurrentEntity {
    private Integer orderId;
    private Integer stateId;
    private String description;
    private Integer current;
    private Timestamp changedDate;
    private String handler;

    @Id
    @Column(name = "order_id", nullable = true)
    public Integer getOrderId() {
        return orderId;
    }

    public void setOrderId(Integer orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "state_id", nullable = true)
    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
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
    @Column(name = "current", nullable = true)
    public Integer getCurrent() {
        return current;
    }

    public void setCurrent(Integer current) {
        this.current = current;
    }

    @Basic
    @Column(name = "changed_date", nullable = true)
    public Timestamp getChangedDate() {
        return changedDate;
    }

    public void setChangedDate(Timestamp changedDate) {
        this.changedDate = changedDate;
    }

    @Basic
    @Column(name = "handler", nullable = true, length = 255)
    public String getHandler() {
        return handler;
    }

    public void setHandler(String handler) {
        this.handler = handler;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtvStateCurrentEntity that = (RtvStateCurrentEntity) o;
        return Objects.equals(orderId, that.orderId) &&
                Objects.equals(stateId, that.stateId) &&
                Objects.equals(description, that.description) &&
                Objects.equals(current, that.current) &&
                Objects.equals(changedDate, that.changedDate) &&
                Objects.equals(handler, that.handler);
    }

    @Override
    public int hashCode() {
        return Objects.hash(orderId, stateId, description, current, changedDate, handler);
    }
}
