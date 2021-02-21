package com.kawa.youli.exception;

public enum ExceptionInfo implements ExceptionInfoInterface {
    //自定义异常码
    USER_NOT_LOGGED_IN("5000", "用户未登录,请登录"),
    USER_LOGIN_ERROR("5001", "账号不存在或密码错误"),
    USER_ACCOUNT_FORBIDDEN( "5002", "账号已被禁用"),
    USER_NOT_EXIST("5003", "用户不存在"),
    USER_HAS_EXISTED ("5004", "用户已存在"),
    STRATEGY_NOT_EXIST("5005","攻略不存在"),
    GIFT_NOT_EXIST("5006","礼物不存在"),
    FILE_LOAD_FAILED("5007","资源获取失败"),
    FILE_UPLOAD_FAILED("5008","资源上传失败"),
    FILE_NOT_EXIST("5009", "资源不存在"),
    ;

    /** 操作码 */
    private String Code;

    /** 操作描述 */
    private String Msg;

    ExceptionInfo(String code, String msg) {
        this.Code = code;
        this.Msg = msg;
    }

    @Override
    public String getCode() {
        return Code;
    }

    @Override
    public String getMsg() {
        return Msg;
    }

}
