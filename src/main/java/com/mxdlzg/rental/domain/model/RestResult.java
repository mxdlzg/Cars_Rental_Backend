package com.mxdlzg.rental.domain.model;


import java.sql.Timestamp;
import java.util.Date;

public class RestResult {
    // http 状态码
    private String code;

    // 返回信息
    private String msg;

    /**
     * 请求是否成功
     */
    private String status;

    /**
     * 成功时返回的数据，失败时返回具体的异常信息
     */
    private Object data;
    /**
     * 请求失败返回的提示信息，给前端进行页面展示的信息
     */
    private Object errorMessage;
    /**
     * 服务器当前时间（添加该字段的原因是便于查找定位请求时间，因为实际开发过程中服务器时间可能跟本地时间不一致，加上这个时间戳便于日后定位）
     */
    private Timestamp currentTime;

    public RestResult(String code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RestResult(String status, String code, Object data, Object errorMessage) {
        this.status = status;
        this.code = code;
        this.data = data;
        this.errorMessage = errorMessage;
        this.currentTime = new Timestamp(new Date().getTime());
    }

    @Override
    public String toString() {
        return "RestResult{" +
                "status=" + status +
                ", code='" + code + '\'' +
                ", data=" + data +
                ", errorMessage=" + errorMessage +
                ", currentTime=" + currentTime +
                '}';
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

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

    public Object getErrorMessage() {
        return errorMessage;
    }

    public void setErrorMessage(Object errorMessage) {
        this.errorMessage = errorMessage;
    }

    public Timestamp getCurrentTime() {
        return currentTime;
    }

    public void setCurrentTime(Timestamp currentTime) {
        this.currentTime = currentTime;
    }
}
