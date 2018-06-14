package com.hjtech.base.base;

import io.reactivex.disposables.Disposable;

/*
 * 项目名:    EasyPark
 * 包名       com.hjtech.easypark.base
 * 文件名:    BasePresenter
 * 创建者:    ZJB
 * 创建时间:  2017/6/20 on 16:21
 * 描述:     TODO
 */
public interface BasePresenter  {

    void start();

    void addDisposable(Disposable subscription);

    void unDisposable();

    void detach();


}
