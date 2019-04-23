package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rt_car_maker", schema = "rental", catalog = "")
public class RtCarMakerEntity {
    private int id;
    private String maker;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "maker")
    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtCarMakerEntity that = (RtCarMakerEntity) o;
        return id == that.id &&
                Objects.equals(maker, that.maker);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, maker);
    }
}
