package com.example.ltdd_finalproject.Model;

import com.google.gson.annotations.SerializedName;

import java.util.List;

public class apiHoadon {
    @SerializedName("success")
    private boolean success;
    @SerializedName("hoa_don")
    private List<Hoadon> hoa_don;

    public apiHoadon() {
    }

    public apiHoadon(boolean success, List<Hoadon> hoa_don) {
        this.success = success;
        this.hoa_don = hoa_don;
    }

    public boolean isSuccess() {
        return success;
    }

    public void setSuccess(boolean success) {
        this.success = success;
    }

    public List<Hoadon> getHoa_don() {
        return hoa_don;
    }

    public void setHoa_don(List<Hoadon> hoa_don) {
        this.hoa_don = hoa_don;
    }
}
