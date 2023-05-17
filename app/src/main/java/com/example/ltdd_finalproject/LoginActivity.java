package com.example.ltdd_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.ltdd_finalproject.Api.ApiService;
import com.example.ltdd_finalproject.Model.Login;
import com.example.ltdd_finalproject.Model.Login_dl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    Button btnLogin;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

        btnLogin.findViewById(R.id.btnLogin);

        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendloginRequest();
//                Intent intent= new Intent(LoginActivity.this, HomeActivity.class);
//                startActivity(intent);
            }
        });

    }

    private void sendloginRequest(){
//        LoginInfo loginInfo= new LoginInfo("thien1@gmail.com", "123");
        ApiService.apiService.loginRequest("admin", "123").enqueue(new Callback<Login_dl>() {
            @Override
            public void onResponse(Call<Login_dl> call, Response<Login_dl> response) {
                Toast.makeText(LoginActivity.this, "Call api success", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Login_dl> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Call api error", Toast.LENGTH_SHORT).show();

            }
        });
    }
}