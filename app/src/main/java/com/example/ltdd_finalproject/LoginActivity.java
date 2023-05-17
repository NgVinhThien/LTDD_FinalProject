package com.example.ltdd_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import com.example.ltdd_finalproject.Api.ApiService;
import com.example.ltdd_finalproject.Model.Login;
import com.example.ltdd_finalproject.Model.Login_dl;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class LoginActivity extends AppCompatActivity {

    private Button btnLogin;
    private EditText edtEmail;
    private EditText edtPassword;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);

//        btnLogin.findViewById(R.id.btnLogin);
        btnLogin= findViewById(R.id.btnLogin);
        edtPassword= findViewById(R.id.etPass);
        edtEmail= findViewById(R.id.etText);


        btnLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String email= edtEmail.getText().toString();
                String pass= edtPassword.getText().toString();

                sendloginRequest(email, pass);
//                Intent intent= new Intent(LoginActivity.this, HomeActivity.class);
//                startActivity(intent);
            }
        });

    }

    private void sendloginRequest(String email, String pass){
//        LoginInfo loginInfo= new LoginInfo("thien1@gmail.com", "123");

        Log.e("nd", email);
        Log.e("nd", pass);
        ApiService.apiService.loginRequest(email, pass).enqueue(new Callback<Login>() {
            @Override
            public void onResponse(Call<Login> call, Response<Login> response) {
                Toast.makeText(LoginActivity.this, "Call api success", Toast.LENGTH_SHORT).show();

            }

            @Override
            public void onFailure(Call<Login> call, Throwable t) {
                Toast.makeText(LoginActivity.this, "Call api error", Toast.LENGTH_SHORT).show();

            }
        });
    }
}