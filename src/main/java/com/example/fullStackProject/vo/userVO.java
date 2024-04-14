package com.example.fullStackProject.vo;

public class userVO {
    private String name;
    private String gender;

    public userVO() {
    }

    public userVO(String name, String gender) {
        this.name = name;
        this.gender = gender;
    }

    public String getName() {
        return name;
    }

    public String getGender() {
        return gender;
    }

    public void setGender(String gender) {
        this.gender = gender;
    }

    public void setName(String name) {
        this.name = name;
    }
}
