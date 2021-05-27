
package com.example.foodx;

public class Post {

    public String itemName, UserID, contactNumber,Location, expiryDate;

    public Post() {

    }
    public Post(String itemName, String UserID, String contactNumber, String location, String expiryDate)
    {

        this.contactNumber = contactNumber;
        this.itemName = itemName;
        this.UserID = UserID;
        this.Location = location;
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


}
