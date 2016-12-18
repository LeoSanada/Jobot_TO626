package com.example.ryo.jobot_to626;

/**
 * Created by miumi on 12/9/2016.
 */

public class Users {
    String phone;
    String email;
    String briefinfo;
    String status;
    Integer havecalled;
    String contacts;

    public Users(){}

    public Users(String phone, String email, String briefinfo, String status, Integer havecalled, String contacts){
        this.phone = phone;
        this.email = email;
        this.briefinfo = briefinfo;
        this.status = status;
        this.havecalled = havecalled;
        this.contacts = contacts;
    }
}
