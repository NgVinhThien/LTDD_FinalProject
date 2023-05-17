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
import androidx.cardview.widget.CardView;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.ltdd_finalproject.DetailActivity;
import com.example.ltdd_finalproject.Model.Xe;
import com.example.ltdd_finalproject.R;

import java.util.List;

public class XeAdapter extends RecyclerView.Adapter<XeAdapter.XeViewHolder> {

    private Context mcontext;
    private List<Xe> mListXe;

    public XeAdapter(Context mcontext, List<Xe> mListXe) {
        this.mcontext = mcontext;
        this.mListXe = mListXe;
    }

    public void setData(List<Xe> list){
        this.mListXe= list;
        notifyDataSetChanged();
    }

    @NonNull
    @Override
    public XeViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view= LayoutInflater.from(parent.getContext()).inflate(R.layout.item_xe, parent, false);
        return new XeViewHolder(view);
    }
    @Override
    public void onBindViewHolder(@NonNull XeViewHolder holder, int position) {
        Xe xe= mListXe.get(position);
        if(xe == null){
            return;
        }
//        holder.img_xe.setImageResource(xe.getResourceImg());
        holder.tv_name.setText(xe.getTen_xe());
        Glide.with(holder.itemView.getContext()).load(xe.getLien_ket_anh()).into(holder.img_xe);


        holder.cardView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                onClickGoToDetail(xe);
            }
        });
    }
    private void onClickGoToDetail(Xe xe){
        Intent intent= new Intent(mcontext, DetailActivity.class);
        Bundle bundle= new Bundle();
        bundle.putSerializable("object_xe", xe);
        intent.putExtras(bundle);
        mcontext.startActivity(intent);
    }

    public void release(){
        mcontext= null;
    }

    @Override
    public int getItemCount() {
        if(mListXe != null){
            return mListXe.size();
        }
        return 0;
    }

    public class XeViewHolder extends RecyclerView.ViewHolder{

        private CardView cardView;
        private ImageView img_xe;
        private TextView tv_name;

        public XeViewHolder(@NonNull View itemView) {
            super(itemView);
            cardView= itemView.findViewById(R.id.layout_item_xe);
            img_xe= itemView.findViewById(R.id.img_xe);
            tv_name= itemView.findViewById(R.id.tv_name);
        }
    }
}
