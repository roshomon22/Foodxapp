
package com.example.foodx;

import com.google.firebase.database.DatabaseReference;

public class Post {

    private String itemName;
    private String Location;
    private String contactNumber;
    private String UserID;
    private String expiryDate;
    private String Username;


    private String Quantity;


    public Post() {

    }
    public Post(String itemName,String location, String  contactNumber, String UserID, String expiryDate, String username,String quantity)
    {
        this.itemName = itemName;
        this.Quantity=quantity;
        this.Location = location;
        this.contactNumber = contactNumber;
        this.UserID = UserID;
        this.expiryDate = expiryDate;
        this.Username=username;

    }

    public Post(String foodItemName,String locationAreaString, String phoneNumberString, String userID, String expiryDate) {
    }

    public String getItemName() {
        return itemName;
    }


    public String getUserID() {
        return UserID;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public String getLocation() {
        return Location;
    }

    public String getExpiryDate() {
        return expiryDate;
    }
    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
    public String getUsername() {
        return Username;
    }

    public void setUsername(String username) {
        Username = username;
    }
    public String getQuantity() {
        return Quantity;
    }

    public void setQuantity(String quantity) {
        Quantity = quantity;
    }





}
