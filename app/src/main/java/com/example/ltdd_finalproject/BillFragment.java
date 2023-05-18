package com.example.ltdd_finalproject;

import android.os.Bundle;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ListView;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.DividerItemDecoration;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ltdd_finalproject.Adapter.HoadonAdapter;
import com.example.ltdd_finalproject.Api.ApiService;
import com.example.ltdd_finalproject.Model.Hoadon;
import com.example.ltdd_finalproject.Model.apiHoadon;

import java.util.ArrayList;
import java.util.List;

import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class BillFragment extends Fragment {
    private RecyclerView rcv_hoadon;
    private List<Hoadon> mListHoadon;
    private HoadonAdapter mhoadonAdapter;

    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        View view= inflater.inflate(R.layout.fragment_bill, container, false);

        rcv_hoadon= view.findViewById(R.id.bills_list);






        getHoadonRequest();

        return view;
    }
    private void getHoadonRequest(){


        String token= DataLocalManager.getToken();
        Log.e("token: ", token);
        ApiService.apiService.getHoadon(token).enqueue(new Callback<apiHoadon>() {
            @Override
            public void onResponse(Call<apiHoadon> call, Response<apiHoadon> response) {
                mListHoadon= new ArrayList<>();
                mListHoadon= response.body().getData();
                mhoadonAdapter= new HoadonAdapter(mListHoadon);
                LinearLayoutManager linearLayoutManager= new LinearLayoutManager(requireContext());
                rcv_hoadon.setLayoutManager(linearLayoutManager);

                DividerItemDecoration itemDecoration= new DividerItemDecoration(requireContext(), DividerItemDecoration.VERTICAL);
                rcv_hoadon.addItemDecoration(itemDecoration);



                rcv_hoadon.setAdapter(mhoadonAdapter);
            }
            @Override
            public void onFailure(Call<apiHoadon> call, Throwable t) {
                Toast.makeText(requireContext(), "Call api hoa don error", Toast.LENGTH_SHORT).show();

            }
        });
    }
}
