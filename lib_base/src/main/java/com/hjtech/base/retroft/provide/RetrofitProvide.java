package com.hjtech.base.retroft.provide;

import com.alibaba.android.arouter.facade.template.IProvider;

import retrofit2.Retrofit;

/*
 * 项目名:    HjtechARouterFrame
 * 包名       com.hjtech.base.retroft
 * 文件名:    RetrofitProvide
 * 创建者:    ZJB
 * 创建时间:  2017/10/25 on 17:45
 * 描述:     TODO
 */

public interface RetrofitProvide extends IProvider {

    Retrofit getRetrofit(String url);

    Retrofit getRetrofit();
}
