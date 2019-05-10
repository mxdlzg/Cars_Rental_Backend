package com.mxdlzg.rental.domain.model;

public class LoginUser {
    private String username;
    private String password;
    private Integer rememberMe;
    private String type;

    public String getType() {
        return type;
    }


    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public Integer getRememberMe() {
        if (rememberMe == null) {
            return 0;
        } else {
            return rememberMe;
        }
    }

    public void setRememberMe(Integer rememberMe) {
        this.rememberMe = rememberMe;
    }
}
