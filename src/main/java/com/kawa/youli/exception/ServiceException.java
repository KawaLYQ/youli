package com.kawa.youli.exception;


import com.alibaba.fastjson.JSONObject;
import org.springframework.http.HttpStatus;

public class ServiceException extends RuntimeException {
    private String errorCode;
    private String errorMsg;

    public ServiceException(){
        super();
    }

    public ServiceException(ExceptionInfoInterface info) {
        super(info.getCode());
        this.errorCode = info.getCode();
        this.errorMsg=info.getMsg();
    }

    public ServiceException(ExceptionInfoInterface info, Throwable cause) {
        super(cause.getMessage(),cause);
        this.errorCode = info.getCode();
        this.errorMsg=info.getMsg();
    }

    public String getErrorCode() {
        return errorCode;
    }

    public void setErrorCode(String errorCode) {
        this.errorCode = errorCode;
    }

    public String getErrorMsg() {
        return errorMsg;
    }

    public void setErrorMsg(String errorMsg) {
        this.errorMsg = errorMsg;
    }

}
