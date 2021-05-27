
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
    public String getItemName() {
        return itemName;
    }

    public void setItemName(String itemName) {
        this.itemName = itemName;
    }

    public String getUserID() {
        return UserID;
    }

    public void setUserID(String userID) {
        UserID = userID;
    }

    public String getContactNumber() {
        return contactNumber;
    }

    public void setContactNumber(String contactNumber) {
        this.contactNumber = contactNumber;
    }

    public String getLocation() {
        return Location;
    }

    public void setLocation(String location) {
        Location = location;
    }

    public String getExpiryDate() {
        return expiryDate;
    }

    public void setExpiryDate(String expiryDate) {
        this.expiryDate = expiryDate;
    }
}
