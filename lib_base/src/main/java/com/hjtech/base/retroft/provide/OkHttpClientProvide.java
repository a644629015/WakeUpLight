package com.hjtech.base.retroft.provide;

import com.alibaba.android.arouter.facade.template.IProvider;

import okhttp3.OkHttpClient;

/*
 * 项目名:    HjtechARouterFrame
 * 包名       com.hjtech.base.retroft
 * 文件名:    OkHttpClientProvide
 * 创建者:    ZJB
 * 创建时间:  2017/10/25 on 17:44
 * 描述:     TODO
 */

public interface OkHttpClientProvide extends IProvider {
    /**
     * 获取OkHttpClient
     *
     * @return OkHttpClient
     */
    OkHttpClient getOkHttpClient();


}
