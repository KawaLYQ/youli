package com.kawa.youli.exception;

public class FileUploadFailedException extends ServiceException{
    private static final ExceptionInfo info=ExceptionInfo.FILE_UPLOAD_FAILED;

    public FileUploadFailedException() {
        super(info);
    }

    public FileUploadFailedException(Throwable cause) {
        super(info,cause);
    }
}