package com.hjtech.base.router.mannager;
/*
 * 项目名:    HjtechARouterFrame
 * 包名       com.hjtech.base.router.mannager
 * 文件名:    ServiceManager
 * 创建者:    YHF
 * 创建时间:  2017/10/26 0026 on 16:00
 * 描述:     TODO model管理
 */

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hjtech.base.router.provider.IDetectProvider;
import com.hjtech.base.router.provider.IHomeProvider;
import com.hjtech.base.router.provider.IStatisticsProvider;
import com.hjtech.base.router.provider.IUserProvider;

public class ServiceManager{


    @Autowired(name = IUserProvider.USER_MAIN)
    IUserProvider iUserProvider;
    @Autowired(name = IHomeProvider.HOME_LOGIN)
    IHomeProvider iHomeProvider;



    public static  ServiceManager serviceManager;

    public IUserProvider getUserProvider() {
        return iUserProvider;
    }
    public IHomeProvider getiHomeProvider() {
        return iHomeProvider;
    }



    public ServiceManager() {
        ARouter.getInstance().inject(this);
    }

    public static ServiceManager getInstance() {
        if (serviceManager==null){
            serviceManager=new ServiceManager();
        }
        return serviceManager;
    }
}
