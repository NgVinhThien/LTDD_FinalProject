package com.example.ltdd_finalproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ltdd_finalproject.Model.DanhMuc;
import com.example.ltdd_finalproject.R;

import java.util.List;

public class DanhMucAdapter extends RecyclerView.Adapter<DanhMucAdapter.DanhmucViewHolder> {
    private Context mContext;
    private List<DanhMuc> mListDanhMuc;

    public DanhMucAdapter(Context context, List<DanhMuc> listDanhMuc) {
        this.mContext = context;
        this.mListDanhMuc = listDanhMuc;
    }

    public void setData(List<DanhMuc> list) {
        this.mListDanhMuc = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public DanhmucViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_category, parent, false);
        return new DanhmucViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull DanhmucViewHolder holder, int position) {
        DanhMuc danhMuc = mListDanhMuc.get(position);
        if (danhMuc == null) {
            return;
        }
        holder.tv_name_category.setText(danhMuc.getTen_danh_muc());
        Glide.with(mContext).load(danhMuc.getAnh_dai_dien()).into(holder.img_category);
    }

    @Override
    public int getItemCount() {
        if (mListDanhMuc != null) {
            return mListDanhMuc.size();
        }
        return 0;
    }

    public class DanhmucViewHolder extends RecyclerView.ViewHolder {
        private ImageView img_category;
        private TextView tv_name_category;

        public DanhmucViewHolder(@NonNull View itemView) {
            super(itemView);
            img_category = itemView.findViewById(R.id.image_category);
            tv_name_category = itemView.findViewById(R.id.category_name);
        }
    }
}
