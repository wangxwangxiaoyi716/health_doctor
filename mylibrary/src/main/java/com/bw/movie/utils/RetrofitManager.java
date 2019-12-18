package com.bw.movie.utils;
/**
 * @describe(描述)：RetrofitManager
 * @data（日期）: 2019/11/11
 * @time（时间）: 16:05
 * @author（作者）: wangxiaoyi
 **/


import com.bw.movie.Time;
import com.bw.movie.app.Constant;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import okhttp3.logging.HttpLoggingInterceptor;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

public class RetrofitManager {

    public static final String BASE_URL = Constant.BASE_URL;
    private final Retrofit retrofit;

    public static final class SingleHolder {
        private static final RetrofitManager _INSTANCE = new RetrofitManager(BASE_URL);
    }

    public static RetrofitManager getInstance() {
        return SingleHolder._INSTANCE;
    }


    private OkHttpClient buildokhttpClient() {
        //日至拦截器
        HttpLoggingInterceptor httpLoggingInterceptor = new HttpLoggingInterceptor();
        httpLoggingInterceptor.setLevel(HttpLoggingInterceptor.Level.BODY);

        return new OkHttpClient.Builder()
                /*.connectTimeout(30000, TimeUnit.SECONDS)
                .writeTimeout(30000, TimeUnit.SECONDS)
                .readTimeout(30000, TimeUnit.SECONDS)*/
                .addInterceptor(httpLoggingInterceptor)
                .build();
    }


    public RetrofitManager(String url) {
        retrofit = new Retrofit.Builder()
                .baseUrl(url)
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create())
                .addConverterFactory(GsonConverterFactory.create())
                .client(buildokhttpClient())
                .build();

    }

    public <T> T create(final Class<T> service) {
        return retrofit.create(service);
    }


}
