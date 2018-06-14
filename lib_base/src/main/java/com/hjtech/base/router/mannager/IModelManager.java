package com.hjtech.base.router.mannager;
/*
 * 项目名:    HjtechARouterFrame
 * 包名       com.hjtech.base.routermanager.mannager
 * 文件名:    IModelManager
 * 创建者:    YHF
 * 创建时间:  2017/10/26 0026 on 15:46
 * 描述:     TODO
 */

import com.alibaba.android.arouter.facade.template.IProvider;

public interface IModelManager extends IProvider {

    /**
     * 添加model
     *
     * @param key
     * @param value
     * @return
     */
    ModelManager addModel(String key, String value);

    /**
     * 查询是否已经添加model
     *
     * @param path
     * @return
     */
    boolean hasModel(String path);
}
