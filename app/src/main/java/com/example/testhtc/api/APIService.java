package com.example.testhtc.api;

import com.example.testhtc.struct.Company;

import retrofit2.Call;
import retrofit2.http.GET;

public interface APIService {
    @GET("v2/56fa31e0110000f920a72134")
    Call<Company> getCompany();
}
