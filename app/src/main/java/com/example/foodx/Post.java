
package com.example.foodx;

public class Post {

    private String itemName;
    private String Location;
    private String contactNumber;
    private String UserID;
    private String expiryDate;


    public Post() {

    }
    public Post(String itemName, String location, String  contactNumber, String UserID, String expiryDate)
    {
        this.itemName = itemName;
        this.Location = location;
        this.contactNumber = contactNumber;
        this.UserID = UserID;
        this.expiryDate = expiryDate;

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


}
