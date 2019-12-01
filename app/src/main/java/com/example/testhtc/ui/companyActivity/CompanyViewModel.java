package com.example.testhtc.ui.companyActivity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testhtc.struct.Company;
import com.example.testhtc.struct.Employee;
import com.example.testhtc.utils.InternetConnection;
import com.example.testhtc.utils.ResponseHandler;

import java.util.ArrayList;


public class CompanyViewModel extends ViewModel {

    public static MutableLiveData<Company> mCompany;

    private void createRequest() {
        InternetConnection internetConnection = new InternetConnection();
        ResponseHandler handler = new ResponseHandler();
        internetConnection.loadData(handler);
    }

    private void emptyCompany() {
        mCompany = new MutableLiveData<>();
        Company weakCompany = new Company();
        weakCompany.setEmployees(new ArrayList<Employee>());
        weakCompany.setCompetences(new ArrayList<String>() {{
            add("");
        }});
        mCompany.setValue(weakCompany);

    }

    LiveData<Company> getCompany() {
        if (mCompany == null) {
            emptyCompany();
            createRequest();
        }
        return mCompany;
    }
}
