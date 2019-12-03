package com.example.testhtc.ui.mainActivity;

import androidx.lifecycle.LiveData;
import androidx.lifecycle.MutableLiveData;
import androidx.lifecycle.ViewModel;

import com.example.testhtc.struct.Company;
import com.example.testhtc.utils.InternetConnection;
import com.example.testhtc.utils.ResponseHandler;


public class MainViewModel extends ViewModel {

    public static MutableLiveData<Company> mCompany;

    private void createRequest() {
        InternetConnection internetConnection = new InternetConnection();
        internetConnection.loadData(new ResponseHandler());
    }

    LiveData<Company> getCompany() {
        if (mCompany == null) {
            mCompany = new MutableLiveData<>();
            mCompany.setValue(new Company());
            createRequest();

        }
        return mCompany;
    }
}
