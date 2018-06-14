package com.hjtech.base.base;


import java.lang.ref.WeakReference;

import io.reactivex.disposables.CompositeDisposable;
import io.reactivex.disposables.Disposable;


/**
 * 项目名:    EasyPark
 * 包名       com.hjtech.easypark.common.base
 * 文件名:    BasePresenterImpl
 * 创建者:    ZJB
 * 创建时间:  2017/6/20 on 14:17
 * 描述:     TODO
 *
 * @author ZJB
 */
public abstract class BasePresenterImpl<V extends BaseView> implements BasePresenter {

    protected V view;
    private final WeakReference<V> vWeakReference;

    public BasePresenterImpl(V view) {
        vWeakReference = new WeakReference<>(view);
        this.view = vWeakReference.get();
        start();
    }


    @Override
    public void detach() {
        this.view = null;
        unDisposable();
    }

    @Override
    public void start() {

    }


    /**
     * 将所有正在处理的Subscription都添加到CompositeSubscription中。统一退出的时候注销观察
     */
    private CompositeDisposable mCompositeDisposable;

    @Override
    public void addDisposable(Disposable subscription) {
        //csb 如果解绑了的话添加 sb 需要新的实例否则绑定时无效的
        if (mCompositeDisposable == null || mCompositeDisposable.isDisposed()) {
            mCompositeDisposable = new CompositeDisposable();
        }
        mCompositeDisposable.add(subscription);
    }

    /**
     * 在界面退出等需要解绑观察者的情况下调用此方法统一解绑，防止Rx造成的内存泄漏
     */
    @Override
    public void unDisposable() {
        if (mCompositeDisposable != null) {
            mCompositeDisposable.dispose();
        }
    }


}
