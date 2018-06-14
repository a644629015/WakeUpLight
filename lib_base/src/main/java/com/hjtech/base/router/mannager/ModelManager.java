package com.hjtech.base.router.mannager;
/*
 * 项目名:    HjtechARouterFrame
 * 包名       com.hjtech.base.routermanager.mannager
 * 文件名:    ModelManager
 * 创建者:    YHF
 * 创建时间:  2017/10/26 0026 on 14:01
 * 描述:     TODO
 */

import android.content.Context;

import com.alibaba.android.arouter.facade.annotation.Route;

import java.util.HashMap;
import java.util.Map;
@Route(path = "/manager/model")
public class ModelManager implements IModelManager {
    private Map<String, String> modelMap;



    @Override
    public ModelManager addModel(String key, String value) {
        modelMap.put(key, value);
        return this;
    }

    @Override
    public boolean hasModel(String path) {
        return modelMap.containsKey(path);
    }

    @Override
    public void init(Context context) {
        modelMap = new HashMap<>();
    }
}
