package com.example.ltdd_finalproject.Model;

public class khach_hang {
    private int id;
    private String ho_ten;
    private String dia_chi;
    private String sdt;
    private String email;
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
