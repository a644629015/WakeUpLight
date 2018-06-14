package com.hjtech.base.retroft;

/**
 * 项目名:    HjtechARouterFrame
 * 包名       com.hjtech.base.retroft
 * 文件名:    Constant
 * 创建者:    ZJB
 * 创建时间:  2017/10/26 on 11:06
 * 描述:     TODO
 *
 * @author Administrator
 */
public interface Constant {
    /**
     * 基础url
     */
//    String BASE_URL = "http://121.40.188.122:8210/gdjc-api/";//外网地址
    String BASE_URL = "http://192.168.0.252:8210/gdjc-api/";//测试服务器
//    String BASE_URL = "http://192.168.0.81:8088/gdjc-api/";//子龙电脑
    /**
     * 基础图片
     */
//    String IMAGE_URL = "http://121.40.188.122:8210";
    String IMAGE_URL = "http://192.168.0.252:8210";
    /**
     * 接口数据100
     */
    int CODE_SUCCESS_INT = 100;
    /**
     * 接口数据100
     */
    String CODE_SUCCESS_STR = "100";
}
