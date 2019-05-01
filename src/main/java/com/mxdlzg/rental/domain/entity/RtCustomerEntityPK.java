package com.mxdlzg.rental.domain.entity;

import javax.persistence.Basic;
import javax.persistence.Column;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import java.io.Serializable;
import java.util.Objects;

public class RtCustomerEntityPK implements Serializable {
    private int id;
    private String name;
    private String cardId;

    @GeneratedValue
    @Column(name = "id", nullable = false)
    @Id
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Column(name = "name", nullable = false, length = 30)
    @Basic
    @Id
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Column(name = "card_id", nullable = false, length = 30)
    @Basic
    @Id
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtCustomerEntityPK that = (RtCustomerEntityPK) o;
        return id == that.id &&
                Objects.equals(name, that.name) &&
                Objects.equals(cardId, that.cardId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, cardId);
    }
}
