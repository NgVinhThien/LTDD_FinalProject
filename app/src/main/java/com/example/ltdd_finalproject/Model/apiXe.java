package com.example.ltdd_finalproject.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

import kotlin.jvm.internal.SerializedIr;

public class apiXe {
    @SerializedName("xe")
    private List<Xe> xe;

    public apiXe() {
    }

    public apiXe(List<Xe> xe) {
        this.xe = xe;
    }

    public List<Xe> getXe() {
        return xe;
    }

    public void setXe(List<Xe> xe) {
        this.xe = xe;
    }
}
