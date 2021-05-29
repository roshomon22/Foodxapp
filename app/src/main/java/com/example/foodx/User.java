package com.example.foodx;

class User {


    public String fullName;
    public String email;
    public String phoneNo;
    public String location;
    public  String id  ;

    public User() {

    }
    public User(String name, String email, String phoneNo,String location,String id)
    {
        this.fullName = name;
        this.email = email;
        this.phoneNo = phoneNo;
        this.location = location;
        this.id=id;

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
    public void setFullName(String fullName) {
        this.fullName = fullName;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public void setPhoneNo(String phoneNo) {
        this.phoneNo = phoneNo;
    }

    public void setLocation(String location) {
        this.location = location;
    }

    public String getId() {
        return id;
    }

    public void setId(String id) {
        this.id = id;
    }
}
