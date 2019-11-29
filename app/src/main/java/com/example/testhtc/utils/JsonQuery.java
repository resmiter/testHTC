package com.example.testhtc.utils;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.util.Log;
import android.widget.Toast;

import androidx.annotation.NonNull;

import com.example.testhtc.api.NetworkService;
import com.example.testhtc.struct.Company;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.MalformedURLException;
import java.net.URL;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class JsonQuery extends AsyncTask<Void, Void, String> {

    private StringBuilder data = new StringBuilder();
    private Handler handler;
    private final String LINK = "http://www.mocky.io/v2/56fa31e0110000f920a72134";
    private final String  TAG = "spdarov";


    @Override
    protected String doInBackground(Void... voids) {
//        startProcess2();
            try {
                Thread.sleep(7000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }


//        URL url = null;
//        try {
//            url = new URL(LINK);
//        } catch (MalformedURLException e) {
//            e.printStackTrace();
//        }
//        try {
//            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
//            InputStream inputStream = httpURLConnection.getInputStream();
//            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
//            String line;
//            while (true) {
//                line = bufferedReader.readLine();
//                if (line == null) break;
//                data.append(line);
//            }
//        } catch (IOException e) {
//            e.printStackTrace();
//        }
        return data.toString();
    }

    private void startProcess2() {
        NetworkService.getInstance()
                .getJSONApi()
                .getCompany()
                .enqueue(new Callback<Company>() {
                    @Override
                    public void onResponse(@NonNull Call<Company> call, @NonNull Response<Company> response) {
                        if (response.isSuccessful()) {
                            assert response.body() != null;
                            Company company = response.body().getCompany();
                            try {
                                Thread.sleep(4000);
                                    Log.i(TAG, "прошло");


                            } catch (InterruptedException e) {
                                e.printStackTrace();
                            }

                        }
                    }

                    @Override
                    public void onFailure(Call<Company> call, Throwable t) {
                    }
                });

    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        Message msg = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("company", s);
        msg.setData(bundle);
        handler.sendMessage(msg);
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
