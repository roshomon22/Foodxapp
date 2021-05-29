package com.example.foodx;

class Incoming {

    private String Item;
    private String location;
    private String ReqUserID;



    public Incoming() {

    }
    public Incoming(String item, String location, String ReqUserID)
    {
        this.Item = item;
        this.location = location;
        this.ReqUserID = ReqUserID;


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



    public void setReqUserID(String ReqUserID) {
        this.ReqUserID = ReqUserID;
    }

    public String getReqUserID() {return ReqUserID;}




}
