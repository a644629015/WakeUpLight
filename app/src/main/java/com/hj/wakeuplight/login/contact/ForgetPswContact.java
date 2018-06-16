package com.hj.wakeuplight.login.contact;
/*
 * 项目名:    WakeUpLight
 * 包名       com.hj.wakeuplight.login.contact
 * 文件名:    RegisterContact
 * 创建者:    YHF
 * 创建时间:  2018/6/14 0014 on 12:38
 * 描述:     TODO
 */

import android.widget.EditText;
import android.widget.ImageView;

import com.hjtech.base.base.BasePresenter;
import com.hjtech.base.base.BaseView;

public interface ForgetPswContact {

    interface View extends BaseView {
        String getName();
        String getPass();
        String getPassagain();
        String getCode();
        void countDown();
        void showLlyt(int i);
        void registerSuccess();
    }

    interface Presenter extends BasePresenter {
        void reset();
        void getCode();
        void verfi();//验证验证码
        void chageEyes(ImageView image, EditText text);
    }

}
