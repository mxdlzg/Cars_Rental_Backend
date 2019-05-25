package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rtv_order_car_info", schema = "rental", catalog = "")
public class RtvOrderCarInfoEntity {
    private int carId;
    private double defaultRentPrice;
    private Integer typeId;
    private Integer serviceTypeId;
    private Integer capability;
    private String description;
    private Double totalPrice;
    private int orderId;
    private String typeName;
    private String brandName;
    private Integer belongUserId;
    private String imageSrc;
    private Integer passengerNum;
    private Timestamp createdDate;
    private String storeName;
    private Integer startStoreId;

    @Basic
    @Column(name = "car_id", nullable = false)
    public int getCarId() {
        return carId;
    }

    public void setCarId(int carId) {
        this.carId = carId;
    }

    @Basic
    @Column(name = "default_rent_price", nullable = false, precision = 0)
    public double getDefaultRentPrice() {
        return defaultRentPrice;
    }

    public void setDefaultRentPrice(double defaultRentPrice) {
        this.defaultRentPrice = defaultRentPrice;
    }

    @Basic
    @Column(name = "type_id", nullable = true)
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "service_type_id", nullable = true)
    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }

    @Basic
    @Column(name = "capability", nullable = true)
    public Integer getCapability() {
        return capability;
    }

    public void setCapability(Integer capability) {
        this.capability = capability;
    }

    @Basic
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "total_price", nullable = true, precision = 2)
    public Double getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(Double totalPrice) {
        this.totalPrice = totalPrice;
    }

    @Id
    @Column(name = "order_id", nullable = false)
    public int getOrderId() {
        return orderId;
    }

    public void setOrderId(int orderId) {
        this.orderId = orderId;
    }

    @Basic
    @Column(name = "type_name", nullable = true, length = 255)
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Basic
    @Column(name = "brand_name", nullable = true, length = 255)
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtvOrderCarInfoEntity that = (RtvOrderCarInfoEntity) o;
        return carId == that.carId &&
                Double.compare(that.defaultRentPrice, defaultRentPrice) == 0 &&
                orderId == that.orderId &&
                Objects.equals(typeId, that.typeId) &&
                Objects.equals(serviceTypeId, that.serviceTypeId) &&
                Objects.equals(capability, that.capability) &&
                Objects.equals(description, that.description) &&
                Objects.equals(totalPrice, that.totalPrice) &&
                Objects.equals(typeName, that.typeName) &&
                Objects.equals(brandName, that.brandName);
    }

    @Override
    public int hashCode() {
        return Objects.hash(carId, defaultRentPrice, typeId, serviceTypeId, capability, description, totalPrice, orderId, typeName, brandName);
    }

    @Basic
    @Column(name = "belong_user_id", nullable = true)
    public Integer getBelongUserId() {
        return belongUserId;
    }

    public void setBelongUserId(Integer belongUserId) {
        this.belongUserId = belongUserId;
    }

    @Basic
    @Column(name = "image_src", nullable = true, length = 255)
    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    @Basic
    @Column(name = "passenger_num", nullable = true)
    public Integer getPassengerNum() {
        return passengerNum;
    }

    public void setPassengerNum(Integer passengerNum) {
        this.passengerNum = passengerNum;
    }

    @Basic
    @Column(name = "created_date", nullable = true)
    public Timestamp getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Timestamp createdDate) {
        this.createdDate = createdDate;
    }

    @Basic
    @Column(name = "store_name", nullable = true, length = 255)
    public String getStoreName() {
        return storeName;
    }

    public void setStoreName(String storeName) {
        this.storeName = storeName;
    }

    @Basic
    @Column(name = "start_store_id", nullable = true)
    public Integer getStartStoreId() {
        return startStoreId;
    }

    public void setStartStoreId(Integer startStoreId) {
        this.startStoreId = startStoreId;
    }
}
