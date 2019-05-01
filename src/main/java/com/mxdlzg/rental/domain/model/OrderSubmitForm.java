package com.mxdlzg.rental.domain.model;


import org.hibernate.validator.constraints.Length;

import javax.validation.constraints.*;

public class OrderSubmitForm {
    @NotNull
    @Min(1)
    private Integer carId,start,end;
    @Email
    private String email;
    @NotNull
    private Long startDate,endDate;
    @NotNull
    @NotEmpty
    private String name;
    @NotEmpty
    private String cardId;
    @NotNull
    private Integer invoiceType;
    @NotNull
    private String phone;

    public OrderSubmitForm(@NotNull @Min(1) Integer carId, @NotNull @Min(1) Integer start, @NotNull @Min(1) Integer end, @Email String email, @NotNull Long startDate, @NotNull Long endDate, @NotNull @NotEmpty String name, @NotEmpty String cardId, @NotNull Integer invoiceType, @NotNull String phone) {
        this.carId = carId;
        this.start = start;
        this.end = end;
        this.email = email;
        this.startDate = startDate;
        this.endDate = endDate;
        this.name = name;
        this.cardId = cardId;
        this.invoiceType = invoiceType;
        this.phone = phone;
    }

    public Integer getCarId() {
        return carId;
    }

    public Integer getStart() {
        return start;
    }

    public Integer getEnd() {
        return end;
    }

    public String getEmail() {
        return email;
    }

    public Long getStartDate() {
        return startDate;
    }

    public Long getEndDate() {
        return endDate;
    }

    public String getName() {
        return name;
    }

    public String getCardId() {
        return cardId;
    }

    public Integer getInvoiceType() {
        return invoiceType;
    }

    public String getPhone() {
        return phone;
    }
}
