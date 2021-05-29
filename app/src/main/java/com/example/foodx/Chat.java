package com.example.foodx;

public class Chat {

    private  String sender;
    private String receiver;
    private  String message;
    private String Itemid;

    private Chat (String sender,String receiver, String message, String Itemid)
    {
        this.sender=sender;
        this.receiver=receiver;
        this.message=message;
        this.Itemid = Itemid;

    }

    public Chat(){

    }

    public String getItemid() {
        return Itemid;
    }

    public void setItemid(String itemid) {
        Itemid = itemid;
    }

    public String getSender() {
        return sender;
    }

    public void setSender(String sender) {
        this.sender = sender;
    }

    public String getReceiver() {
        return receiver;
    }

    public void setReviecer(String receiver) {
        this.receiver = receiver;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }
}
