package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name = "rt_user", schema = "rental", catalog = "")
public class RtUserEntity {
    private int id;
    private Integer age;
    private String password;
    private String phone;
    private Integer sex;
    private String token;
    private String username;
    private String role;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "age")
    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    @Basic
    @Column(name = "password")
    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    @Basic
    @Column(name = "phone")
    public String getPhone() {
        return phone;
    }

    public void setPhone(String phone) {
        this.phone = phone;
    }

    @Basic
    @Column(name = "sex")
    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    @Basic
    @Column(name = "token")
    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    @Basic
    @Column(name = "username")
    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    @Basic
    @Column(name = "role")
    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtUserEntity that = (RtUserEntity) o;
        return id == that.id &&
                Objects.equals(age, that.age) &&
                Objects.equals(password, that.password) &&
                Objects.equals(phone, that.phone) &&
                Objects.equals(sex, that.sex) &&
                Objects.equals(token, that.token) &&
                Objects.equals(username, that.username) &&
                Objects.equals(role, that.role);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, age, password, phone, sex, token, username, role);
    }
}
