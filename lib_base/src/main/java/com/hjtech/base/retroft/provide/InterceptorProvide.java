package com.hjtech.base.retroft.provide;

import com.alibaba.android.arouter.facade.template.IProvider;

import okhttp3.logging.HttpLoggingInterceptor;

/*
 * 项目名:    HjtechARouterFrame
 * 包名       com.hjtech.base.retroft
 * 文件名:    InterceptorProvide
 * 创建者:    ZJB
 * 创建时间:  2017/10/25 on 17:47
 * 描述:     TODO
 */

public interface InterceptorProvide extends IProvider {
    /**
     * 网络访问拦截器
     *
     * @return
     */
    HttpLoggingInterceptor getHttpLoggingInterceptor();

}
