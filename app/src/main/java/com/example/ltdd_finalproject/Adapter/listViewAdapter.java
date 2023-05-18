package com.example.ltdd_finalproject.Adapter;

import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.TextView;

import com.example.ltdd_finalproject.Model.Hoadon;
import com.example.ltdd_finalproject.R;

import java.util.List;

public class listViewAdapter extends BaseAdapter {
    private List<Hoadon> listHoadon;

    public listViewAdapter(List<Hoadon> listHoadon) {
        this.listHoadon = listHoadon;
    }

    @Override
    public int getCount() {
        return listHoadon.size();
    }

    @Override
    public Object getItem(int i) {
        return listHoadon.get(i);
    }

    @Override
    public long getItemId(int i) {
        return listHoadon.get(i).getId();
    }

    @Override
    public View getView(int i, View view, ViewGroup viewGroup) {
        View viewHoadon;
        if(view ==null){
            viewHoadon= View.inflate(viewGroup.getContext(), R.layout.item_hoadon, null);

        }else viewHoadon= view;
        Hoadon hoadon= (Hoadon) getItem(i);
        ((TextView)viewHoadon.findViewById(R.id.tv_tenxe)).setText(String.valueOf(hoadon.getId()));
        ((TextView)viewHoadon.findViewById(R.id.tv_ngaynhan)).setText(String.valueOf(hoadon.getNgay_nhan()));
        return viewHoadon;
    }
}
