package com.kawa.youli.exception;

import com.kawa.youli.entity.common.ResponseInfo;

public class UserAlreadyExistException extends ServiceException {
    private static final ExceptionInfo info=ExceptionInfo.USER_HAS_EXISTED;

    public UserAlreadyExistException(){
        super(info);
    }

    public UserAlreadyExistException(Throwable cause){
        super(info,cause);
    }
}
