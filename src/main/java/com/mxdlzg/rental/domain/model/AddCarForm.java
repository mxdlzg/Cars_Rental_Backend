package com.mxdlzg.rental.domain.model;

import javax.validation.constraints.Digits;
import javax.validation.constraints.Min;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;
import java.util.Date;

public class AddCarForm {
    @NotNull
    @NotEmpty
    private String brandName,typeName,description;
    @NotNull
    private Boolean bookAble;
    @NotNull
    private Date buyDate,manufactureDate;
    @Min(0)
    @NotNull
    private Float defaultRentPrice;
    @Min(1)
    @NotNull
    private Integer storeId,typeId,serviceTypeId;

    public AddCarForm(@NotNull @NotEmpty String brandName, @NotNull @NotEmpty String typeName, @NotNull @NotEmpty String description, @NotNull Boolean bookAble, @NotNull Date buyDate, @NotNull Date manufactureDate, @Min(0) Float defaultRentPrice, @Min(1) Integer storeId, @Min(1) Integer typeId, @Min(1) Integer serviceTypeId) {
        this.brandName = brandName;
        this.typeName = typeName;
        this.description = description;
        this.bookAble = bookAble;
        this.buyDate = buyDate;
        this.manufactureDate = manufactureDate;
        this.defaultRentPrice = defaultRentPrice;
        this.storeId = storeId;
        this.typeId = typeId;
        this.serviceTypeId = serviceTypeId;
    }

    public String getBrandName() {
        return brandName;
    }

    public void setBrandName(String brandName) {
        this.brandName = brandName;
    }

    public String getTypeName() {
        return typeName;
    }

    public void setTypeName(String typeName) {
        this.typeName = typeName;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public Boolean getBookAble() {
        return bookAble;
    }

    public void setBookAble(Boolean bookAble) {
        this.bookAble = bookAble;
    }

    public Date getBuyDate() {
        return buyDate;
    }

    public void setBuyDate(Date buyDate) {
        this.buyDate = buyDate;
    }

    public Date getManufactureDate() {
        return manufactureDate;
    }

    public void setManufactureDate(Date manufactureDate) {
        this.manufactureDate = manufactureDate;
    }

    public Float getDefaultRentPrice() {
        return defaultRentPrice;
    }

    public void setDefaultRentPrice(Float defaultRentPrice) {
        this.defaultRentPrice = defaultRentPrice;
    }

    public Integer getStoreId() {
        return storeId;
    }

    public void setStoreId(Integer storeId) {
        this.storeId = storeId;
    }

    public Integer getTypeId() {
        return typeId;
    }

    public void setTypeId(Integer typeId) {
        this.typeId = typeId;
    }

    public Integer getServiceTypeId() {
        return serviceTypeId;
    }

    public void setServiceTypeId(Integer serviceTypeId) {
        this.serviceTypeId = serviceTypeId;
    }
}
