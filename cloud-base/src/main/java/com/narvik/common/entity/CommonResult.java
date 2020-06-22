package com.narvik.common.entity;

import com.narvik.common.constant.ResponseCode;

public class CommonResult<T> {
    private Integer code;
    private String message;
    private boolean status;
    private T data;

    public CommonResult() {
    }

    public CommonResult(Integer code, String message, boolean status, T data) {
        this.code = code;
        this.message = message;
        this.status = status;
        this.data = data;
    }

    public CommonResult(Integer code, boolean status, String message) {
        this(code, message, status, null);
    }

    public CommonResult(T data) {
        this(ResponseCode.DEFAULT_SUCCESS, "success", true, data);
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public boolean isStatus() {
        return status;
    }

    public void setStatus(boolean status) {
        this.status = status;
    }


}
