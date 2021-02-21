package com.kawa.youli.exception;

public class FileLoadFailedException extends ServiceException{
    private static final ExceptionInfo info=ExceptionInfo.FILE_LOAD_FAILED;

    public FileLoadFailedException() {
        super(info);
    }

    public FileLoadFailedException(Throwable cause) {
        super(info,cause);
    }
}