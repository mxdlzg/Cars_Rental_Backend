package com.mxdlzg.rental.domain.entity;

import com.fasterxml.jackson.annotation.JsonIgnoreProperties;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@JsonIgnoreProperties(value = {"hibernateLazyInitializer", "handler"})
@Entity
@Table(name = "rt_car", schema = "rental", catalog = "")
public class RtCarEntity {
    private int id;
    private boolean bookAble;
    private Timestamp buyDate;
    private String carcaseId;
    private double defaultRentPrice;
    private String engineId;
    private Integer insuranceId;
    private Timestamp manufactureDate;
    private boolean rentAble;
    private Integer typeId;
    private String description;
    private String brandName;
    private Integer fuelId;
    private String typeName;
    private Integer storeId;
    private Integer capability;
    private Timestamp latestAvailableDate;
    private Integer serviceTypeId;

    @Id
    @Column(name = "id")
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "book_able")
    public boolean isBookAble() {
        return bookAble;
    }

    public void setBookAble(boolean bookAble) {
        this.bookAble = bookAble;
    }

    @Basic
    @Column(name = "buy_date")
    public Timestamp getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Timestamp buyDate) {
        this.buyDate = buyDate;
    }

    @Basic
    @Column(name = "carcase_id")
    public String getCarcaseId() {
        return carcaseId;
    }

    public void setCarcaseId(String carcaseId) {
        this.carcaseId = carcaseId;
    }

    @Basic
    @Column(name = "default_rent_price")
    public double getDefaultRentPrice() {
        return defaultRentPrice;
    }

    public void setDefaultRentPrice(double defaultRentPrice) {
        this.defaultRentPrice = defaultRentPrice;
    }

    @Basic
    @Column(name = "engine_id")
    public String getEngineId() {
        return engineId;
    }

    public void setEngineId(String engineId) {
        this.engineId = engineId;
    }

    @Basic
    @Column(name = "insurance_id")
    public Integer getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    @Basic
    @Column(name = "manufacture_date")
    public Timestamp getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Timestamp manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Basic
    @Column(name = "rent_able")
    public boolean isRentAble() {
        return rentAble;
    }

    public void setRentAble(boolean rentAble) {
        this.rentAble = rentAble;
    }

    @Basic
    @Column(name = "type_id")
    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    @Basic
    @Column(name = "description")
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "brand_name")
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Basic
    @Column(name = "fuel_id")
    public Integer getFuelId() {
        return fuelId;
    }

    public void setFuelId(Integer fuelId) {
        this.fuelId = fuelId;
    }

    @Basic
    @Column(name = "type_name")
    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    @Basic
    @Column(name = "store_id")
    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    @Basic
    @Column(name = "capability")
    public Integer getCapability() {
        return capability;
    }

    public void setCapability(Integer capability) {
        this.capability = capability;
    }

    @Basic
    @Column(name = "latest_available_date")
    public Timestamp getLatestAvailableDate() {
        return latestAvailableDate;
    }

    public void setLatestAvailableDate(Timestamp latestAvailableDate) {
        this.latestAvailableDate = latestAvailableDate;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtCarEntity that = (RtCarEntity) o;
        return id == that.id &&
                bookAble == that.bookAble &&
                Double.compare(that.defaultRentPrice, defaultRentPrice) == 0 &&
                rentAble == that.rentAble &&
                Objects.equals(buyDate, that.buyDate) &&
                Objects.equals(carcaseId, that.carcaseId) &&
                Objects.equals(engineId, that.engineId) &&
                Objects.equals(insuranceId, that.insuranceId) &&
                Objects.equals(manufactureDate, that.manufactureDate) &&
                Objects.equals(typeId, that.typeId) &&
                Objects.equals(description, that.description) &&
                Objects.equals(brandName, that.brandName) &&
                Objects.equals(fuelId, that.fuelId) &&
                Objects.equals(typeName, that.typeName) &&
                Objects.equals(storeId, that.storeId) &&
                Objects.equals(capability, that.capability) &&
                Objects.equals(latestAvailableDate, that.latestAvailableDate);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookAble, buyDate, carcaseId, defaultRentPrice, engineId, insuranceId, manufactureDate, rentAble, typeId, description, brandName, fuelId, typeName, storeId, capability, latestAvailableDate);
    }

    @Basic
    @Column(name = "service_type_id")
    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }
}
