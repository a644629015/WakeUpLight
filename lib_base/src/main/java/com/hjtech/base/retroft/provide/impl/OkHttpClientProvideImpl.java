package com.hjtech.base.retroft.provide.impl;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hjtech.base.retroft.provide.InterceptorProvide;
import com.hjtech.base.retroft.provide.OkHttpClientProvide;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;

/*
 * 项目名:    HjtechARouterFrame
 * 包名       com.hjtech.base.retroft
 * 文件名:    OkHttpClientProvide
 * 创建者:    ZJB
 * 创建时间:  2017/10/25 on 17:44
 * 描述:     TODO
 */
@Route(path = "/net/okhttpclient")
public class OkHttpClientProvideImpl implements OkHttpClientProvide {

    @Autowired
    InterceptorProvide interceptorProvide;

    @Override
    public void init(Context context) {
        ARouter.getInstance().inject(this);
    }


    @Override
    public OkHttpClient getOkHttpClient() {
        return new OkHttpClient.Builder()
                .addInterceptor(interceptorProvide.getHttpLoggingInterceptor())
                //设置超时
                .connectTimeout(15, TimeUnit.SECONDS)
                .readTimeout(15, TimeUnit.SECONDS)
                .writeTimeout(15, TimeUnit.SECONDS)
                //错误重连
                .retryOnConnectionFailure(true).build();
    }
}
