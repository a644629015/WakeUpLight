package com.hjtech.base.utils;

import java.util.concurrent.TimeUnit;

import io.reactivex.Observable;
import io.reactivex.android.schedulers.AndroidSchedulers;
import io.reactivex.annotations.NonNull;
import io.reactivex.functions.Function;


/*
 * 项目名:    Pigeon
 * 包名       cn.hjtech.pigeon.common.utils
 * 文件名:    RxCountDown
 * 创建者:    ZJB
 * 创建时间:  2017/5/3 on 10:11
 * 描述:     TODO 倒计时
 */
public class RxCountDown {
    public static Observable<Integer> countdown(int time) {
        if (time < 0) time = 0;
        final int countTime = time;
        return Observable.interval(0, 1, TimeUnit.SECONDS)
                .subscribeOn(AndroidSchedulers.mainThread())
                .observeOn(AndroidSchedulers.mainThread())
                .map(new Function<Long, Integer>() {
                    @Override
                    public Integer apply(@NonNull Long aLong) throws Exception {
                        return countTime - aLong.intValue();
                    }
                })
                .take(countTime + 1);

    }
}
