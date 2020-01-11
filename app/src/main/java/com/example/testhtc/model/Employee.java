package com.example.testhtc.model;

import androidx.annotation.NonNull;

import java.util.List;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;

public class Employee implements Comparable<Employee> {

    @SerializedName("name")
    @Expose
    private String name;
    @SerializedName("phone_number")
    @Expose
    private String phoneNumber;
    @SerializedName("skills")
    @Expose
    private List<String> skills;

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPhoneNumber() {
        return phoneNumber;
    }

    public void setPhoneNumber(String phoneNumber) {
        this.phoneNumber = phoneNumber;
    }

    public List<String> getSkills() {
        return skills;
    }

    public void setSkills(List<String> skills) {
        this.skills = skills;
    }

    @Override
    public int compareTo(Employee employee) {
        return name.compareTo(employee.name);
    }

    @NonNull
    @Override
    public String toString() {
        StringBuilder result = new StringBuilder("name: " + name + "\n" +
                "phone_number: " + phoneNumber + "\n" +
                "skills: ");
        for (int i = 0; i < skills.size(); i++) {
            result.append(skills.get(i)).append(", ");
        }
        result.append("!");
        result = new StringBuilder(result.toString().replace(", !", ""));
        return result.toString();
    }
}
