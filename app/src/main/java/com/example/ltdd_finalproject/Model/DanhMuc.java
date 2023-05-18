package com.example.ltdd_finalproject.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class DanhMuc implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("ten_danh_muc")
    private String ten_danh_muc;

    public String getTen_danh_muc() {
        return ten_danh_muc;
    }

    public void setTen_danh_muc(String ten_danh_muc) {
        this.ten_danh_muc = ten_danh_muc;
    }

    public DanhMuc() {
    }

    public DanhMuc(int id, String ten_danh_muc, String anh_dai_dien) {
        this.id = id;
        this.ten_danh_muc = ten_danh_muc;
        this.anh_dai_dien = anh_dai_dien;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }


    public String getAnh_dai_dien() {
        return anh_dai_dien;
    }

    public void setAnh_dai_dien(String anh_dai_dien) {
        this.anh_dai_dien = anh_dai_dien;
    }

    @SerializedName("anh_dai_dien")
    private String anh_dai_dien;
}
