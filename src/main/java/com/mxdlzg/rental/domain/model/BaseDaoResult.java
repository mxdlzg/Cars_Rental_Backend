package com.mxdlzg.rental.domain.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.mxdlzg.rental.domain.model.enums.ResponseEnums;

public class BaseDaoResult {
    @JsonIgnore
    private ResponseEnums enums;
    @JsonIgnore
    private boolean success = true;

    public BaseDaoResult() {
    }

    public BaseDaoResult(ResponseEnums enums) {
        this.success = false;
        this.enums = enums;
    }

    public BaseDaoResult(ResponseEnums enums, boolean success) {
        this.enums = enums;
        this.success = success;
    }
}
