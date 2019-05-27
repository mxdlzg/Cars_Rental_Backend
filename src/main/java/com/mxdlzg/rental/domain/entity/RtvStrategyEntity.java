package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rtv_strategy", schema = "rental", catalog = "")
public class RtvStrategyEntity {
    private int id;
    private String title;
    private String cover;
    private String subDescription;
    private Timestamp upadteAt;
    private Integer userId;
    private String name;
    private String avatar;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "title", nullable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "cover", nullable = true, length = 255)
    public String getCover() {
        return cover;
    }

    public void setCover(String cover) {
        this.cover = cover;
    }

    @Basic
    @Column(name = "sub_description", nullable = true, length = 255)
    public String getSubDescription() {
        return subDescription;
    }

    public void setSubDescription(String subDescription) {
        this.subDescription = subDescription;
    }

    @Basic
    @Column(name = "upadte_at", nullable = true)
    public Timestamp getUpadteAt() {
        return upadteAt;
    }

    public void setUpadteAt(Timestamp upadteAt) {
        this.upadteAt = upadteAt;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
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
    @Column(name = "avatar", nullable = true, length = 255)
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtvStrategyEntity that = (RtvStrategyEntity) o;
        return id == that.id &&
                Objects.equals(title, that.title) &&
                Objects.equals(cover, that.cover) &&
                Objects.equals(subDescription, that.subDescription) &&
                Objects.equals(upadteAt, that.upadteAt) &&
                Objects.equals(userId, that.userId) &&
                Objects.equals(name, that.name) &&
                Objects.equals(avatar, that.avatar);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, cover, subDescription, upadteAt, userId, name, avatar);
    }
}
