package com.example.ltdd_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.bumptech.glide.Glide;
import com.example.ltdd_finalproject.Api.ApiService;
import com.example.ltdd_finalproject.Model.Xe;
import com.example.ltdd_finalproject.Model.apiThemHD;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class DetailActivity extends AppCompatActivity {
    private TextView txtProductName;
    private ImageView imv_color;
    private TextView txtPrice;
    private TextView txtDescription;

    private Button btnBuy;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle= getIntent().getExtras();
        if(bundle == null){
            return;
        }
        Xe xe= (Xe) bundle.get("object_xe");
        txtProductName= findViewById(R.id.txt_product_name);
        imv_color= findViewById(R.id.image_color);
        txtPrice= findViewById(R.id.txt_price);
        txtDescription= findViewById(R.id.txt_description);
        btnBuy=findViewById(R.id.btn_buy);

        txtProductName.setText(xe.getTen_xe());
        Glide.with(this).load(xe.getMau()).into(imv_color);
        txtPrice.setText(String.valueOf(xe.getGia()));
        txtDescription.setText(xe.getMota());

        btnBuy.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                String token= DataLocalManager.getToken();
                int id_xe= xe.getId();
                ApiService.apiService.addHD(token, id_xe, null, null).enqueue(new Callback<apiThemHD>() {
                    @Override
                    public void onResponse(Call<apiThemHD> call, Response<apiThemHD> response) {
                        Toast.makeText(DetailActivity.this, "Thêm thành công", Toast.LENGTH_SHORT).show();
                    }

                    @Override
                    public void onFailure(Call<apiThemHD> call, Throwable t) {
                        Toast.makeText(DetailActivity.this, "Thêm thất bại", Toast.LENGTH_SHORT).show();

                    }
                });
            }
        });
    }
}