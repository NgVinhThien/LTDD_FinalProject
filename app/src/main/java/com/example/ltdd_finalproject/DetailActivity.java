package com.example.ltdd_finalproject;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.widget.TextView;

import com.example.ltdd_finalproject.Model.Xe;

public class DetailActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_details);

        Bundle bundle= getIntent().getExtras();
        if(bundle == null){
            return;
        }
        Xe xe= (Xe) bundle.get("object_xe");

        TextView txtProductName;
        txtProductName= findViewById(R.id.txt_product_name);
        txtProductName.setText(xe.getTen_xe());
    }
}