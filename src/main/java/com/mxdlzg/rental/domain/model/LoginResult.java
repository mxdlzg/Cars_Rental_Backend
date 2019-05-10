package com.mxdlzg.rental.domain.model;

public class LoginResult {
    private String type,currentAuthority;

    public LoginResult(String type, String currentAuthority) {
        this.type = type;
        this.currentAuthority = currentAuthority;
    }

    public String getType() {
        return type;
    }

    public void setType(String type) {
        this.type = type;
    }

    public String getCurrentAuthority() {
        return currentAuthority;
    }

    public void setCurrentAuthority(String currentAuthority) {
        this.currentAuthority = currentAuthority;
    }
}
