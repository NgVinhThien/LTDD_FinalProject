package com.example.ltdd_finalproject.Adapter;


import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ltdd_finalproject.Model.Hoadon;
import com.example.ltdd_finalproject.Model.Xe;
import com.example.ltdd_finalproject.Model.apiHoadon;
import com.example.ltdd_finalproject.R;

import java.util.List;

public class HoadonAdapter extends RecyclerView.Adapter<HoadonAdapter.HoadonViewHolder>{

    private List<Hoadon> mListHoadon;
    private Context mContext;

    public HoadonAdapter(List<Hoadon> mListHoadon, Context mContext) {
        this.mListHoadon = mListHoadon;
        this.mContext = mContext;
    }

    @NonNull
    @Override
    public HoadonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hoadon, parent, false);
        return new HoadonViewHolder(view);
    }
    public void setData(List<Hoadon> list){
        this.mListHoadon= list;
        notifyDataSetChanged();
    }

    @Override
    public void onBindViewHolder(@NonNull HoadonViewHolder holder, int position) {
        Hoadon hoadon= mListHoadon.get(position);
        if(hoadon == null){
            return;
        }
        holder.tvTenXe.setText(String.valueOf(hoadon.getId_xe()));
        holder.tvNgayNhan.setText(String.valueOf(hoadon.getNgay_nhan()));

    }
    @Override
    public int getItemCount() {
        if(mListHoadon != null){
            return mListHoadon.size();
        }
        return 0;
    }

    public class HoadonViewHolder extends RecyclerView.ViewHolder{

        private TextView tvTenXe;
        private TextView tvNgayNhan;

        public HoadonViewHolder(@NonNull View itemView) {
            super(itemView);
            tvTenXe=  itemView.findViewById(R.id.tv_tenxe);
            tvNgayNhan= itemView.findViewById(R.id.tv_ngaynhan);


        }
    }


}
