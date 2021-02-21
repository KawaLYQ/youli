package com.kawa.youli.exception;

public class UserNotExistException extends ServiceException{
    private static final ExceptionInfo info=ExceptionInfo.USER_NOT_EXIST;

    public UserNotExistException() {
        super(info);
    }

    public UserNotExistException(Throwable cause) {
        super(info,cause);
    }
}
