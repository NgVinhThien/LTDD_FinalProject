package com.example.ltdd_finalproject;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ltdd_finalproject.Adapter.HangXeIdAdapter;
import com.example.ltdd_finalproject.Api.ApiService;
import com.example.ltdd_finalproject.Model.Xe;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class HangXeIdActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private HangXeIdAdapter hangXeIdAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // Lấy id danh mục từ intent
        int hangxeID = getIntent().getIntExtra("id_hang_xe", -1);

        recyclerView = findViewById(R.id.rcv_category_1);
        hangXeIdAdapter = new HangXeIdAdapter(this, null);
        recyclerView.setAdapter(hangXeIdAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Gọi API theo id danh mục
        ApiService.apiService.getHangXe(hangxeID).enqueue(new Callback<List<Xe>>() {
            @Override
            public void onResponse(Call<List<Xe>> call, Response<List<Xe>> response) {
                if (response.isSuccessful()) {
                    List<Xe> listXe = response.body();
                    hangXeIdAdapter.setData(listXe);
                } else {
                    Log.d("HangXeIdActivity", "API call failed");
                }
            }

            @Override
            public void onFailure(Call<List<Xe>> call, Throwable t) {
                Log.d("HangXeIdActivity", "API call failed: " + t.getMessage());
            }
        });
    }
}
