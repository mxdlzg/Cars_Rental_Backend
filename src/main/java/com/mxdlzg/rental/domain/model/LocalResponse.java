package com.mxdlzg.rental.domain.model;

public class LocalResponse {
    private String err_code;
    private String message;
    private LocalData data;

    public LocalResponse() {
    }

    public LocalResponse(String err_code, String message, LocalData data) {
        this.err_code = err_code;
        this.message = message;
        this.data = data;
    }

    public String getErr_code() {
        return err_code;
    }

    public void setErr_code(String err_code) {
        this.err_code = err_code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public LocalData getData() {
        return data;
    }

    public void setData(LocalData data) {
        this.data = data;
    }
}

