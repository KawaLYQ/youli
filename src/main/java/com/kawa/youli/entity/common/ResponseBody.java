package com.kawa.youli.entity.common;

import com.alibaba.fastjson.JSONObject;

public class ResponseBody<T> {
    private String code;
    private String msg;
    private T data;

    public ResponseBody(){

    }

    public ResponseBody(String code, String msg, T data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public ResponseBody(ResponseInfo info) {
        this.code= info.getCode();
        this.msg= info.getMsg();
        this.data=null;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public ResponseBody success(){
        return success(null);
    }

    public ResponseBody success(T data){
        ResponseBody res=new ResponseBody();
        res.setCode(ResponseInfo.SUCCESS.getCode());
        res.setMsg(ResponseInfo.SUCCESS.getMsg());
        res.setData(data);
        return res;
    }

    public ResponseBody error(ResponseInfoInterface info){
        return error(info,null);
    }

    public ResponseBody error(ResponseInfoInterface info,T data){
        ResponseBody res=new ResponseBody();
        res.setCode(info.getCode());
        res.setMsg(info.getMsg());
        res.setData(data);
        return res;
    }

    @Override
    public String toString() {
        return JSONObject.toJSONString(this);
    }
}
