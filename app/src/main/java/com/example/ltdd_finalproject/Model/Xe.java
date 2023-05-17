package com.example.ltdd_finalproject.Model;

import java.io.Serializable;

public class Xe implements Serializable {

    private int id;
    private String ten_xe;
    private int gia;
    private int id_hang_xe;
    private int id_danh_muc_xe;
    private String mota;
    private String mau;

    public Xe() {
    }

    public Xe(int id, String ten_xe, int gia, int id_hang_xe, int id_danh_muc_xe, String mota, String mau) {
        this.id = id;
        this.ten_xe = ten_xe;
        this.gia = gia;
        this.id_hang_xe = id_hang_xe;
        this.id_danh_muc_xe = id_danh_muc_xe;
        this.mota = mota;
        this.mau = mau;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTen_xe() {
        return ten_xe;
    }

    public void setTen_xe(String ten_xe) {
        this.ten_xe = ten_xe;
    }

    public int getGia() {
        return gia;
    }

    public void setGia(int gia) {
        this.gia = gia;
    }

    public int getId_hang_xe() {
        return id_hang_xe;
    }

    public void setId_hang_xe(int id_hang_xe) {
        this.id_hang_xe = id_hang_xe;
    }

    public int getId_danh_muc_xe() {
        return id_danh_muc_xe;
    }

    public void setId_danh_muc_xe(int id_danh_muc_xe) {
        this.id_danh_muc_xe = id_danh_muc_xe;
    }

    public String getMota() {
        return mota;
    }

    public void setMota(String mota) {
        this.mota = mota;
    }

    public String getMau() {
        return mau;
    }

    public void setMau(String mau) {
        this.mau = mau;
    }
}
