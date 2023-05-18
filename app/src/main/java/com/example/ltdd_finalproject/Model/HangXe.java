package com.example.ltdd_finalproject.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class HangXe implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("ten_hang_xe")
    private String ten_hang_xe;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen_hang_xe() {
        return ten_hang_xe;
    }

    public void setTen_hang_xe(String ten_hang_xe) {
        this.ten_hang_xe = ten_hang_xe;
    }

    public String getLogo() {
        return logo;
    }

    public void setLogo(String logo) {
        this.logo = logo;
    }

    public HangXe(int id, String ten_hang_xe, String logo) {
        this.id = id;
        this.ten_hang_xe = ten_hang_xe;
        this.logo = logo;
    }

    @SerializedName("logo")
    private String logo;
}
