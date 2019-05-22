package com.mxdlzg.rental.domain.model;

public class LocalData{
    private boolean success;
    private int user_id;

    public LocalData() {
    }

    public LocalData(boolean success, int user_id) {
        this.success = success;
        this.user_id = user_id;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public int getUser_id() {
        return user_id;
    }

    public void setUser_id(int user_id) {
        this.user_id = user_id;
    }
}
