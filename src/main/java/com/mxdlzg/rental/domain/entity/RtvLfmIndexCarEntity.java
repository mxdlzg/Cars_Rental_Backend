package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.io.Serializable;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@IdClass(RtvLfmIndexCarEntity.class)
@Table(name = "rtv_lfm_index_car", schema = "rental", catalog = "")
public class RtvLfmIndexCarEntity implements Serializable {
    private String title;
    private Timestamp updateAt;
    private Long href;
    private String logo;
    private String label;
    private Double percent;
    private Long userId;
    private String description;

    @Basic
    @Column(name = "title", nullable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "updateAt", nullable = true)
    public Timestamp getUpdateAt() {
        return updateAt;
    }

    public void setUpdateAt(Timestamp updateAt) {
        this.updateAt = updateAt;
    }

    @Id
    @Column(name = "href", nullable = true)
    public Long getHref() {
        return href;
    }

    public void setHref(Long href) {
        this.href = href;
    }

    @Basic
    @Column(name = "logo", nullable = true, length = 255)
    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    @Basic
    @Column(name = "label", nullable = true, length = 255)
    public String getLabel() {
        return label;
    }

    public void setLabel(String label) {
        this.label = label;
    }

    @Basic
    @Column(name = "percent", nullable = true, precision = 10)
    public Double getPercent() {
        return percent;
    }

    public void setPercent(Double percent) {
        this.percent = percent;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtvLfmIndexCarEntity that = (RtvLfmIndexCarEntity) o;
        return Objects.equals(title, that.title) &&
                Objects.equals(updateAt, that.updateAt) &&
                Objects.equals(href, that.href) &&
                Objects.equals(logo, that.logo) &&
                Objects.equals(label, that.label) &&
                Objects.equals(percent, that.percent);
    }

    @Override
    public int hashCode() {
        return Objects.hash(title, updateAt, href, logo, label, percent);
    }

    @Id
    @Column(name = "user_id", nullable = true)
    public Long getUserId() {
        return userId;
    }

    public void setUserId(Long userId) {
        this.userId = userId;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
