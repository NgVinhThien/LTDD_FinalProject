package com.example.ltdd_finalproject.Model;

import com.google.gson.annotations.SerializedName;

import java.security.Timestamp;
import java.sql.Date;
import java.time.format.DateTimeFormatter;

public class Hoadon {
    @SerializedName("id")
    private int id;
    @SerializedName("id_khach_hang")
    private int id_khach_hang;
    @SerializedName("id_xe")
    private int id_xe;
    @SerializedName("ngay_dat")
    private String ngay_dat;
    @SerializedName("ngay_nhan")
    private String ngay_nhan;

    public Hoadon() {
    }

    public Hoadon(int id, int id_khach_hang, int id_xe, String ngay_dat, String ngay_nhan) {
        this.id = id;
        this.id_khach_hang = id_khach_hang;
        this.id_xe = id_xe;
        this.ngay_dat = ngay_dat;
        this.ngay_nhan = ngay_nhan;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getId_khach_hang() {
        return id_khach_hang;
    }

    public void setId_khach_hang(int id_khach_hang) {
        this.id_khach_hang = id_khach_hang;
    }

    public int getId_xe() {
        return id_xe;
    }

    public void setId_xe(int id_xe) {
        this.id_xe = id_xe;
    }

    public String getNgay_dat() {
        return ngay_dat;
    }

    public void setNgay_dat(String ngay_dat) {
        this.ngay_dat = ngay_dat;
    }

    public String getNgay_nhan() {
        return ngay_nhan;
    }

    public void setNgay_nhan(String ngay_nhan) {
        this.ngay_nhan = ngay_nhan;
    }
}
