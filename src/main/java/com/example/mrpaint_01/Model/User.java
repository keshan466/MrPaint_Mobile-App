package com.example.mrpaint_01.Model;

import com.google.gson.annotations.Expose;
import com.google.gson.annotations.SerializedName;


public class User {
    @SerializedName("ID")
    @Expose
    
    private String ID;
    @SerializedName("UserName")
    @Expose
    private String UserName;
    @SerializedName("Password")
    @Expose
    private String Password;

    public String getID() {
        return ID;
    }

    public void setID(String ID) {
        this.ID = ID;
    }

    public String getUserName() {
        return UserName;
    }

    public void setUserName(String userName) {
        UserName = userName;
    }

    public String getPassword() {
        return Password;
    }

    public void setPassword(String password) {
        Password = password;
    }
}
