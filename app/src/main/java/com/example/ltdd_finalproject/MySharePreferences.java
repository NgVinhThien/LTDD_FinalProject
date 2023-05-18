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

}
