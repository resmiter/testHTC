package com.example.testhtc.api;

import java.util.concurrent.Executors;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

public class NetworkService {
    private static NetworkService mInstance;
    private static final String LINK = "http://www.mocky.io/";
    private Retrofit mRetrofit;

    private NetworkService() {
     mRetrofit = new Retrofit.Builder()
             .baseUrl(LINK)
             .callbackExecutor(Executors.newSingleThreadExecutor())
             .addConverterFactory(GsonConverterFactory.create())
             .build();
    }

    public static NetworkService getInstance() {
        if (mInstance == null) {
            mInstance = new NetworkService();
        }
        return mInstance;
    }

    public APIService getJSONApi(){
        return mRetrofit.create(APIService.class);
    }

}
