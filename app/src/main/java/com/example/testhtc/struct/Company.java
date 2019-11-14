package com.example.testhtc.struct;

import androidx.annotation.NonNull;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Company {

    @SerializedName("company")
    @Expose
    private Company company;
    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("competences")
    @Expose
    private List<String> competences = null;
    @SerializedName("employees")
    @Expose
    private List<Employee> employees = null;


    public Company getCompany() {
        return company;
    }

    public void setCompany(Company company) {
        this.company = company;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getAge() {
        return age;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public List<String> getCompetences() {
        return competences;
    }

    public void setCompetences(List<String> competences) {
        this.competences = competences;
    }

    public List<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(List<Employee> employees) {
        this.employees = employees;
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("name: " + name + "\n" +
                "age: " + age + "\n" +
                "competences: ");
        for (int i = 0; i < competences.size(); i++) {
            result.append(competences.get(i)).append(", ");
        }
        result.append("!");
        result = new StringBuilder(result.toString().replace(", !", ""));
        return result.toString();
    }
}