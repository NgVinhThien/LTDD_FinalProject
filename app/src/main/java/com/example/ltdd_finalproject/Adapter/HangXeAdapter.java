package com.example.ltdd_finalproject.Adapter;

import android.content.Context;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ltdd_finalproject.DanhMucIdActivity;
import com.example.ltdd_finalproject.HangXeIdActivity;
import com.example.ltdd_finalproject.Model.DanhMuc;
import com.example.ltdd_finalproject.Model.HangXe;
import com.example.ltdd_finalproject.R;

import java.util.List;

public class HangXeAdapter extends  RecyclerView.Adapter<HangXeAdapter.HangXeViewHolder> {
    private Context mContext;
    private List<HangXe> mListHangXe;

    public HangXeAdapter(Context context, List<HangXe> mListHangXe) {
        this.mContext = context;
        this.mListHangXe = mListHangXe;
    }

    public void setData(List<HangXe> list) {
        this.mListHangXe = list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public HangXeAdapter.HangXeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(parent.getContext()).inflate(R.layout.item_company, parent, false);
        return new HangXeAdapter.HangXeViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull HangXeAdapter.HangXeViewHolder holder, int position) {
        HangXe hangXe = mListHangXe.get(position);
        if (hangXe == null) {
            return;
        }
        holder.company_name.setText(hangXe.getTen_hang_xe());
        Glide.with(mContext).load(hangXe.getLogo()).into(holder.image_company);
        holder.itemView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Intent intent = new Intent(mContext, HangXeIdActivity.class);
                intent.putExtra("id_hang_xe", hangXe.getId());
                mContext.startActivity(intent);
            }
        });
    }

    @Override
    public int getItemCount() {
        if (mListHangXe != null) {
            return mListHangXe.size();
        }
        return 0;
    }

    public class HangXeViewHolder extends RecyclerView.ViewHolder {
        private ImageView image_company;
        private TextView company_name;

        public HangXeViewHolder(@NonNull View itemView) {
            super(itemView);
            image_company = itemView.findViewById(R.id.image_company);
            company_name = itemView.findViewById(R.id.company_name);
        }
    }
}
