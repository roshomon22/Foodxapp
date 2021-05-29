
package com.example.foodx;

public class Pend {

    private String Item,location,UserName;


    public Pend() {

    }
    public Pend(String item, String location, String UserName)
    {
        this.Item = item;
        this.location = location;
        this.UserName = UserName;


    }


    public void setItemName(String item) {
        this.Item = item;
    }

    public String getItemName() {
        return Item;
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
