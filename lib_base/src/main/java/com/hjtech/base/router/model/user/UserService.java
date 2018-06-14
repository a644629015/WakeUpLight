package com.hjtech.base.router.model.user;
/*
 * 项目名:    LightingDetection-sc
 * 包名       com.hjtech.base.router.model.user
 * 文件名:    UserService
 * 创建者:    YHF
 * 创建时间:  2017/12/1 0001 on 9:34
 * 描述:     TODO
 */

import android.support.v4.app.Fragment;

import com.hjtech.base.router.mannager.ServiceManager;

public class UserService {


    public static Fragment getUserFragment(Object...args) {
        return ServiceManager.getInstance().getUserProvider().newInstance(args);
    }
}
