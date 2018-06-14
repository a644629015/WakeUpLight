package com.hjtech.base.router.model.home;


import android.support.v4.app.Fragment;

import com.hjtech.base.router.mannager.ServiceManager;

public class HomeService {

    public static Fragment getHomeFragment(Object... args) {
        return ServiceManager.getInstance().getiHomeProvider().newInstance(args);
    }

}
