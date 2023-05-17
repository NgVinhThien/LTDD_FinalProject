package com.example.ltdd_finalproject.Adapter;

import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.example.ltdd_finalproject.Model.Xe;
import com.example.ltdd_finalproject.R;

import java.util.List;

public class XeAdapter extends RecyclerView.Adapter<XeAdapter.XeViewHolder> {

    private Context mcontext;
    private List<Xe> mListXe;

    public XeAdapter(Context mcontext) {
        this.mcontext = mcontext;
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
        holder.img_xe.setImageResource(xe.getResourceImg());
        holder.tv_name.setText(xe.getName());
    }

    @Override
    public int getItemCount() {
        if(mListXe != null){
            return mListXe.size();
        }
        return 0;
    }

    public class XeViewHolder extends RecyclerView.ViewHolder{

        private ImageView img_xe;
        private TextView tv_name;

        public XeViewHolder(@NonNull View itemView) {
            super(itemView);

            img_xe= itemView.findViewById(R.id.img_xe);
            tv_name= itemView.findViewById(R.id.tv_name);
        }
    }
}
