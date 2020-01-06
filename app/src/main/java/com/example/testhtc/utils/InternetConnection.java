package com.example.testhtc.utils;

import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.testhtc.api.NetworkService;
import com.example.testhtc.struct.ResponseCompany;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InternetConnection {

    public void loadData(final Handler handler) {
        NetworkService.getInstance()
                .getJSONApi()
                .getCompany()
                .enqueue(new Callback<ResponseCompany>() {
                    @Override
                    public void onResponse(@NonNull Call<ResponseCompany> call, @NonNull Response<ResponseCompany> response) {
                        if (response.isSuccessful()) {
                            assert response.body() != null;
                            Message msg = new Message();
                            ResponseCompany responseCompany = response.body();
                            msg.obj = responseCompany.getCompany();
                            handler.sendMessage(msg);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ResponseCompany> call, @NonNull Throwable t) {
                    }
                });
    }
}
