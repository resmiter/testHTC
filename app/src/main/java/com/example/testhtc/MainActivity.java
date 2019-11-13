package com.example.testhtc;

import androidx.appcompat.app.AppCompatActivity;
import java.net.URL;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;


import com.example.testhtc.struct.Company;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.net.MalformedURLException;

public class MainActivity extends AppCompatActivity {
    URL url;
    public static String string;
    public Button button;

    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = findViewById(R.id.button);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Gson gson = new GsonBuilder().create();
                Company company = gson.fromJson(string, Company.class);
                Toast.makeText(MainActivity.this, company.getAge(), Toast.LENGTH_SHORT).show();
            }
        });

        try {
            url = new URL("http://www.mocky.io/v2/56fa31e0110000f920a72134");
        } catch (MalformedURLException e) {
            e.printStackTrace();
        }
    }
}
