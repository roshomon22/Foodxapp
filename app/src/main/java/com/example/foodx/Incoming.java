package com.example.foodx;

class Incoming {

    private String Item,location,UserName;


    public Incoming() {

    }
    public Incoming(String item, String location, String UserName)
    {
        this.Item = item;
        this.location = location;
        this.UserName = UserName;


    }


    public String getItem() {
        return Item;
    }

    public void setItem(String item) {
        Item = item;
    }



    public void setLocation (String location) {
        this.location = location;
    }

    public String getLocation() {
        return location;
    }



    public void setUserName(String UserName) {
        this.UserName = UserName;
    }

    public String getUserName() {return UserName;}




}
