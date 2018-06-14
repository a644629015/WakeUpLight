package com.hj.wakeuplight.base.net;
/*
 * 项目名:    WakeUpLight
 * 包名       com.hj.wakeuplight.base.net
 * 文件名:    Net
 * 创建者:    YHF
 * 创建时间:  2018/6/14 0014 on 13:39
 * 描述:     TODO
 */

import io.reactivex.Observable;
import retrofit2.http.POST;

public interface Net {

    @POST("/register/")
    Observable<String> register(String name);

}
