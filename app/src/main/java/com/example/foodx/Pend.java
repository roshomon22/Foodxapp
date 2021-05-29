
package com.example.foodx;

public class Pend {

    private String itemName;


    public Pend() {

    }
    public Pend(String itemName)
    {
        this.itemName = itemName;


    }

    public Pend(String foodItemName, String locationAreaString, String phoneNumberString, String userID, String expiryDate) {
    }

    public String getItemName() {
        return itemName;
    }



    public void setItemName(String itemName) {
        this.itemName = itemName;
    }







}
