package com.example.ltdd_finalproject.Model;

import com.google.gson.annotations.SerializedName;

import java.io.Serializable;

public class Xe implements Serializable {
    @SerializedName("id")
    private int id;
    @SerializedName("ten_xe")
    private String ten_xe;
    @SerializedName("gia")
    private int gia;
    @SerializedName("id_hang_xe")
    private int id_hang_xe;
    @SerializedName("id_danh_muc_xe")
    private int id_danh_muc_xe;
    @SerializedName("mota")
    private String mota;
    @SerializedName("mau")
    private String mau;
    @SerializedName("lien_ket_anh")
    private String lien_ket_anh;

    public Xe() {
    }

    public Xe(int id, String ten_xe, int gia, int id_hang_xe, int id_danh_muc_xe, String mota, String mau, String lien_ket_anh) {
        this.id = id;
        this.ten_xe = ten_xe;
        this.gia = gia;
        this.id_hang_xe = id_hang_xe;
        this.id_danh_muc_xe = id_danh_muc_xe;
        this.mota = mota;
        this.mau = mau;
        this.lien_ket_anh = lien_ket_anh;
    }

    public String getLien_ket_anh() {
        return lien_ket_anh;
    }

    public void setLien_ket_anh(String lien_ket_anh) {
        this.lien_ket_anh = lien_ket_anh;
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
