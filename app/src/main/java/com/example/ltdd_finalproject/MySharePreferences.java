package com.example.ltdd_finalproject;

import android.content.Context;
import android.content.SharedPreferences;

public class MySharePreferences {

    private static final String MY_SHARED_PREFERENCE= "MY_SHARED_PREFERENCE";
    private Context mContext;

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
