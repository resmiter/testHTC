package com.example.testhtc.utils;

import android.os.Message;

import androidx.annotation.NonNull;

import com.example.testhtc.struct.Company;
import com.example.testhtc.ui.companyActivity.CompanyViewModel;

public class ResponseHandler extends android.os.Handler {

    @Override
    public void handleMessage(@NonNull Message msg) {
        super.handleMessage(msg);
        Company company = (Company) msg.obj;
        CompanyViewModel.mCompany.setValue(company);
    }
}
