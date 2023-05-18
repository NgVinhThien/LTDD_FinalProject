package com.example.ltdd_finalproject;

import android.content.DialogInterface;
import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import androidx.appcompat.app.AppCompatActivity;

import com.example.ltdd_finalproject.Api.ApiService;
import com.example.ltdd_finalproject.Model.Login;
import com.example.ltdd_finalproject.Model.khach_hang;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class MainActivity extends AppCompatActivity {

    private Button btnLogin;
    private LinearLayout linearlayout;
    private TextView textSignup;
    private EditText edtEmail;
    private EditText edtPassword;

    View mview;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

            if(!DataLocalManager.getFirstInstall()){
                btnLogin= findViewById(R.id.btnLogin);
                linearlayout= findViewById(R.id.linear_layout);
                textSignup= linearlayout.findViewById(R.id.textSignup);
                edtPassword= findViewById(R.id.etPass);
                edtEmail= findViewById(R.id.etText);
                btnLogin.setOnClickListener(new View.OnClickListener() {
                    @Override
                    public void onClick(View view) {
                        Toast.makeText(MainActivity.this, "Pressed Log in", Toast.LENGTH_SHORT).show();
                        sendloginRequest();
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
            else{
                Intent intent= new Intent(MainActivity.this, HomeActivity.class);
                startActivity(intent);
            }
    }
    private void sendloginRequest(){
        String email= edtEmail.getText().toString().trim();
        String pass= edtPassword.getText().toString().trim();
        if(!email.isEmpty()){

            if(!pass.isEmpty()){
                ApiService.apiService.loginRequest(email, pass).enqueue(new Callback<Login>() {
                    @Override
                    public void onResponse(Call<Login> call, Response<Login> response) {
                        if(response.body()!= null && response.body().isSuccess()){
                            DataLocalManager.setToken(response.body().getToken());
                            List<khach_hang> listKH= new ArrayList<>();
                            listKH= response.body().getKhach_hangs();
                            DataLocalManager.setIdKH(listKH.get(0).getId());
                            Intent intent= new Intent(MainActivity.this, HomeActivity.class);
                            startActivity(intent);
                        }
                        else{
                            Toast.makeText(MainActivity.this, "Đăng nhập không thành công!", Toast.LENGTH_SHORT).show();
                        }
                    }
                    @Override
                    public void onFailure(Call<Login> call, Throwable t) {
                        Toast.makeText(MainActivity.this, "Call api error", Toast.LENGTH_SHORT).show();
                    }
                });

            }else {
                edtPassword.setError("Vui lòng nhập mật khẩu");
            }
        }
        else{
            edtEmail.setError("Vui lòng nhập email");
        }


    }


}