
package com.example.foodx;

class Post {

    public String itemName, UserID, contactNumber;

    public Post() {

    }
    public Post(String itemName, String UserID, String contactNumber)
    {
//        this.expiryDate = expiryDate;
        this.contactNumber = contactNumber;
        this.itemName = itemName;
        this.UserID = UserID;
    }
}
