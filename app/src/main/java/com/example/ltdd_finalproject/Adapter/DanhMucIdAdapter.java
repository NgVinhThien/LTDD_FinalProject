package com.example.ltdd_finalproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ltdd_finalproject.DetailActivity;
import com.example.ltdd_finalproject.Model.Xe;
import com.example.ltdd_finalproject.R;

import java.util.List;

public class DanhMucIdAdapter extends RecyclerView.Adapter<DanhMucIdAdapter.DanhMucIdViewHolder> {
    private Context mContext;
    private List<Xe> mListXe;

    public DanhMucIdAdapter(Context context, List<Xe> listXe) {
        this.mContext = context;
        this.mListXe = listXe;
    }

    public void setData(List<Xe> list) {
        this.mListXe = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DanhMucIdViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_xe, parent, false);
        return new DanhMucIdViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhMucIdViewHolder holder, int position) {
        Xe xe = mListXe.get(position);
        if (xe == null) {
            return;
        }
        holder.tvTenXe.setText(xe.getTen_xe());
        Glide.with(holder.itemView.getContext()).load(xe.getLien_ket_anh()).into(holder.imgXe);

        holder.imgXe.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(xe);
            }
        });
    }
    private void onClickGoToDetail(Xe xe){
        Intent intent= new Intent(mContext, DetailActivity.class);
        Bundle bundle= new Bundle();
        bundle.putSerializable("object_xe", xe);
        intent.putExtras(bundle);
        mContext.startActivity(intent);
    }
    @Override
    public int getItemCount() {
        if (mListXe != null) {
            return mListXe.size();
        }
        return 0;
    }

    public class DanhMucIdViewHolder extends RecyclerView.ViewHolder {
        private ImageView imgXe;
        private TextView tvTenXe;

        public DanhMucIdViewHolder(@NonNull View itemView) {
            super(itemView);
            imgXe = itemView.findViewById(R.id.img_xe);
            tvTenXe = itemView.findViewById(R.id.tv_name);
        }
    }
}
