package com.example.ltdd_finalproject.Api;


import com.example.ltdd_finalproject.Model.Login;
import com.example.ltdd_finalproject.Model.apiXe;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.POST;

public interface ApiService {
    //https://api-xe.onrender.com/xe/all
    Gson gson= new GsonBuilder()
        .setDateFormat("yyyy-MM-dd HH:mm:ss")
        .create();
    ApiService apiService= new Retrofit.Builder()
            .baseUrl("https://api-xe.onrender.com")
            .addConverterFactory(GsonConverterFactory.create(gson))
            .build()
            .create(ApiService.class);
    @FormUrlEncoded
    @POST("/signIn")
    Call<Login> loginRequest(@Field("email") String email, @Field("password") String password);
    @GET("/xe/all")
    Call<apiXe> getListXe();
}
