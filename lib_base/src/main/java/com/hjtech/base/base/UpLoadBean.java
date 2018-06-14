package com.hjtech.base.base;

/*
 * 项目名:    easypark
 * 包名       com.hjtech.easypark.base
 * 文件名:    UpLoadBean
 * 创建者:    CYS
 * 创建时间:  2017/6/30 0030 on 16:08
 * 描述:     上传文件实体类
 */
public class UpLoadBean {

    /**
     * message : 上传成功
     * code : 100
     * imgUrl : /upload/file/file-20170630160918.png
     */

    private String message;
    private String code;
    private String url;
    private String imgUrl;

    public String getImgUrl() {
        return imgUrl;
    }

    public void setImgUrl(String imgUrl) {
        this.imgUrl = imgUrl;
    }

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

    public String getUrl() {
        return url;
    }

    public void setUrl(String url) {
        this.url = url;
    }
}
