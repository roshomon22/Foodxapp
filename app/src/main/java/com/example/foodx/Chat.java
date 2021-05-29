package com.example.foodx;

public class Chat {

    private  String sender;
    private String receiver;
    private  String message;

    private Chat (String sender,String receiver, String message)
    {
        this.sender=sender;
        this.receiver=receiver;
        this.message=message;

    }

    public Chat(){

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