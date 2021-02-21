package com.kawa.youli.exception;

public class StrategyNotExistException extends ServiceException{
    private static final ExceptionInfo info=ExceptionInfo.STRATEGY_NOT_EXIST;

    public StrategyNotExistException() {
        super(info);
    }

    public StrategyNotExistException(Throwable cause) {
        super(info,cause);
    }
}