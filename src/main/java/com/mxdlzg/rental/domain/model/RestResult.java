package com.mxdlzg.rental.domain.model;


import java.sql.Timestamp;
import java.util.Date;

public class RestResult<T> {
    // 状态码
    private String code;

    // 返回信息
    private String msg;

    private boolean success;
    /**
     * 请求是否成功
     */
    private String status;

    /**
     * 成功时返回的数据，失败时返回具体的异常信息
     */
    private T data;
    /**
     * 请求失败返回的提示信息，给前端进行页面展示的信息
     */
    private Object errorMessage;
    /**
     * 服务器当前时间（添加该字段的原因是便于查找定位请求时间，因为实际开发过程中服务器时间可能跟本地时间不一致，加上这个时间戳便于日后定位）
     */
    private Timestamp currentTime;

    public RestResult() {
    }

    public RestResult(boolean success, T data) {
        super();
        this.success = success;
        this.data = data;
    }

    public RestResult(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public RestResult(String status, String code, T data, Object errorMessage) {
        this.status = status;
        this.code = code;
        this.data = data;
        this.errorMessage = errorMessage;
        this.currentTime = new Timestamp(new Date().getTime());
    }

    public RestResult(boolean success, String code, String msg) {
        this.success = success;
        this.code=  code;
    }

    public static RestResult fail(String errorMessage){
        return new RestResult<String>("",errorMessage,null);
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

    public T getData() {
        return data;
    }

    public void setData(T data) {
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

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }
}
