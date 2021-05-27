
package com.example.foodx;

class Post {

    public String itemName, UserID, contactNumber,Location, expiryDate;

    public Post() {

    }
    public Post(String itemName, String UserID, String contactNumber, String Location, String expiryDate)
    {

        this.contactNumber = contactNumber;
        this.itemName = itemName;
        this.UserID = UserID;
        this.Location = Location;
        this.expiryDate = expiryDate;
    }
}
