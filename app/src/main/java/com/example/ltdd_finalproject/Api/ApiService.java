package com.example.ltdd_finalproject.Api;


import com.example.ltdd_finalproject.Model.Login;
import com.example.ltdd_finalproject.Model.LoginInfo;
import com.example.ltdd_finalproject.Model.Login_dl;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.internal.GsonBuildConfig;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Body;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.POST;

public interface ApiService {
//    http://192.168.1.24:5000/danhmuc
    //http://verema.herokuapp.com/signinmb
    Gson gson= new GsonBuilder()
        .setDateFormat("yyyy-MM-dd HH:mm:ss")
        .create();
    ApiService apiService= new Retrofit.Builder()
            .baseUrl("http://verema.herokuapp.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);
    @FormUrlEncoded
    @POST("/signinmb")
    Call<Login_dl> loginRequest(@Field("userName") String userName, @Field("passWord") String passWord);

}
