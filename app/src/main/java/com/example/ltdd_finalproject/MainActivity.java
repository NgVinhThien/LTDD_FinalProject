package com.example.ltdd_finalproject;

import androidx.appcompat.app.AppCompatActivity;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.View;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ltdd_finalproject.Adapter.PhotoAdapter;
import com.example.ltdd_finalproject.Api.ApiService;
import com.example.ltdd_finalproject.Model.Login;
import com.example.ltdd_finalproject.Model.Login_dl;
import com.example.ltdd_finalproject.Model.Photo;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
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
        ApiService.apiService.loginRequest("thien1@gmail.com", "123").enqueue(new Callback<Login_dl>() {
            @Override
            public void onResponse(Call<Login_dl> call, Response<Login_dl> response) {
                Toast.makeText(MainActivity.this, "Call api success", Toast.LENGTH_SHORT).show();

            }
            @Override
            public void onFailure(Call<Login_dl> call, Throwable t) {
                Toast.makeText(MainActivity.this, "Call api error", Toast.LENGTH_SHORT).show();
            }
        });
    }


}