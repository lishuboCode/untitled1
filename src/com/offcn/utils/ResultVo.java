package com.offcn.utils;
/*
* 封装后台响应结果的工具类
* */
public class ResultVo {
    public ResultVo() {
    }

    public ResultVo(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    private int code;//后响应成功与否状态码，自定义
    private String msg;//提示消息
    private Object data;//向前端响应数据

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }
}
