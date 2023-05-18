package com.example.ltdd_finalproject;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager.widget.ViewPager;

import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.ltdd_finalproject.Adapter.PhotoAdapter;
import com.example.ltdd_finalproject.Adapter.ViewPagerAdapter;
import com.example.ltdd_finalproject.Model.Photo;
import com.google.android.material.bottomnavigation.BottomNavigationView;

import java.util.ArrayList;
import java.util.List;
import java.util.Timer;
import java.util.TimerTask;

import me.relex.circleindicator.CircleIndicator;

public class HomeActivity extends AppCompatActivity {
    private ViewPager mViewViewPager;
    private BottomNavigationView navigationView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_home);

        DataLocalManager.setFirstInstall(true);
        Anhxa();
        ViewPagerAdapter adapter= new ViewPagerAdapter(getSupportFragmentManager(), FragmentStatePagerAdapter.BEHAVIOR_RESUME_ONLY_CURRENT_FRAGMENT);
        mViewViewPager.setAdapter(adapter);
        mViewViewPager.addOnPageChangeListener(new ViewPager.OnPageChangeListener() {
            @Override
            public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

            }
            @Override
            public void onPageSelected(int position) {
                switch (position){
                    case 0:
                        navigationView.getMenu().findItem(R.id.action_home).setChecked(true);
                        break;
                    case 1:
                        navigationView.getMenu().findItem(R.id.action_category).setChecked(true);
                        break;
                    case 2:
                        navigationView.getMenu().findItem(R.id.action_bill).setChecked(true);
                        break;
                    case 3:
                        navigationView.getMenu().findItem(R.id.action_account).setChecked(true);
                        break;
                }
            }
            @Override
            public void onPageScrollStateChanged(int state) {

            }
        });
        navigationView.setOnNavigationItemSelectedListener(new BottomNavigationView.OnNavigationItemSelectedListener() {
            @Override
            public boolean onNavigationItemSelected(@NonNull MenuItem item) {
                switch (item.getItemId()){
                    case R.id.action_home:
                        mViewViewPager.setCurrentItem(0);
                        break;
                    case R.id.action_category:
                        mViewViewPager.setCurrentItem(1);
                        break;
                    case R.id.action_bill:
                        mViewViewPager.setCurrentItem(2);
                        break;
                    case R.id.action_account:
                        mViewViewPager.setCurrentItem(3);
                        break;
                }
                return true;
            }
        });
    }
    private void Anhxa(){
        mViewViewPager= findViewById(R.id.view_pager);
        navigationView= findViewById(R.id.bottom_nav);
    }
}