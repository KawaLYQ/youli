package com.kawa.youli.exception;

import com.kawa.youli.entity.common.ResponseInfo;
import com.kawa.youli.entity.common.ResponseBody;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.validation.ObjectError;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@RestControllerAdvice
public class ExceptionControllerAdvice {
    private static final Logger logger = LoggerFactory.getLogger(ExceptionControllerAdvice.class);

    @ExceptionHandler(MethodArgumentNotValidException.class)
    public ResponseBody ServiceExceptionHandler(MethodArgumentNotValidException e){
        logger.error("发生业务异常！原因是：{}",e.getMessage());
        e.printStackTrace();
        ObjectError objectError = e.getBindingResult().getAllErrors().get(0);
        return new ResponseBody().error(ResponseInfo.BODY_NOT_MATCH,objectError.getDefaultMessage());
    }

    @ExceptionHandler(ServiceException.class)
    public ResponseBody ServiceExceptionHandler(ServiceException e){
        logger.error("发生业务异常！原因是：{}",e.getMessage());
        return new ResponseBody().error(ResponseInfo.INTERNAL_SERVER_ERROR,e.getErrorMsg());
    }

}

