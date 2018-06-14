package com.hjtech.base.base;
/*
 * 项目名:    HjtechARouterFrame
 * 包名       com.hjtech.base.base
 * 文件名:    BaseInterceptor
 * 创建者:    YHF
 * 创建时间:  2017/11/28 0028 on 10:35
 * 描述:     TODO 通用拦截器
 */

import android.content.Context;

import com.alibaba.android.arouter.facade.Postcard;
import com.alibaba.android.arouter.facade.annotation.Interceptor;
import com.alibaba.android.arouter.facade.callback.InterceptorCallback;
import com.alibaba.android.arouter.facade.template.IInterceptor;

@Interceptor(priority = 8, name = "公用拦截器")
public class BaseInterceptor implements IInterceptor {
    @Override
    public void process(Postcard postcard, InterceptorCallback callback) {
        callback.onContinue(postcard);
//        if ("User".equals(postcard.getGroup())){
//            callback.onContinue(postcard);  // 处理完成，交还控制权
//        }else {
//            // 觉得有问题，中断路由流程
//            callback.onInterrupt(new RuntimeException("我觉得有点异常"));
//        }


    }

    @Override
    public void init(Context context) {

    }
}
