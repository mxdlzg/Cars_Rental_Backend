package com.mxdlzg.rental.domain.model;

public class CheckoutResult {
    private boolean success;
    private double checkoutPrice;
    private String msg;

    public CheckoutResult(boolean success, double checkoutPrice, String msg) {
        this.success = success;
        this.checkoutPrice = checkoutPrice;
        this.msg = msg;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public double getCheckoutPrice() {
        return checkoutPrice;
    }

    public void setCheckoutPrice(double checkoutPrice) {
        this.checkoutPrice = checkoutPrice;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
