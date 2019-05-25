package com.mxdlzg.rental.domain.entity;

import javax.persistence.*;
import java.sql.Timestamp;
import java.util.Objects;

@Entity
@Table(name = "rtv_car", schema = "rental", catalog = "")
public class RtvCarEntity {
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
    private String maker;
    private String structure;
    private String color;
    private Integer passengerNum;
    private String imageSrc;
    private String introduce;
    private String label;
    private String brand;
    private String type;

    @Id
    @Column(name = "id", nullable = false)
    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    @Basic
    @Column(name = "book_able", nullable = false)
    public boolean isBookAble() {
        return bookAble;
    }

    public void setBookAble(boolean bookAble) {
        this.bookAble = bookAble;
    }

    @Basic
    @Column(name = "buy_date", nullable = true)
    public Timestamp getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Timestamp buyDate) {
        this.buyDate = buyDate;
    }

    @Basic
    @Column(name = "carcase_id", nullable = true, length = 255)
    public String getCarcaseId() {
        return carcaseId;
    }

    public void setCarcaseId(String carcaseId) {
        this.carcaseId = carcaseId;
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
    @Column(name = "engine_id", nullable = true, length = 255)
    public String getEngineId() {
        return engineId;
    }

    public void setEngineId(String engineId) {
        this.engineId = engineId;
    }

    @Basic
    @Column(name = "insurance_id", nullable = true)
    public Integer getInsuranceId() {
        return insuranceId;
    }

    public void setInsuranceId(Integer insuranceId) {
        this.insuranceId = insuranceId;
    }

    @Basic
    @Column(name = "manufacture_date", nullable = true)
    public Timestamp getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Timestamp manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    @Basic
    @Column(name = "rent_able", nullable = false)
    public boolean isRentAble() {
        return rentAble;
    }

    public void setRentAble(boolean rentAble) {
        this.rentAble = rentAble;
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
    @Column(name = "description", nullable = true, length = 255)
    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    @Basic
    @Column(name = "brand_name", nullable = true, length = 255)
    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    @Basic
    @Column(name = "fuel_id", nullable = true)
    public Integer getFuelId() {
        return fuelId;
    }

    public void setFuelId(Integer fuelId) {
        this.fuelId = fuelId;
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
    @Column(name = "store_id", nullable = true)
    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
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
    @Column(name = "latest_available_date", nullable = true)
    public Timestamp getLatestAvailableDate() {
        return latestAvailableDate;
    }

    public void setLatestAvailableDate(Timestamp latestAvailableDate) {
        this.latestAvailableDate = latestAvailableDate;
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
    @Column(name = "maker", nullable = true, length = 255)
    public String getMaker() {
        return maker;
    }

    public void setMaker(String maker) {
        this.maker = maker;
    }

    @Basic
    @Column(name = "structure", nullable = true, length = 255)
    public String getStructure() {
        return structure;
    }

    public void setStructure(String structure) {
        this.structure = structure;
    }

    @Basic
    @Column(name = "color", nullable = true, length = 255)
    public String getColor() {
        return color;
    }

    public void setColor(String color) {
        this.color = color;
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
    @Column(name = "image_src", nullable = true, length = 255)
    public String getImageSrc() {
        return imageSrc;
    }

    public void setImageSrc(String imageSrc) {
        this.imageSrc = imageSrc;
    }

    @Basic
    @Column(name = "introduce", nullable = true, length = 255)
    public String getIntroduce() {
        return introduce;
    }

    public void setIntroduce(String introduce) {
        this.introduce = introduce;
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
    @Column(name = "brand", nullable = true, length = 255)
    public String getBrand() {
        return brand;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    @Basic
    @Column(name = "type", nullable = true, length = 255)
    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        RtvCarEntity that = (RtvCarEntity) o;
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
                Objects.equals(latestAvailableDate, that.latestAvailableDate) &&
                Objects.equals(serviceTypeId, that.serviceTypeId) &&
                Objects.equals(maker, that.maker) &&
                Objects.equals(structure, that.structure) &&
                Objects.equals(color, that.color) &&
                Objects.equals(passengerNum, that.passengerNum) &&
                Objects.equals(imageSrc, that.imageSrc) &&
                Objects.equals(introduce, that.introduce) &&
                Objects.equals(label, that.label) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(type, that.type);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, bookAble, buyDate, carcaseId, defaultRentPrice, engineId, insuranceId, manufactureDate, rentAble, typeId, description, brandName, fuelId, typeName, storeId, capability, latestAvailableDate, serviceTypeId, maker, structure, color, passengerNum, imageSrc, introduce, label, brand, type);
    }
}
