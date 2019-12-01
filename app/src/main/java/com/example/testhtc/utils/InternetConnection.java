package com.example.testhtc.utils;

import android.content.Context;
import android.net.ConnectivityManager;
import android.os.Handler;
import android.os.Message;

import androidx.annotation.NonNull;

import com.example.testhtc.api.NetworkService;
import com.example.testhtc.struct.Company;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InternetConnection {

    public static boolean checkConnection(@NonNull Context context) {
        return ((ConnectivityManager) context.getSystemService
                (Context.CONNECTIVITY_SERVICE)).getActiveNetworkInfo() != null;
    }

    public void loadData(final Handler handler) {
        NetworkService.getInstance()
                .getJSONApi()
                .getCompany()
                .enqueue(new Callback<Company>() {
                    @Override
                    public void onResponse(@NonNull Call<Company> call, @NonNull Response<Company> response) {
                        if (response.isSuccessful()) {
                            assert response.body() != null;
                            Message msg = new Message();
                            msg.obj = response.body().getCompany();
                            handler.sendMessage(msg);
                        }
                    }
                    @Override
                    public void onFailure(@NonNull Call<Company> call,@NonNull Throwable t) {
                        Message msg = new Message();
                        msg.obj = null;
                        handler.sendMessage(msg);

                    }
                });
    }
}
