package com.hj.wakeuplight.login.presenter;

import android.text.TextUtils;
import android.util.Log;

import com.hj.wakeuplight.base.net.Net;
import com.hj.wakeuplight.login.contact.LoginContact;
import com.hjtech.base.base.BasePresenterImpl;
import com.hjtech.base.retroft.RetroftUtils;
import com.hjtech.base.utils.RxSchedulers;
import com.hjtech.base.utils.ToastUtils;

import io.reactivex.functions.Consumer;

import static android.content.ContentValues.TAG;

public class LoginPresenter extends BasePresenterImpl<LoginContact.View> implements LoginContact.Presenter {
    public LoginPresenter(LoginContact.View view) {
        super(view);
    }

    @Override
    public void login() {
        if (TextUtils.isEmpty(view.getName())) {
            ToastUtils.showShortSafe("请输入用户名");
            return;
        }
        if (TextUtils.isEmpty(view.getPsw())) {
            ToastUtils.showShortSafe("请输入密码");
            return;
        }

        /*
        else {
            RetroftUtils.getApi().create(Net.class).register(view.getdata()[0])
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
        */
    }
}
