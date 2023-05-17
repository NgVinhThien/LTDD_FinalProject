package com.example.ltdd_finalproject;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ltdd_finalproject.Api.ApiService;
import com.example.ltdd_finalproject.Model.Login;
import com.example.ltdd_finalproject.Model.Login_dl;

import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    Button btnLogin;
    LinearLayout linearlayout;
    TextView textSignup;

    View mview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin= findViewById(R.id.btnLogin);
        linearlayout= findViewById(R.id.linear_layout);
        textSignup= linearlayout.findViewById(R.id.textSignup);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendloginRequest();
                Toast.makeText(MainActivity.this, "Pressed Log in", Toast.LENGTH_SHORT).show();
                Intent intent= new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
        });
        textSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(MainActivity.this, SignupActivity.class);
                startActivity(intent);
            }
        });

    }
    private void sendloginRequest(){
//        LoginInfo loginInfo= new LoginInfo("thien1@gmail.com", "123");
        ApiService.apiService.loginRequest("thien1@gmail.com", "123").enqueue(new Callback<Login>() {
            @Override
            public void onResponse(retrofit2.Call<Login> call, Response<Login> response) {
                Toast.makeText(MainActivity.this, "Call api success", Toast.LENGTH_SHORT).show();
            }

            @Override
            public void onFailure(retrofit2.Call<Login> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Call api error", Toast.LENGTH_SHORT).show();
            }
        });
    }


}