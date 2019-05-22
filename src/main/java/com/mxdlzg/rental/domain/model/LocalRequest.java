package com.mxdlzg.rental.domain.model;

public class LocalRequest {
    private String model;
    private int userId;

    public LocalRequest(String model, int userId) {
        this.model = model;
        this.userId = userId;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public int getUserId() {
        return userId;
    }

    public void setUserId(int userId) {
        this.userId = userId;
    }
}
