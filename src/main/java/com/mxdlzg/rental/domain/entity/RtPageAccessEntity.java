package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Date;
import java.util.Objects;

@Entity
@Table(name = "rt_page_access", schema = "rental", catalog = "")
public class RtPageAccessEntity {
    private int id;
    private String pageName;
    private Integer pageId;
    private Timestamp accessDate;
    private Integer visitorId;

    public RtPageAccessEntity() {
    }

    public RtPageAccessEntity(String pageName, Integer pageId, Integer visitorId) {
        this.pageName = pageName;
        this.pageId = pageId;
        this.accessDate = new Timestamp(new Date().getTime());
        this.visitorId = visitorId;
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
    @Column(name = "page_name", nullable = true, length = 255)
    public String getPageName() {
        return pageName;
    }

    public void setPageName(String pageName) {
        this.pageName = pageName;
    }

    @Basic
    @Column(name = "page_id", nullable = true)
    public Integer getPageId() {
        return pageId;
    }

    public void setPageId(Integer pageId) {
        this.pageId = pageId;
    }

    @Basic
    @Column(name = "access_date", nullable = true)
    public Timestamp getAccessDate() {
        return accessDate;
    }

    public void setAccessDate(Timestamp accessDate) {
        this.accessDate = accessDate;
    }

    @Basic
    @Column(name = "visitor_id", nullable = true)
    public Integer getVisitorId() {
        return visitorId;
    }

    public void setVisitorId(Integer visitorId) {
        this.visitorId = visitorId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtPageAccessEntity that = (RtPageAccessEntity) o;
        return id == that.id &&
                Objects.equals(pageName, that.pageName) &&
                Objects.equals(pageId, that.pageId) &&
                Objects.equals(accessDate, that.accessDate) &&
                Objects.equals(visitorId, that.visitorId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, pageName, pageId, accessDate, visitorId);
    }
}
