package com.hj.wakeuplight.login.contact;

import com.hjtech.base.base.BasePresenter;
import com.hjtech.base.base.BaseView;

public interface LoginContact {


    interface View extends BaseView {
        String getName();
        String getPsw();
    }

    interface Presenter extends BasePresenter {
        void login();
    }
}
