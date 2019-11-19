package com.example.testhtc;

import androidx.appcompat.app.AppCompatActivity;

import java.net.URL;

import android.annotation.SuppressLint;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Message;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testhtc.listEmployees.CompanyAdapter;
import com.example.testhtc.struct.Company;
import com.example.testhtc.struct.Employee;
import com.example.testhtc.utils.JsonQuery;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.MalformedURLException;
import java.util.Collections;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    private final Context context = this;
    private final String LINK = "http://www.mocky.io/v2/56fa31e0110000f920a72134";
    private URL url;
    private ListView listView;
    private TextView heading;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        heading = findViewById(R.id.heading);

        try {
            url = new URL(LINK);
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }

            JsonQuery process = new JsonQuery();
            process.setHandler(handler);
            process.execute(url);

    }

    @SuppressLint("HandlerLeak")
    private Handler handler = new Handler() {
        @Override
        public void handleMessage(Message msg) {
            try {
                String request = msg.getData().getString("company");
                Gson gson = new Gson();
                Company company = gson.fromJson(request, Company.class);
                heading.setText(company.getCompany().toString());

                List<Employee> listEmployees = company.getCompany().getEmployees();
                Collections.sort(listEmployees);
                CompanyAdapter companyAdapter = new CompanyAdapter(context, listEmployees);
                listView.setAdapter(companyAdapter);
            } catch (NullPointerException e){
                Toast.makeText(context, "No internet connection!", Toast.LENGTH_SHORT).show();
            }

        }
    };
}
