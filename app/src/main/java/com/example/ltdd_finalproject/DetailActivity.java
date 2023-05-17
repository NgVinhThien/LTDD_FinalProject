package com.example.ltdd_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.bumptech.glide.Glide;
import com.example.ltdd_finalproject.Model.Xe;

public class DetailActivity extends AppCompatActivity {
    private TextView txtProductName;
    private ImageView imv_color;
    private TextView txtPrice;
    private TextView txtDescription;

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

        txtProductName.setText(xe.getTen_xe());
        Glide.with(this).load(xe.getMau()).into(imv_color);
        txtPrice.setText(String.valueOf(xe.getGia()));
        txtDescription.setText(xe.getMota());
    }
}