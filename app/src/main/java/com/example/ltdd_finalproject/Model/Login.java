package com.example.ltdd_finalproject.Model;

import androidx.annotation.NonNull;

import java.util.List;

public class Login {
    private boolean success;
    private String token;
    List<khach_hang> khach_hangs;

    public Login() {
    }

    public Login(boolean success, String token, List<khach_hang> khach_hangs) {
        this.success = success;
        this.token = token;
        this.khach_hangs = khach_hangs;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public String getToken() {
        return token;
    }

    public void setToken(String token) {
        this.token = token;
    }

    public List<khach_hang> getKhach_hangs() {
        return khach_hangs;
    }

    public void setKhach_hangs(List<khach_hang> khach_hangs) {
        this.khach_hangs = khach_hangs;
    }

    @Override
    public String toString() {
        return "Login{" +
                "success=" + success +
                ", token='" + token + '\'' +
                ", khach_hangs=" + khach_hangs +
                '}';
    }
}
