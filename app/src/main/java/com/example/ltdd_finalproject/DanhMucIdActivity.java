package com.example.ltdd_finalproject;

import android.os.Bundle;
import android.util.Log;

import androidx.appcompat.app.AppCompatActivity;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ltdd_finalproject.Adapter.DanhMucIdAdapter;
import com.example.ltdd_finalproject.Api.ApiService;
import com.example.ltdd_finalproject.Model.Xe;

import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DanhMucIdActivity extends AppCompatActivity {
    private RecyclerView recyclerView;
    private DanhMucIdAdapter danhMucIdAdapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_category);

        // Lấy id danh mục từ intent
        int danhMucId = getIntent().getIntExtra("id_danh_muc", -1);

        recyclerView = findViewById(R.id.rcv_category_1);
        danhMucIdAdapter = new DanhMucIdAdapter(this, null);
        recyclerView.setAdapter(danhMucIdAdapter);
        recyclerView.setLayoutManager(new LinearLayoutManager(this));

        // Gọi API theo id danh mục
        ApiService.apiService.getDanhMuc(danhMucId).enqueue(new Callback<List<Xe>>() {
            @Override
            public void onResponse(Call<List<Xe>> call, Response<List<Xe>> response) {
                if (response.isSuccessful()) {
                    List<Xe> listXe = response.body();
                    danhMucIdAdapter.setData(listXe);
                } else {
                    Log.d("DanhMucIdActivity", "API call failed");
                }
            }

            @Override
            public void onFailure(Call<List<Xe>> call, Throwable t) {
                Log.d("DanhMucIdActivity", "API call failed: " + t.getMessage());
            }
        });
    }
}
