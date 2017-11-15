package utils;

import java.util.concurrent.TimeUnit;

import okhttp3.OkHttpClient;
import retrofit2.Retrofit;
import retrofit2.adapter.rxjava.RxJavaCallAdapterFactory;
import retrofit2.converter.gson.GsonConverterFactory;

/**
 * Created by Administrator on 2017/11/14 0014.
 */

public class RetroSort {
    public RetroSort() {
    }
    private static OkHttpClient httpClient = new OkHttpClient.Builder()
            .connectTimeout(30, TimeUnit.SECONDS)
            .build();
    private static ApiServer retrofitService = new Retrofit.Builder()
            .baseUrl(API.TYPE_PATH)
            .addConverterFactory(GsonConverterFactory.create())
            .addCallAdapterFactory(RxJavaCallAdapterFactory.create())
            .client(httpClient)
            .build()
            .create(ApiServer.class);
    //单列模式
    public static ApiServer getInstance() {
        return retrofitService;
    }
}
