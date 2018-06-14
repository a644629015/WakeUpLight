package com.hjtech.base.retroft;

import android.util.Log;

import com.google.gson.GsonBuilder;
import com.hjtech.base.app.AppData;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

import okhttp3.HttpUrl;
import okhttp3.Interceptor;
import okhttp3.OkHttpClient;
import okhttp3.Request;
import okhttp3.Response;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.converter.scalars.ScalarsConverterFactory;

/**
 * 项目名:    Pigeon
 * 包名       cn.hjtech.directory.common
 * 文件名:    RetroftUtils
 * 创建者:    ZJB
 * 创建时间:  2017/5/3 on 14:08
 * 描述:     TODO
 *
 * @author Administrator
 */
public class RetroftUtils implements Http {
    private static RetroftUtils retroftUtils = null;
    public Retrofit retrofit;

    public RetroftUtils() {
        retrofit = initBaseRetrofit();
    }

    public static Retrofit getApi() {
        if (retroftUtils == null) {
            synchronized (RetroftUtils.class) {
                retroftUtils = new RetroftUtils();
            }
        }
        return retroftUtils.getRetrofit();
    }


    public Retrofit getRetrofit() {
        return retrofit;
    }

    @Override
    public Retrofit initBaseRetrofit() {
        return new Retrofit.Builder()
                .addConverterFactory(ScalarsConverterFactory.create())
                .addConverterFactory(GsonConverterFactory.create(new GsonBuilder()
                        .setLenient()
                        .create()
                ))
                //支持RxJava
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .client(getOkHttpClient())
                .baseUrl(Constant.BASE_URL)
                .build();
    }


    /**
     * 自定义OkHttpClient拦截请求参数并加上 加密参数
     */
    private OkHttpClient getOkHttpClient() {
        OkHttpClient.Builder builder = new OkHttpClient.Builder();
        //日志显示级别
        HttpLoggingInterceptor.Level level = HttpLoggingInterceptor.Level.HEADERS;
        //新建log拦截器
        HttpLoggingInterceptor loggingInterceptor = new HttpLoggingInterceptor(new HttpLoggingInterceptor.Logger() {
            @Override
            public void log(String message) {
                Log.d("ApiUrl", "--->" + message);
            }
        });
        Interceptor interceptor = new Interceptor() {
            @Override
            public Response intercept(Chain chain) throws IOException {
                Request oldRequest = chain.request();

                // 添加新的参数
                HttpUrl.Builder authorizedUrlBuilder = oldRequest.url()
                        .newBuilder()
                        .scheme(oldRequest.url().scheme())
                        .host(oldRequest.url().host())
                        .addQueryParameter("requestCode", AppData.getInstance().getRequestCode());

                // 新的请求
                Request newRequest = oldRequest.newBuilder()
                        .method(oldRequest.method(), oldRequest.body())
                        .url(authorizedUrlBuilder.build())
                        .build();

                return chain.proceed(newRequest);
            }
        };
        loggingInterceptor.setLevel(level);
        builder.addInterceptor(loggingInterceptor);
        //设置超时
        builder.connectTimeout(15, TimeUnit.SECONDS);
        builder.readTimeout(15, TimeUnit.SECONDS);
        builder.writeTimeout(15, TimeUnit.SECONDS);
        //错误重连
        builder.retryOnConnectionFailure(true);
        builder.addInterceptor(interceptor);
        return builder.build();
    }
}
