package com.hjtech.base.retroft.provide.impl;

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.facade.annotation.Route;
import com.alibaba.android.arouter.launcher.ARouter;
import com.google.gson.GsonBuilder;
import com.hjtech.base.retroft.Constant;
import com.hjtech.base.retroft.provide.OkHttpClientProvide;
import com.hjtech.base.retroft.provide.RetrofitProvide;

import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/*
 * 项目名:    HjtechARouterFrame
 * 包名       com.hjtech.base.retroft
 * 文件名:    RetrofitProvide
 * 创建者:    ZJB
 * 创建时间:  2017/10/25 on 17:45
 * 描述:     TODO
 */
@Route(path = "/net/retrofit")
public class RetrofitProvideImpl implements RetrofitProvide {
    @Autowired
    OkHttpClientProvide okHttpClientProvide;

    @Override

    public Retrofit getRetrofit(String url) {
        return new Retrofit.Builder()
                //字符串支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //Gson支持
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                        .setLenient()
                        .create()
                ))
                //支持RxJava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClientProvide.getOkHttpClient())
                .baseUrl(url)
                .build();
    }

    @Override
    public Retrofit getRetrofit() {
        return new Retrofit.Builder()
                //字符串支持
                .addConverterFactory(ScalarsConverterFactory.create())
                //Gson支持
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                        .setLenient()
                        .create()
                ))
                //支持RxJava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(okHttpClientProvide.getOkHttpClient())
                .baseUrl(Constant.BASE_URL)
                .build();
    }

    @Override
    public void init(Context context) {
        ARouter.getInstance().inject(this);
    }
}
