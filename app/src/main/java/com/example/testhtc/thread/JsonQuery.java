package com.example.testhtc.thread;

import android.os.AsyncTask;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;
import java.net.HttpURLConnection;
import java.net.URL;


public class JsonQuery extends AsyncTask<URL, Void, String> {
    private String data = "";
    private Handler handler;

    @Override
    protected String doInBackground(URL... urls) {
        URL url = urls[0];
        try {
            HttpURLConnection httpURLConnection = (HttpURLConnection) url.openConnection();
            InputStream inputStream = httpURLConnection.getInputStream();
            BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(inputStream));
            String line = "";
            while (line != null) {
                line = bufferedReader.readLine();
                data = data + line;
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
        return null;
    }

    @Override
    protected void onPostExecute(String s) {
        super.onPostExecute(s);

        data = data.replace("}null", "}");
        Message msg = new Message();
        Bundle bundle = new Bundle();
        bundle.putString("company", data);
        msg.setData(bundle);
        handler.sendMessage(msg);
    }

    public void setHandler(Handler handler) {
        this.handler = handler;
    }
}
