package com.hj.wakeuplight.login.presenter;

import android.text.TextUtils;

import com.hj.wakeuplight.base.net.Net;
import com.hj.wakeuplight.login.contact.RegisterContact;
import com.hjtech.base.base.BasePresenterImpl;
import com.hjtech.base.retroft.RetroftUtils;
import com.hjtech.base.utils.RxSchedulers;
import com.hjtech.base.utils.ToastUtils;

import io.reactivex.functions.Consumer;

/*
 * 项目名:    WakeUpLight
 * 包名       com.hj.wakeuplight.login.presenter
 * 文件名:    RegisterPresenter
 * 创建者:    YHF
 * 创建时间:  2018/6/14 0014 on 13:34
 * 描述:     TODO
 */

public class RegisterPresenter extends BasePresenterImpl<RegisterContact.View> implements RegisterContact.Presenter {
    public RegisterPresenter(RegisterContact.View view) {
        super(view);
    }


    @Override
    public void register() {
        if (TextUtils.isEmpty(view.getName())) {
            ToastUtils.showShortSafe("请输入用户名");
            return;
        }
        RetroftUtils.getApi().create(Net.class).register(view.getName())
                .compose(RxSchedulers.<String>io_main())
                .subscribe(new Consumer<String>() {
                    @Override
                    public void accept(String s) throws Exception {
                        //成功回调
                    }
                }, new Consumer<Throwable>() {
                    @Override
                    public void accept(Throwable throwable) throws Exception {
                        //失败处理
                    }
                });
    }
}
