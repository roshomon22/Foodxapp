package com.example.foodx;

class User {
    public String fullName;
    public String email;
    public String phoneNo;
    public String location;

    public User() {

    }
    public User(String name, String email, String phoneNo,String location)
    {
        this.fullName = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.location = location;
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

    public String getLocation() {
        return location;
    }
}
