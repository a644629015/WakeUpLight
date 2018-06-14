package com.hjtech.base.router.provider;
/*
 * 项目名:    LightingDetection-sc
 * 包名       com.hjtech.base.router.provider
 * 文件名:    IFragmentProvider
 * 创建者:    YHF
 * 创建时间:  2017/11/30 0030 on 10:11
 * 描述:     TODO
 */

import android.support.v4.app.Fragment;

import com.alibaba.android.arouter.facade.template.IProvider;

public interface IFragmentProvider extends IProvider{

    /**
     * 提供fragment
     * @param args
     * @return
     */
    Fragment newInstance(Object... args);
}
