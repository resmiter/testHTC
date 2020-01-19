package com.example.testhtc.network;

import com.example.testhtc.api.APIService;

import java.util.concurrent.Executors;

import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;

class NetworkService {
    private static NetworkService mInstance;
    private final String LINK = "http://www.mocky.io/";
    private Retrofit mRetrofit;

    private NetworkService() {
        mRetrofit = new Retrofit.Builder()
                .baseUrl(LINK)
                .callbackExecutor(Executors.newSingleThreadExecutor())
                .addConverterFactory(GsonConverterFactory.create())
                .build();
    }

    static NetworkService getInstance() {
        if (mInstance == null) mInstance = new NetworkService();
        return mInstance;
    }

    APIService getJSONApi() {
        return mRetrofit.create(APIService.class);
    }
}
