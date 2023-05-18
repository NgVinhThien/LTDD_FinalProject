package com.example.ltdd_finalproject.Adapter;


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

public class HoadonAdapter  extends RecyclerView.Adapter<HoadonAdapter.HoadonViewHolder>{

    private List<Hoadon> mListHoadon;

    public HoadonAdapter(List<Hoadon> mListHoadon) {
        this.mListHoadon = mListHoadon;
    }


    @NonNull
    @Override
    public HoadonViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_hoadon, parent, false);
        return new HoadonViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HoadonViewHolder holder, int position) {
        Hoadon hoadon= mListHoadon.get(position);
        if(hoadon== null){
            return;
        }
        holder.tv_tenxe.setText(String.valueOf(hoadon.getId()));
        holder.tv_ngaynhan.setText(String.valueOf(hoadon.getNgay_dat()));

    }

    @Override
    public int getItemCount() {
        if(mListHoadon!= null){
            return mListHoadon.size();
        }
        return 0;
    }





    public class HoadonViewHolder extends RecyclerView.ViewHolder{
        private LinearLayout layout_hodon;
        private ImageView imv_hoadon;
        private TextView tv_tenxe;
        private TextView tv_ngaynhan;

        public HoadonViewHolder(@NonNull View itemView) {
            super(itemView);

            layout_hodon= itemView.findViewById(R.id.layout_hoadon);
            imv_hoadon= layout_hodon.findViewById(R.id.imv_hoadon);
            tv_tenxe= layout_hodon.findViewById(R.id.tv_tenxe);
            tv_ngaynhan= layout_hodon.findViewById(R.id.tv_ngaynhan);
        }
    }
}
