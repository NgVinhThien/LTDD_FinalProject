package com.example.ltdd_finalproject.Api;


import com.example.ltdd_finalproject.Model.DanhMuc;
import com.example.ltdd_finalproject.Model.HangXe;
import com.example.ltdd_finalproject.Model.Login;
import com.example.ltdd_finalproject.Model.Xe;
import com.example.ltdd_finalproject.Model.apiHoadon;
import com.example.ltdd_finalproject.Model.apiSignUp;
import com.example.ltdd_finalproject.Model.apiXe;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.util.List;

import retrofit2.Call;
import retrofit2.Retrofit;
import retrofit2.converter.gson.GsonConverterFactory;
import retrofit2.http.Field;
import retrofit2.http.FormUrlEncoded;
import retrofit2.http.GET;
import retrofit2.http.Header;
import retrofit2.http.POST;
import retrofit2.http.Path;

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
    @FormUrlEncoded
    @POST("/signUp")
    Call<apiSignUp> signUpRequest(@Field("ho_ten") String ho_ten, @Field("dia_chi") String dia_chi, @Field("sdt") String sdt, @Field("email") String email, @Field("password") String password);

    @GET("/hoadon")
    Call<apiHoadon> getHoadon(@Header("authorization") String token);
    @GET("/hangxe")
    Call<List<HangXe>> getListHangXe();
    @GET("/danhmuc")
    Call<List<DanhMuc>> getListDanhMuc();

    @GET("danhmuc/{id}")
    Call<List<Xe>> getDanhMuc(@Path("id") int id);
}
