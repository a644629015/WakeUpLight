package com.hjtech.base.base;
/*
 * 项目名:    HjtechARouterFrame
 * 包名       com.hjtech.base.base
 * 文件名:    BaseIntent
 * 创建者:    YHF
 * 创建时间:  2017/10/26 0026 on 14:23
 * 描述:     TODO
 */


import android.app.Activity;
import android.os.Bundle;

import com.alibaba.android.arouter.launcher.ARouter;
import com.hjtech.base.app.MyApp;

import java.io.Serializable;

public class BaseIntent {

    protected static boolean HasModel(String servicePath) {
        return MyApp.getApplication().getModelManager().hasModel(servicePath);
    }

    public static void intentClass(Serializable data, String path) {

            Bundle bundle = new Bundle();
            bundle.putSerializable("data", data);
            ARouter.getInstance().build(path).with(bundle).navigation();
        }

    /**
     * staractivityForResult
     *
     * @param data        传递的数据
     * @param path        跳转的路径
     * @param activity    实例
     * @param requestCode coed
     */
    public static void intentClass(Serializable data, String path, Activity activity, int requestCode) {
            Bundle bundle = new Bundle();
            bundle.putSerializable("data", data);
            ARouter.getInstance().build(path).with(bundle).navigation(activity, requestCode);
    }

}
