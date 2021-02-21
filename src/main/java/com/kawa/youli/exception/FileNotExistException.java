package com.kawa.youli.exception;

public class FileNotExistException  extends ServiceException{
    private static final ExceptionInfo info=ExceptionInfo.FILE_NOT_EXIST;

    public FileNotExistException() {
        super(info);
    }

    public FileNotExistException(Throwable cause) {
        super(info,cause);
    }
}