package com.kawa.youli.entity.common;

public enum ResponseInfo implements ResponseInfoInterface{
    // 状态大类码定义
    SUCCESS("200", "成功!"),
    BODY_NOT_MATCH("400","请求的数据格式不符!"),
    SIGNATURE_NOT_MATCH("401","请求的数字签名不匹配!"),
    NOT_FOUND("404", "未找到该资源!"),
    INTERNAL_SERVER_ERROR("500", "服务器内部错误!"),
    SERVER_BUSY("503","服务器正忙，请稍后再试!"),
    ;

    /** 操作码 */
    private String Code;

    /** 操作描述 */
    private String Msg;

    ResponseInfo(String code, String msg) {
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
