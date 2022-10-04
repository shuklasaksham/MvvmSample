package com.example.mvvmsample.model;

public class User {
    private String name, email, ph;

    public User(String name, String email, String ph) {
        this.name = name;
        this.email = email;
        this.ph = ph;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPh() {
        return ph;
    }

    public void setPh(String ph) {
        this.ph = ph;
    }
}
