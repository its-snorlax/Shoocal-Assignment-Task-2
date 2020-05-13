package com.example.schoocalassignment_task2;

import java.io.Serializable;

public class FormData implements Serializable {
    private String name;
    private String gender;
    private String dob;
    private String state;
    private String city;

    public FormData(String name, String gender, String dob, String state, String city) {
        this.name = name;
        this.gender = gender;
        this.dob = dob;
        this.state = state;
        this.city = city;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public String getDob() {
        return dob;
    }

    public String getState() {
        return state;
    }

    public String getCity() {
        return city;
    }
}
