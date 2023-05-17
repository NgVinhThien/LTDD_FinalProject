package com.example.ltdd_finalproject.Model;

import com.google.gson.annotations.SerializedName;

public class khach_hang {
    @SerializedName("id")
    private int id;
    @SerializedName("ho_ten")
    private String ho_ten;
    @SerializedName("dia_chi")
    private String dia_chi;
    @SerializedName("sdt")
    private String sdt;
    @SerializedName("email")
    private String email;
    @SerializedName("password")
    private String password;

    public khach_hang() {
    }

    public khach_hang(int id, String ho_ten, String dia_chi, String sdt, String email, String password) {
        this.id = id;
        this.ho_ten = ho_ten;
        this.dia_chi = dia_chi;
        this.sdt = sdt;
        this.email = email;
        this.password = password;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getHo_ten() {
        return ho_ten;
    }

    public void setHo_ten(String ho_ten) {
        this.ho_ten = ho_ten;
    }

    public String getDia_chi() {
        return dia_chi;
    }

    public void setDia_chi(String dia_chi) {
        this.dia_chi = dia_chi;
    }

    public String getSdt() {
        return sdt;
    }

    public void setSdt(String sdt) {
        this.sdt = sdt;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
