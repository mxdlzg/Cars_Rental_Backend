package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rt_notify", schema = "rental", catalog = "")
public class RtNotifyEntity {
    private int id;
    private String title;
    private String content;
    private String href;
    private Boolean isRead;
    private Integer userId;

    public RtNotifyEntity() {
    }

    public RtNotifyEntity(String title, String content, String href, Integer userId) {
        this.title = title;
        this.content = content;
        this.href = href;
        this.userId = userId;
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
    @Column(name = "title", nullable = true, length = 255)
    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    @Basic
    @Column(name = "content", nullable = true, length = 255)
    public String getContent() {
        return content;
    }

    public void setContent(String content) {
        this.content = content;
    }

    @Basic
    @Column(name = "href", nullable = true, length = 255)
    public String getHref() {
        return href;
    }

    public void setHref(String href) {
        this.href = href;
    }

    @Basic
    @Column(name = "is_read", nullable = true)
    public Boolean getRead() {
        return isRead;
    }

    public void setRead(Boolean read) {
        isRead = read;
    }

    @Basic
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtNotifyEntity that = (RtNotifyEntity) o;
        return id == that.id &&
                Objects.equals(title, that.title) &&
                Objects.equals(content, that.content) &&
                Objects.equals(href, that.href) &&
                Objects.equals(isRead, that.isRead) &&
                Objects.equals(userId, that.userId);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, title, content, href, isRead, userId);
    }
}
