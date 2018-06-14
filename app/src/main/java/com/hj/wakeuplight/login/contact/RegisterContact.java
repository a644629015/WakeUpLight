package com.hj.wakeuplight.login.contact;
/*
 * 项目名:    WakeUpLight
 * 包名       com.hj.wakeuplight.login.contact
 * 文件名:    RegisterContact
 * 创建者:    YHF
 * 创建时间:  2018/6/14 0014 on 12:38
 * 描述:     TODO
 */

import com.hjtech.base.base.BasePresenter;
import com.hjtech.base.base.BaseView;

public interface RegisterContact {

    interface View extends BaseView {
        String getName();
    }

    interface Presenter extends BasePresenter {
        void register();
    }

}
