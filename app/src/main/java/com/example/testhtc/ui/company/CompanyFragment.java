package com.example.testhtc.ui.company;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentActivity;
import androidx.lifecycle.Observer;
import androidx.lifecycle.ViewModelProviders;

import com.example.testhtc.R;
import com.example.testhtc.adapter.CompanyAdapter;
import com.example.testhtc.model.Company;
import com.example.testhtc.model.Employee;

import java.util.Collections;
import java.util.List;


public class CompanyFragment extends Fragment {

    public View onCreateView(@NonNull LayoutInflater inflater,
                             ViewGroup container, Bundle savedInstanceState) {
        CompanyViewModel companyViewModel = ViewModelProviders.of(this).get(CompanyViewModel.class);
        View root = inflater.inflate(R.layout.fragment_company, container, false);

        final ListView listView = root.findViewById(R.id.listEmployees);
        final TextView heading = root.findViewById(R.id.heading);

        companyViewModel.getCompany().observe(this, new Observer<Company>() {
            @Override
            public void onChanged(Company company) {
                List<Employee> listEmployees = company.getEmployees();
                Collections.sort(listEmployees);
                FragmentActivity fragmentActivity = getActivity();
                if (fragmentActivity != null) {
                    CompanyAdapter adapter = new CompanyAdapter(fragmentActivity, listEmployees);
                    listView.setAdapter(adapter);
                    heading.setText(company.toString());
                }
            }
        });
        return root;
    }
}
