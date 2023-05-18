package com.example.ltdd_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.ltdd_finalproject.Api.ApiService;
import com.example.ltdd_finalproject.Model.apiSignUp;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class SignupActivity extends AppCompatActivity {
    private LinearLayout layoutSignup;
    private EditText ho_ten, email, dia_chi, sdt, password;
    private TextView tvLogin;
    private Button btnSignup;



    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_signup);

        layoutSignup= findViewById(R.id.layout_singup);
        ho_ten= layoutSignup.findViewById(R.id.etHoTen);
        email= layoutSignup.findViewById(R.id.etEmail);
        dia_chi= layoutSignup.findViewById(R.id.etAddress);
        sdt= layoutSignup.findViewById(R.id.etPhone);
        password= layoutSignup.findViewById(R.id.etPassword);
        tvLogin= layoutSignup.findViewById(R.id.tv_login);
        btnSignup= layoutSignup.findViewById(R.id.btnSignup);

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent= new Intent(SignupActivity.this, MainActivity.class);
                startActivity(intent);
            }
        });

        btnSignup.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                sendSignupRequest();
            }
        });
    }
    private void sendSignupRequest(){
        String hotenData= ho_ten.getText().toString().trim();
        String emailData= email.getText().toString().trim();
        String diachiData= dia_chi.getText().toString().trim();
        String sdtData= sdt.getText().toString().trim();
        String matkhauData= password.getText().toString().trim();

        if(!hotenData.isEmpty()){
            if(!emailData.isEmpty()){
                if(!diachiData.isEmpty()){
                    if(!sdtData.isEmpty()){
                        if(matkhauData.isEmpty()){
                            ApiService.apiService.signUpRequest(hotenData, diachiData, sdtData, emailData, matkhauData).enqueue(new Callback<apiSignUp>() {
                                @Override
                                public void onResponse(Call<apiSignUp> call, Response<apiSignUp> response) {
                                    if(response.body()!=null && response.body().isSuccess()){
                                        Toast.makeText(SignupActivity.this, "Đăng kí thành công", Toast.LENGTH_SHORT).show();
                                        Intent intent= new Intent(SignupActivity.this, MainActivity.class);
                                        startActivity(intent);
                                    }
                                    else {
                                        Toast.makeText(SignupActivity.this, response.message(), Toast.LENGTH_SHORT).show();
                                    }
                                }
                                @Override
                                public void onFailure(Call<apiSignUp> call, Throwable t) {
                                    Toast.makeText(SignupActivity.this, "Call api error", Toast.LENGTH_SHORT).show();

                                }
                            });
                        }
                        else{
                            ho_ten.setError("Nhập họ mật khẩu");
                        }
                    }
                    else{
                        ho_ten.setError("Nhập họ số điện thoại");
                    }
                }
                else{
                    ho_ten.setError("Nhập họ địa chỉ");
                }
            }
            else{
                ho_ten.setError("Nhập email");
            }
        }
        else{
            ho_ten.setError("Nhập họ tên");
        }
    }
}