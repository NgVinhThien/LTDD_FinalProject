package com.example.ltdd_finalproject.Adapter;

import androidx.annotation.NonNull;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentStatePagerAdapter;
import androidx.viewpager2.adapter.FragmentStateAdapter;

import com.example.ltdd_finalproject.AccountFragment;
import com.example.ltdd_finalproject.BillFragment;
import com.example.ltdd_finalproject.CategoryFragment;
import com.example.ltdd_finalproject.HomeFragment;

public class ViewPagerAdapter extends FragmentStatePagerAdapter {
    public ViewPagerAdapter(@NonNull FragmentManager fm, int behavior) {
        super(fm, behavior);
    }
    @NonNull
    @Override
    public Fragment getItem(int position) {
        switch (position){
            case 1:
                return new CategoryFragment();
            case 2:
                return new BillFragment();
            case 3:
                return new AccountFragment();
            case 0:
            default:
                return new HomeFragment();
        }
    }
    @Override
    public int getCount() {
        return 4;
    }

}
