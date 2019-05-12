package com.mxdlzg.rental.domain.model;

import com.mxdlzg.rental.domain.model.enums.ResponseEnums;

public class PayResult {
    private boolean finished = false;
    private double realPayPrice = 0;
    private boolean paySuccess = false;
    private String msg = "";

    public PayResult() {

    }

    public PayResult(boolean finished, String msg) {
        this.finished = finished;
        this.msg = msg;
    }

    public static PayResult hasFinished() {
        return new PayResult(true, ResponseEnums.ORDER_HAS_PAID.getMsg());
    }

    public boolean isFinished() {
        return finished;
    }

    public void setFinished(boolean finished) {
        this.finished = finished;
    }

    public double getRealPayPrice() {
        return realPayPrice;
    }

    public void setRealPayPrice(double realPayPrice) {
        this.realPayPrice = realPayPrice;
    }

    public boolean isPaySuccess() {
        return paySuccess;
    }

    public void setPaySuccess(boolean paySuccess) {
        this.paySuccess = paySuccess;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }
}
