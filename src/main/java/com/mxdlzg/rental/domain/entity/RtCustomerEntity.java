package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rt_customer", schema = "rental", catalog = "")
public class RtCustomerEntity {
    private int id;
    private String name;
    private boolean sex;
    private int creditLevel;
    private String driverLicenseId;
    private String cardId;
    private String mobile;
    private Integer driverLicenseType;
    private Timestamp driverLicenseGetDate;
    private Timestamp driverLicenseEndDate;
    private String email;

    public RtCustomerEntity() {
    }

    public RtCustomerEntity(String name, String cardId, String mobile, String email) {
        this.name = name;
        this.cardId = cardId;
        this.mobile = mobile;
        this.email = email;
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
    @Column(name = "name", nullable = true, length = 255)
    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    @Basic
    @Column(name = "sex", nullable = false)
    public boolean isSex() {
        return sex;
    }

    public void setSex(boolean sex) {
        this.sex = sex;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtCustomerEntity that = (RtCustomerEntity) o;
        return id == that.id &&
                sex == that.sex &&
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, sex);
    }

    @Basic
    @Column(name = "credit_level", nullable = false)
    public int getCreditLevel() {
        return creditLevel;
    }

    public void setCreditLevel(int creditLevel) {
        this.creditLevel = creditLevel;
    }

    @Basic
    @Column(name = "driver_license_id", nullable = false, length = 255)
    public String getDriverLicenseId() {
        return driverLicenseId;
    }

    public void setDriverLicenseId(String driverLicenseId) {
        this.driverLicenseId = driverLicenseId;
    }

    @Basic
    @Column(name = "card_id", nullable = false, length = 255)
    public String getCardId() {
        return cardId;
    }

    public void setCardId(String cardId) {
        this.cardId = cardId;
    }

    @Basic
    @Column(name = "mobile", nullable = true, length = 20)
    public String getMobile() {
        return mobile;
    }

    public void setMobile(String mobile) {
        this.mobile = mobile;
    }

    @Basic
    @Column(name = "driver_license_type", nullable = true)
    public Integer getDriverLicenseType() {
        return driverLicenseType;
    }

    public void setDriverLicenseType(Integer driverLicenseType) {
        this.driverLicenseType = driverLicenseType;
    }

    @Basic
    @Column(name = "driver_license_get_date", nullable = true)
    public Timestamp getDriverLicenseGetDate() {
        return driverLicenseGetDate;
    }

    public void setDriverLicenseGetDate(Timestamp driverLicenseGetDate) {
        this.driverLicenseGetDate = driverLicenseGetDate;
    }

    @Basic
    @Column(name = "driver_license_end_date", nullable = true)
    public Timestamp getDriverLicenseEndDate() {
        return driverLicenseEndDate;
    }

    public void setDriverLicenseEndDate(Timestamp driverLicenseEndDate) {
        this.driverLicenseEndDate = driverLicenseEndDate;
    }

    @Basic
    @Column(name = "email", nullable = true, length = 255)
    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }
}
