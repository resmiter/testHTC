package com.example.testhtc.ui;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;

import com.example.testhtc.R;
import com.example.testhtc.adapters.CompanyAdapter;
import com.example.testhtc.struct.Company;
import com.example.testhtc.struct.Employee;
import com.example.testhtc.utils.InternetConnection;
import com.example.testhtc.utils.ResponseHandler;

import java.util.ArrayList;
import java.util.List;

public class MainActivity extends AppCompatActivity {
    public Company company;
    private ListView listView;
    private final Context context = this;
    private ResponseHandler handler;
    private TextView heading;


    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        listView = findViewById(R.id.listView);
        heading = findViewById(R.id.heading);
//        getLifecycle().addObserver(new DataSaver());

        List<Employee> listEmployees = new ArrayList<Employee>();
        CompanyAdapter companyAdapter = new CompanyAdapter(context, listEmployees);
        listView.setAdapter(companyAdapter);
        handler = new ResponseHandler(heading, listView, companyAdapter);

        InternetConnection internetConnection = new InternetConnection();
        internetConnection.loadData(handler);
    }
}