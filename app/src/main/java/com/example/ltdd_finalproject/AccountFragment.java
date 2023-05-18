package com.example.ltdd_finalproject;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;

import com.example.ltdd_finalproject.Model.khach_hang;

public class AccountFragment extends Fragment {
    private View mView;
    private TextView tvHoTen, tvDiaChi, tvEmail, tvSdt;

    private Button btnLogout;
    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView = inflater.inflate(R.layout.fragment_account, container, false);

        tvHoTen= mView.findViewById(R.id.textViewName);
        tvDiaChi= mView.findViewById(R.id.textviewDiachi);
        tvSdt= mView.findViewById(R.id.textViewSDT);
        tvEmail= mView.findViewById(R.id.textViewEmail);
        btnLogout= mView.findViewById(R.id.btnLogout);

        tvHoTen.setText(DataLocalManager.getHoTen());
        tvDiaChi.setText(DataLocalManager.getDiaChi());
        tvSdt.setText(DataLocalManager.getSdt());
        tvEmail.setText(DataLocalManager.getEmail());

        btnLogout.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                DataLocalManager.setFirstInstall(false);
                DataLocalManager.setToken(" ");
                DataLocalManager.setIdKH(-1);
                DataLocalManager.setHoTen(" ");
                DataLocalManager.setSdt(" ");
                DataLocalManager.setEmail(" ");
                DataLocalManager.setDiaChi(" ");

                Intent intent= new Intent(requireContext(), MainActivity.class);
                startActivity(intent);
            }
        });

        return mView;



    }

}
