package com.example.ltdd_finalproject;

import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.ltdd_finalproject.Adapter.DanhMucAdapter;
import com.example.ltdd_finalproject.Adapter.HangXeAdapter;
import com.example.ltdd_finalproject.Adapter.PhotoAdapter;
import com.example.ltdd_finalproject.Adapter.XeAdapter;
import com.example.ltdd_finalproject.Api.ApiService;
import com.example.ltdd_finalproject.Model.DanhMuc;
import com.example.ltdd_finalproject.Model.HangXe;
import com.example.ltdd_finalproject.Model.Photo;
import com.example.ltdd_finalproject.Model.Xe;
import com.example.ltdd_finalproject.Model.apiXe;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;
import retrofit2.Call;
import retrofit2.Callback;
import retrofit2.Response;

public class CategoryFragment extends Fragment {
    private View mView;

    private RecyclerView rcvDanhMuc;
    private RecyclerView rcvHangXe;

    private DanhMucAdapter mDanhMucAdapter;
    private HangXeAdapter mHangXeAdapter;

    private List<DanhMuc> mListDanhMuc;
    private List<HangXe> mListHangXe;



    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.fragment_category, container, false);
        rcvDanhMuc =  mView.findViewById(R.id.rcv_category);
        callApiGetListDanhMuc();
        rcvHangXe = mView.findViewById(R.id.rcv_company);
        callApiGetListHangXe();
        return mView;
    }
    private void callApiGetListDanhMuc(){
        ApiService.apiService.getListDanhMuc().enqueue(new Callback<List<DanhMuc>>() {
            @Override
            public void onResponse(Call<List<DanhMuc>> call, Response<List<DanhMuc>> response) {
                if(response.isSuccessful()) {
                    mListDanhMuc = response.body();
                    mDanhMucAdapter = new DanhMucAdapter(requireContext(), mListDanhMuc);
                    rcvDanhMuc.setHasFixedSize(true);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
                    rcvDanhMuc.setLayoutManager(layoutManager);
                    rcvDanhMuc.setAdapter(mDanhMucAdapter);
                    mDanhMucAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<DanhMuc>> call, Throwable t) {
                Log.d("logg", t.getMessage());
            }
        });
    }
    private void callApiGetListHangXe(){
        ApiService.apiService.getListHangXe().enqueue(new Callback<List<HangXe>>() {
            @Override
            public void onResponse(Call<List<HangXe>> call, Response<List<HangXe>> response) {
                if(response.isSuccessful()) {
                    mListHangXe = response.body();
                    mHangXeAdapter = new HangXeAdapter(requireContext(), mListHangXe);
                    rcvHangXe.setHasFixedSize(true);
                    RecyclerView.LayoutManager layoutManager = new LinearLayoutManager(requireContext(), LinearLayoutManager.HORIZONTAL, false);
                    rcvHangXe.setLayoutManager(layoutManager);
                    rcvHangXe.setAdapter(mHangXeAdapter);
                    mHangXeAdapter.notifyDataSetChanged();
                }
            }

            @Override
            public void onFailure(Call<List<HangXe>> call, Throwable t) {
                Log.d("logg", t.getMessage());
            }
        });
    }
}
