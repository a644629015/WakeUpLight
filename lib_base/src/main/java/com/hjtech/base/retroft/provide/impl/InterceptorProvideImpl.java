package com.hjtech.base.retroft.provide.impl;

import android.content.Context;
import android.util.Log;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.hjtech.base.retroft.provide.InterceptorProvide;

import okhttp3.logging.HttpLoggingInterceptor;

/*
 * 项目名:    HjtechARouterFrame
 * 包名       com.hjtech.base.retroft
 * 文件名:    InterceptorProvide
 * 创建者:    ZJB
 * 创建时间:  2017/10/25 on 17:47
 * 描述:     TODO
 */
@Route(path = "/net/interceptor")
public class InterceptorProvideImpl implements InterceptorProvide {

    @Override
    public void init(Context context) {
    }


    @Override
    public HttpLoggingInterceptor getHttpLoggingInterceptor() {
        //日志显示级别Level.HEADERS
        return new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("TAG", "--->" + message);
            }
        }).setLevel(HttpLoggingInterceptor.Level.HEADERS);
    }
}
