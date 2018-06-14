package com.hjtech.base.app;

import android.app.Application;
import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Autowired;
import com.alibaba.android.arouter.launcher.ARouter;
import com.hjtech.base.router.mannager.IModelManager;
import com.hjtech.base.router.provider.IDetectProvider;
import com.hjtech.base.router.provider.IHomeProvider;
import com.hjtech.base.router.provider.IStatisticsProvider;
import com.hjtech.base.router.provider.IUserProvider;
import com.nostra13.universalimageloader.cache.disc.naming.Md5FileNameGenerator;
import com.nostra13.universalimageloader.cache.memory.impl.UsingFreqLimitedMemoryCache;
import com.nostra13.universalimageloader.core.ImageLoader;
import com.nostra13.universalimageloader.core.ImageLoaderConfiguration;
import com.nostra13.universalimageloader.core.assist.QueueProcessingType;
import com.nostra13.universalimageloader.core.download.BaseImageDownloader;
import com.squareup.leakcanary.LeakCanary;

/*
 * 项目名:    HjtechARouterFrame
 * 包名       com.hjtech.base.app
 * 文件名:    MyApp
 * 创建者:    ZJB
 * 创建时间:  2017/10/26 on 15:03
 * 描述:     TODO
 */

public class MyApp extends Application implements App {


    @Autowired
    IModelManager iModelManager;

    private static MyApp application;


    @Override
    public void onCreate() {
        super.onCreate();
        application = this;
//        initARouter();
        LeakCanary.install(this);
        initImageLoader(this);
    }


    public static MyApp getApplication() {
        return application;
    }


    public IModelManager getModelManager() {
        return iModelManager;
    }

    @Override
    public void initARouter() {
        ARouter.openLog();     // 打印日志
        ARouter.openDebug();   // 开启调试模式(如果在InstantRun模式下运行，必须开启调试模式！线上版本需要关闭,否则有安全风险)
        ARouter.init(this); // 尽可能早，推荐在Application中初始化
        ARouter.getInstance().inject(this);
        //将需要使用的模块添加进管理
        iModelManager.addModel(IHomeProvider.HOME_LOGIN, IHomeProvider.HOME_LOGIN);
    }

    // 图片框架初始化
    public static void initImageLoader(Context context) {
        ImageLoaderConfiguration config = new ImageLoaderConfiguration.Builder(
                context)
                // .memoryCacheExtraOptions(480, 800) // max width, max
                // height，即保存的每个缓存文件的最大长宽
                .threadPoolSize(3)
                // 线程池内加载的数量
                .threadPriority(Thread.NORM_PRIORITY - 1)
                .denyCacheImageMultipleSizesInMemory()
                .diskCacheFileNameGenerator(new Md5FileNameGenerator()) // 将保存的时候的URI名称用MD5
                // 加密
                .memoryCache(new UsingFreqLimitedMemoryCache(2 * 1024 * 1024)) // You
                // can
                // pass
                // your
                // own
                // memory
                // cache
                // implementation/你可以通过自己的内存缓存实现
                .memoryCacheSize(50 * 1024 * 1024) // 内存缓存的最大值
                .diskCacheSize(50 * 1024 * 1024) // 50 Mb sd卡(本地)缓存的最大值
                .tasksProcessingOrder(QueueProcessingType.LIFO)
                // 由原先的discCache -> diskCache
                .imageDownloader(
                        new BaseImageDownloader(context, 5 * 1000, 30 * 1000)) // connectTimeout
                // (5
                // s),
                // readTimeout
                // (30
                // s)超时时间
                .writeDebugLogs() // Remove for release app
                .build();
        // 全局初始化此配置
        ImageLoader.getInstance().init(config);
    }

}