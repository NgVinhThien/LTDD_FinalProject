package com.example.ltdd_finalproject.Model;

import com.google.gson.annotations.SerializedName;

import java.sql.Date;

public class Hoadon {
    @SerializedName("id")
    private int id;
    @SerializedName("id_khach_hang")
    private int id_khach_hang;
    @SerializedName("id_xe")
    private int id_xe;
    @SerializedName("ngay_dat")
    private Date ngay_dat;
    @SerializedName("ngay_nhan")
    private Date ngay_nhan;

    public Hoadon() {
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

    public Date getNgay_dat() {
        return ngay_dat;
    }

    public void setNgay_dat(Date ngay_dat) {
        this.ngay_dat = ngay_dat;
    }

    public Date getNgay_nhan() {
        return ngay_nhan;
    }

    public void setNgay_nhan(Date ngay_nhan) {
        this.ngay_nhan = ngay_nhan;
    }

    public Hoadon(int id, int id_khach_hang, int id_xe, Date ngay_dat, Date ngay_nhan) {
        this.id = id;
        this.id_khach_hang = id_khach_hang;
        this.id_xe = id_xe;
        this.ngay_dat = ngay_dat;
        this.ngay_nhan = ngay_nhan;
    }

}
