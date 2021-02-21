package com.kawa.youli.exception;

public class GiftNotExistException extends ServiceException{
    private static final ExceptionInfo info=ExceptionInfo.GIFT_NOT_EXIST;

    public GiftNotExistException() {
        super(info);
    }

    public GiftNotExistException(Throwable cause) {
        super(info,cause);
    }
}