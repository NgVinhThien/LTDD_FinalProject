package com.example.ltdd_finalproject;

import android.content.Context;

public class DataLocalManager {
    private static final String PREF_FIRST_INSTALL= "PREF_FIRST_INSTALL";
    private static final String PREF_TOKEN= "PREF_TOKEN";
    private static final String PREF_IDKH= "PREF_IDKH";

    private static DataLocalManager instance;
    private MySharePreferences mySharePreferences;

    public static void init(Context context){
        instance= new DataLocalManager();
        instance.mySharePreferences= new MySharePreferences(context);

    }

    public static DataLocalManager getInstance(){
        if(instance== null){
            instance= new DataLocalManager();
        }
        return instance;
    }

    public static void setFirstInstall(boolean isFirst){
        DataLocalManager.getInstance().mySharePreferences.putBooleanValue(PREF_FIRST_INSTALL,isFirst);
    }
    public static boolean getFirstInstall(){
        return DataLocalManager.getInstance().mySharePreferences.getBooleanValue(PREF_FIRST_INSTALL);
    }
    public static void setToken(String token){
        DataLocalManager.getInstance().mySharePreferences.putStringValue(PREF_TOKEN, token);
    }
    public static String getToken(){
        return DataLocalManager.getInstance().mySharePreferences.getStringValue(PREF_TOKEN);
    }
    public static void setIdKH(int value){
        DataLocalManager.getInstance().mySharePreferences.putIntValue(PREF_IDKH, value);
    }
    public static int getIdKH(){
        return DataLocalManager.getInstance().mySharePreferences.getIntValue(PREF_TOKEN);
    }

}
