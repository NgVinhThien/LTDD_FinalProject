package com.example.ltdd_finalproject;

import android.content.Context;
import android.content.SharedPreferences;

import com.example.ltdd_finalproject.Model.khach_hang;

public class MySharePreferences {

    private static final String MY_SHARED_PREFERENCE= "MY_SHARED_PREFERENCE";
    private static final String KEY_ID = "keyid";
    private static final String KEY_sdt = "keysdt";
    private static final String KEY_NAME = "keyname";
    private static final String KEY_EMAIL = "keyemail";
    private static final String KEY_DIACHI = "keydiachi";
    public static MySharePreferences mInstance;
    private Context mContext;
    public static synchronized MySharePreferences getInstance(Context context) {
        if (mInstance == null) {
            mInstance = new MySharePreferences(context);
        }
        return mInstance;
    }
    public void userLogin(khach_hang khachHang) {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = sharedPreferences.edit();
        editor.putString(KEY_NAME, khachHang.getHo_ten());
        editor.putString(KEY_sdt, khachHang.getSdt());
        editor.putString(KEY_EMAIL, khachHang.getEmail());
        editor.putString(KEY_DIACHI, khachHang.getDia_chi());
        editor.apply();
    }
    public khach_hang getUser() {
        SharedPreferences sharedPreferences = mContext.getSharedPreferences(MY_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        return new khach_hang(
                sharedPreferences.getInt(KEY_ID,-1),
                sharedPreferences.getString(KEY_NAME, null),
                sharedPreferences.getString(KEY_DIACHI, null),
                sharedPreferences.getString(KEY_sdt, null),
                sharedPreferences.getString(KEY_EMAIL, null)
        );
    }
    public MySharePreferences(Context mContext) {
        this.mContext = mContext;
    }

    public void putBooleanValue(String key, Boolean value){
        SharedPreferences sharedPreferences= mContext.getSharedPreferences(MY_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putBoolean(key, value);
        editor.apply();
    }

    public boolean getBooleanValue(String key){
        SharedPreferences sharedPreferences= mContext.getSharedPreferences(MY_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        return sharedPreferences.getBoolean(key, false);
    }

    public void putIntValue(String key, int value){
        SharedPreferences sharedPreferences= mContext.getSharedPreferences(MY_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putInt(key, value);
        editor.apply();
    }

    public int getIntValue(String key){
        SharedPreferences sharedPreferences= mContext.getSharedPreferences(MY_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        return sharedPreferences.getInt(key, -1);
    }

    public void putStringValue(String key, String value){
        SharedPreferences sharedPreferences= mContext.getSharedPreferences(MY_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        SharedPreferences.Editor editor= sharedPreferences.edit();
        editor.putString(key, value);
        editor.apply();
    }

    public String getStringValue(String key){
        SharedPreferences sharedPreferences= mContext.getSharedPreferences(MY_SHARED_PREFERENCE, Context.MODE_PRIVATE);
        return sharedPreferences.getString(key, " ");
    }

}
