package com.mxdlzg.rental.domain.model.exception;

import com.mxdlzg.rental.domain.model.enums.ResponseEnums;

public class RentalRuntimeException extends RuntimeException{
    private static final long serialVersionUID = 1L;
    protected String code;

    protected String msg;

    protected String message;//打印出的堆栈日志信息

    public RentalRuntimeException(ResponseEnums enums, String message) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
        this.message = message;
    }

    public RentalRuntimeException(ResponseEnums enums) {
        super();
        this.code = enums.getCode();
        this.msg = enums.getMsg();
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    @Override
    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
