package com.example.ltdd_finalproject.Model;

import java.util.ArrayList;

public class Login_dl {

    private boolean success;
    private String message;
    private String token;
    private ArrayList<User> user;

    public Login_dl() {
    }

    public Login_dl(boolean success, String message, String token, ArrayList<User> user) {
        this.success = success;
        this.message = message;
        this.token = token;
        this.user = user;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getMessage() {
        return message;
    }

    public void setMessage(String message) {
        this.message = message;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public ArrayList<User> getUser() {
        return user;
    }

    public void setUser(ArrayList<User> user) {
        this.user = user;
    }
}
