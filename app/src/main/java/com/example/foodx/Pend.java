
package com.example.foodx;

public class Pend {


    private String Item;
    private String location;
    private String UserName;


    private String Quantity;


    public Pend() {

    }
    public Pend(String item, String location, String UserName, String Quantity)
    {
        this.Item = item;
        this.location = location;
        this.UserName = UserName;
        this.Quantity=Quantity;


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
    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }







}
