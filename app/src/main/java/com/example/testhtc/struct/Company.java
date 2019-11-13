package com.example.testhtc.struct;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

import java.util.ArrayList;

public class Company {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("age")
    @Expose
    private String age;
    @SerializedName("competences")
    @Expose
    private ArrayList<String> competences;
    @SerializedName("employees")
    @Expose
    private ArrayList<Employee> employees;

    public Company(){
        this.name = "";
        this.age = "";
        this.competences = null;
        this.employees = null;
    }

    public String getName() {
        return name;
    }

    public String getAge() {
        return age;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setAge(String age) {
        this.age = age;
    }

    public ArrayList<String> getCompetences() {
        return competences;
    }

    public void setCompetences(ArrayList<String> competences) {
        this.competences = competences;
    }

    public ArrayList<Employee> getEmployees() {
        return employees;
    }

    public void setEmployees(ArrayList<Employee> employees) {
        this.employees = employees;
    }
}

