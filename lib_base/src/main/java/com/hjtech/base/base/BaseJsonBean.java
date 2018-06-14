package com.hjtech.base.base;

/*
 * 项目名:    Pigeon
 * 包名       cn.hjtech.pigeon.common.base
 * 文件名:    BaseJsonBean
 * 创建者:    CYS
 * 创建时间:  2017/4/24 on 9:38
 * 描述:     请求结果基础bean；仅用于判断操作是否成功
 */
public class BaseJsonBean<T> {
    private String code;
    private String message;

    private T data;

    public T getData() {
        return data;
    }

    public void setData(T data) {
        this.data = data;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
