package com.hjtech.base.base;

/*
 * 项目名:    hurricane
 * 包名       com.hjtech.baselib.mvpbase
 * 文件名:    BaseSwipActivity
 * 创建者:    ZJB
 * 创建时间:  2017/7/28 on 10:57
 * 描述:     TODO
 */

import android.content.Context;
import android.content.pm.ActivityInfo;
import android.os.Bundle;

import com.hjtech.base.utils.ActivityManager;

public abstract class BaseSwipActivity<P extends BasePresenter> extends ParallaxSwipeBackActivity implements BaseView {
    protected P presenter;
    public Context context;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);
        ActivityManager.getAppInstance().addActivity(this);
        context = this;
        presenter = initPresenter();
    }


    @Override
    protected void onDestroy() {
        ActivityManager.getAppInstance().removeActivity(this);
        if (presenter != null) {
            presenter.detach();
        }
        super.onDestroy();
    }

    public abstract P initPresenter();

    @Override
    public void showLoadingDialog(String msg) {

    }

    @Override
    public void dimissLoadingDialog() {

    }
}


