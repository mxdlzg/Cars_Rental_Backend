package com.mxdlzg.rental.domain.entity;


import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rt_current_user", schema = "rental", catalog = "")
public class RtCurrentUserEntity {
    private String name;
    private long notifyCount;
    private Integer unreadCount;
    private String avatar;
    private String status;
    private String email;
    private String signature;
    private String title;
    private String phone;
    private Integer age;
    private Integer integral;
    private String role;
    private String gender;
    private Integer userId;

    @Basic
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "notifyCount", nullable = false)
    public long getNotifyCount() {
        return notifyCount;
    }

    public void setNotifyCount(long notifyCount) {
        this.notifyCount = notifyCount;
    }

    @Basic
    @Column(name = "unreadCount", nullable = true, precision = 0)
    public Integer getUnreadCount() {
        return unreadCount;
    }

    public void setUnreadCount(Integer unreadCount) {
        this.unreadCount = unreadCount;
    }

    @Basic
    @Column(name = "avatar", nullable = true, length = 255)
    public String getAvatar() {
        return avatar;
    }

    public void setAvatar(String avatar) {
        this.avatar = avatar;
    }

    @Basic
    @Column(name = "status", nullable = true, length = 255)
    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    @Basic
    @Column(name = "signature", nullable = true, length = 255)
    public String getSignature() {
        return signature;
    }

    public void setSignature(String signature) {
        this.signature = signature;
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
    @Column(name = "phone", nullable = true, length = 255)
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "age", nullable = true)
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "integral", nullable = true)
    public Integer getIntegral() {
        return integral;
    }

    public void setIntegral(Integer integral) {
        this.integral = integral;
    }

    @Basic
    @Column(name = "role", nullable = true, length = 255)
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Basic
    @Column(name = "gender", nullable = true, length = 1)
    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtCurrentUserEntity that = (RtCurrentUserEntity) o;
        return notifyCount == that.notifyCount &&
                Objects.equals(name, that.name) &&
                Objects.equals(unreadCount, that.unreadCount) &&
                Objects.equals(avatar, that.avatar) &&
                Objects.equals(status, that.status) &&
                Objects.equals(email, that.email) &&
                Objects.equals(signature, that.signature) &&
                Objects.equals(title, that.title) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(age, that.age) &&
                Objects.equals(integral, that.integral) &&
                Objects.equals(role, that.role) &&
                Objects.equals(gender, that.gender);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, notifyCount, unreadCount, avatar, status, email, signature, title, phone, age, integral, role, gender);
    }

    @Id
    @Column(name = "user_id", nullable = true)
    public Integer getUserId() {
        return userId;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }
}
