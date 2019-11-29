package com.example.testhtc.utils;

import android.os.Message;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;

import com.example.testhtc.adapters.CompanyAdapter;
import com.example.testhtc.struct.Company;
import com.example.testhtc.struct.Employee;

import java.util.Collections;
import java.util.List;

public class ResponseHandler extends android.os.Handler {

    TextView heading;
    ListView listView;
    CompanyAdapter adapter;

    public ResponseHandler(TextView heading, ListView listView, CompanyAdapter adapter) {
        this.heading = heading;
        this.listView = listView;
        this.adapter = adapter;
    }

    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);

        Company company = (Company) msg.obj;

        heading.setText(company.toString());

        List<Employee> listEmployees = company.getEmployees();
        Collections.sort(listEmployees);

        adapter.setEmployeeList(listEmployees);
        CompanyAdapter companyAdapter = adapter;
        listView.setAdapter(companyAdapter);
    }
}
