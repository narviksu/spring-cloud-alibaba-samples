package com.narvik.common.exception;

/**
 * @author : Wh1te date : 2018/02/07 e-mail : white.hcj@gmail.com desc :
 * 业务异常，在处理业务逻辑过程中发生的异常可以手动抛出，由 controller 层统一处理
 */
public class BizException extends RuntimeException {
    private static final long serialVersionUID = 1L;
    private Integer code;

    public BizException() {
        super();
    }

    public BizException(String message) {
        super(message);
    }

    public BizException(Integer code, String message) {
        super(message);
        this.code = code;
    }

    public BizException(Integer code, String message, Throwable cause) {
        super(message, cause);
        this.code = code;
    }

    public BizException(Integer code, Throwable cause) {
        super(cause);
        this.code = code;
    }

    public BizException(Integer code, String message, Throwable cause, boolean enableSuppression, boolean writableStackTrace) {
        super(message, cause, enableSuppression, writableStackTrace);
        this.code = code;
    }

    public Integer getCode() {
        return code;
    }

    public void setCode(Integer code) {
        this.code = code;
    }
}
