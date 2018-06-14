package com.hjtech.base.base;

/*
 * 项目名:    hurricane
 * 包名       com.hjtech.baselib.mvpbase
 * 文件名:    VCodeBean
 * 创建者:    CYS
 * 创建时间:  2017/8/4 0004 on 16:43
 * 描述:     获取验证码实体类
 */
public class VCodeBean {
    /**
     * message : 获取成功
     * code : 100
     * vcode : 25131
     */

    private String message;
    private String code;
    private String vcode;

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getCode() {
        return code;
    }

    public void setCode(String code) {
        this.code = code;
    }

    public String getVcode() {
        return vcode;
    }

    public void setVcode(String vcode) {
        this.vcode = vcode;
    }
}
