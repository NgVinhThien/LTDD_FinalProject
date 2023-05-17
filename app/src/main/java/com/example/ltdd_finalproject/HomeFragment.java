package com.example.ltdd_finalproject;
import android.content.Context;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.fragment.app.Fragment;
import androidx.recyclerview.widget.GridLayoutManager;
import androidx.recyclerview.widget.RecyclerView;
import androidx.viewpager.widget.ViewPager;

import com.example.ltdd_finalproject.Adapter.PhotoAdapter;
import com.example.ltdd_finalproject.Adapter.XeAdapter;
import com.example.ltdd_finalproject.Model.Photo;
import com.example.ltdd_finalproject.Model.Xe;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomeFragment extends Fragment {

    private View mView;

    private ViewPager viewPager;

    private CircleIndicator circleIndicator;
    private PhotoAdapter photoAdapter;
    private List<Photo> mListPhoto;
    private Timer mTimer;

    private RecyclerView rcvXe;
    private XeAdapter mXeAdapter;


    @Nullable
    @Override
    public View onCreateView(@NonNull LayoutInflater inflater, @Nullable ViewGroup container, @Nullable Bundle savedInstanceState) {
        mView= inflater.inflate(R.layout.fragment_home, container, false);
        viewPager= mView.findViewById(R.id.viewpager);
        circleIndicator= mView.findViewById(R.id.cicle_indicator);

        mListPhoto= getListPhoto();
        Context context= getContext();
        photoAdapter= new PhotoAdapter(context, mListPhoto);
        viewPager.setAdapter(photoAdapter);
        circleIndicator.setViewPager(viewPager);
        photoAdapter.registerDataSetObserver(circleIndicator.getDataSetObserver());
        autoSlideImage();

        rcvXe= mView.findViewById(R.id.rcv_xe);
        mXeAdapter= new XeAdapter(requireContext());

        GridLayoutManager gridLayoutManager= new GridLayoutManager(requireContext(), 3);
        rcvXe.setLayoutManager(gridLayoutManager);

        mXeAdapter.setData(getListUser());
        rcvXe.setAdapter(mXeAdapter);




        return mView;
    }

    private List<Xe> getListUser() {
        List<Xe> list= new ArrayList<>();
        list.add(new Xe(R.drawable.image1, "Xe 01"));
        list.add(new Xe(R.drawable.image2, "Xe 02"));
        list.add(new Xe(R.drawable.image3, "Xe 03"));
        list.add(new Xe(R.drawable.image1, "Xe 04"));
        list.add(new Xe(R.drawable.image2, "Xe 05"));
        list.add(new Xe(R.drawable.image3, "Xe 06"));
        list.add(new Xe(R.drawable.image3, "Xe 07"));
        list.add(new Xe(R.drawable.image2, "Xe 08"));
        list.add(new Xe(R.drawable.image1, "Xe 09"));
        list.add(new Xe(R.drawable.image3, "Xe 10"));
        list.add(new Xe(R.drawable.image2, "Xe 11"));
        list.add(new Xe(R.drawable.image2, "Xe 12"));

        return list;
    }

    private List<Photo> getListPhoto(){
        List<Photo> list= new ArrayList<>();
        list.add(new Photo(R.drawable.image1));
        list.add(new Photo(R.drawable.image2));
        list.add(new Photo(R.drawable.image3));
        list.add(new Photo(R.drawable.image4));

        return list;
    }
    private void autoSlideImage(){
        if(mListPhoto== null || mListPhoto.isEmpty() || viewPager== null){
            return;
        }
        // Khoi tao timer
        if(mTimer == null){
            mTimer = new Timer();
        }
        mTimer.schedule(new TimerTask() {
            @Override
            public void run() {
                new Handler(Looper.getMainLooper()).post(new Runnable() {
                    @Override
                    public void run() {
                        int currentItem= viewPager.getCurrentItem();
                        int totalItem= mListPhoto.size()-1;
                        if(currentItem < totalItem){
                            currentItem++;
                            viewPager.setCurrentItem(currentItem);
                        }
                        else{
                            viewPager.setCurrentItem(0);
                        }
                    }
                });
            }
        }, 9000, 6000);
    }
    @Override
    public void onDestroy() {
        super.onDestroy();
        if(mTimer != null){
            mTimer.cancel();
            mTimer= null;
        }
    }

}
