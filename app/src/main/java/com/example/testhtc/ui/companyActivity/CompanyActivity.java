package com.example.testhtc.ui.companyActivity;

import androidx.appcompat.app.AppCompatActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import android.content.Context;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.testhtc.R;
import com.example.testhtc.adapters.CompanyAdapter;
import com.example.testhtc.struct.Company;
import com.example.testhtc.struct.Employee;
import com.example.testhtc.utils.InternetConnection;

import java.util.Collections;
import java.util.List;


public class CompanyActivity extends AppCompatActivity {
    private final Context context = this;
    private ListView listView;
    private TextView heading;
    private CompanyAdapter adapter;

    @Override
    protected void onCreate(final Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_company);

        listView = findViewById(R.id.listView);
        heading = findViewById(R.id.heading);
        listView = findViewById(R.id.listView);
        heading = findViewById(R.id.heading);

        CompanyViewModel model = ViewModelProviders.of(this).get(CompanyViewModel.class);
        model.getCompany().observe(this, new Observer<Company>() {
            @Override
            public void onChanged(Company company) {
                if (company == null) {
                    notifyError();
                    return;
                }
                List<Employee> listEmployees = company.getEmployees();
                Collections.sort(listEmployees);
                adapter = new CompanyAdapter(context, listEmployees);
                listView.setAdapter(adapter);
                heading.setText(company.toString());
            }
        });

        if (!InternetConnection.checkConnection(context))
            Toast.makeText(context, "No internet connection!", Toast.LENGTH_SHORT).show();
    }

    public void notifyError() {
        Toast.makeText(this, "Error!", Toast.LENGTH_SHORT).show();
    }
}