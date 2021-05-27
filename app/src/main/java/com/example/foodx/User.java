package com.example.foodx;

class User {
    public String fullName;
    public String email;
    public String phoneNo;

    public User() {

    }
    public User(String name, String email, String phoneNo)
    {
        this.fullName = name;
        this.email = email;
        this.phoneNo = phoneNo;
    }
    public String getFullName() {
        return fullName;
    }

    public String getEmail() {
        return email;
    }

    public String getPhoneNo() {
        return phoneNo;
    }
}
