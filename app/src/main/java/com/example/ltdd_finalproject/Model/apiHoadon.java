package com.example.ltdd_finalproject.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class apiHoadon {
    @SerializedName("data")
    private List<Hoadon> data;

    public apiHoadon() {
    }

    public apiHoadon(List<Hoadon> data) {
        this.data = data;
    }

    public List<Hoadon> getData() {
        return data;
    }

    public void setData(List<Hoadon> data) {
        this.data = data;
    }
}
