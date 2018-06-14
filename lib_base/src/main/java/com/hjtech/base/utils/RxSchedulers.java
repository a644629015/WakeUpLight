package com.hjtech.base.utils;

import com.hjtech.base.base.BasePresenter;

import io.reactivex.Observable;
import io.reactivex.ObservableSource;
import io.reactivex.ObservableTransformer;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.disposables.Disposable;
import io.reactivex.functions.Consumer;
import io.reactivex.schedulers.Schedulers;

/**
 * 项目名:    LightingDetection-ss
 * 包  名:    com.hjtech.base.utils
 * 文件名:    RxSchedulers
 * 时  间:    2017/11/29 on 11:42
 * 描  述:    TODO 切换线程
 *
 * @author: zjb
 */
public class RxSchedulers {
    public static <T> ObservableTransformer<T, T> io_main(final BasePresenter basePresenter) {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                if (!NetWorkUtil.isNetworkAvailable()) {
                                    ToastUtils.showShortSafe("网络错误");
                                    disposable.dispose();
                                } else {
                                    basePresenter.addDisposable(disposable);
                                }
                            }
                        }).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }

    public static <T> ObservableTransformer<T, T> io_main() {
        return new ObservableTransformer<T, T>() {
            @Override
            public ObservableSource<T> apply(Observable<T> upstream) {
                return upstream.subscribeOn(Schedulers.io())
                        .doOnSubscribe(new Consumer<Disposable>() {
                            @Override
                            public void accept(Disposable disposable) throws Exception {
                                if (!NetWorkUtil.isNetworkAvailable()) {
                                    ToastUtils.showShortSafe("网络错误");
                                    disposable.dispose();
                                }
                            }
                        }).observeOn(AndroidSchedulers.mainThread());
            }
        };
    }


}
