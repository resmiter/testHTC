package com.example.testhtc.ui.company;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testhtc.model.Company;
import com.example.testhtc.network.InternetConnection;

public class CompanyViewModel extends ViewModel {

    private MutableLiveData<Company> mCompany;

    private void createRequest() {
        InternetConnection internetConnection = new InternetConnection();
        internetConnection.loadData(mCompany);
    }

    public LiveData<Company> getCompany() {
        if (mCompany == null) {
            mCompany = new MutableLiveData<>();
            mCompany.setValue(new Company());
            createRequest();
        }
        return mCompany;
    }
}
