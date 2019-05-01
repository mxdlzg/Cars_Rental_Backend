package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rt_order_state", schema = "rental", catalog = "")
public class RtOrderStateEntity {
    private int id;
    private Integer orderId;
    private Integer stateId;
    private String stateName;
    private Timestamp changedDate;
    private String handler;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
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
    @Column(name = "state_id", nullable = true)
    public Integer getStateId() {
        return stateId;
    }

    public void setStateId(Integer stateId) {
        this.stateId = stateId;
    }

    @Basic
    @Column(name = "state_name", nullable = true, length = 255)
    public String getStateName() {
        return stateName;
    }

    public void setStateName(String stateName) {
        this.stateName = stateName;
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
        RtOrderStateEntity that = (RtOrderStateEntity) o;
        return id == that.id &&
                Objects.equals(orderId, that.orderId) &&
                Objects.equals(stateId, that.stateId) &&
                Objects.equals(stateName, that.stateName) &&
                Objects.equals(changedDate, that.changedDate) &&
                Objects.equals(handler, that.handler);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, orderId, stateId, stateName, changedDate, handler);
    }
}
