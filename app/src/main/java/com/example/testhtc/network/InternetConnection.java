package com.example.testhtc.network;

import androidx.annotation.NonNull;
import androidx.lifecycle.MutableLiveData;

import com.example.testhtc.model.Company;
import com.example.testhtc.model.ResponseCompany;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class InternetConnection {

    public void loadData(final MutableLiveData<Company> companyLiveData) {
        NetworkService.getInstance()
                .getJSONApi()
                .getCompany()
                .enqueue(new Callback<ResponseCompany>() {
                    @Override
                    public void onResponse(@NonNull Call<ResponseCompany> call, @NonNull Response<ResponseCompany> response) {
                        if (response.body() != null) {
                            Company company = response.body().getCompany();
                            companyLiveData.postValue(company);
                        }
                    }

                    @Override
                    public void onFailure(@NonNull Call<ResponseCompany> call, @NonNull Throwable t) {
                    }
                });
    }
}
