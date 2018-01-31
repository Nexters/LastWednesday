package com.teamnexters.lastwednesday.network;

import com.facebook.stetho.okhttp3.StethoInterceptor;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava2.RxJava2CallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by JY on 2018-01-31.
 */

public class ServerGenerator {

    private final static String BASE_URL = "https://api.github.com/";

    private static OkHttpClient getClient() {
        return new OkHttpClient.Builder()
                .addNetworkInterceptor(new StethoInterceptor()) //인터셉터 등록
                .build();
    }

    private static Retrofit getServiceApi() {
        return new Retrofit.Builder()
                .baseUrl(BASE_URL)
                .client(getClient())
                .addConverterFactory(GsonConverterFactory.create()) //Gson 컨버터 등록
                .addCallAdapterFactory(RxJava2CallAdapterFactory.create()) //RxJava2사용위해 등록
                .build();
    }

    public static ServiceApi getInstance() {
        return getServiceApi().create(ServiceApi.class); //서비스 구현체 반환
    }
}
