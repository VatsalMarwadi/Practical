package com.example.afinal.utils;

import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.afinal.R;
import com.example.afinal.model.CatModel;

import java.util.ArrayList;

public class CatAdapter extends RecyclerView.Adapter<CatAdapter.CatViewHolder> {

    ArrayList<CatModel> list;

    public CatAdapter(ArrayList<CatModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public CatViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.raw_category, parent, false);
        CatAdapter.CatViewHolder viewHolder = new CatAdapter.CatViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull CatViewHolder holder, int position) {
        CatModel model = list.get(position);
        holder.category_name.setText(model.getCategory_name());
        Glide.with(holder.category_pic.getContext()).load(ConstantData.SERVER_ADDRESS + model.getCategory_pic()).into(holder.category_pic);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class CatViewHolder extends RecyclerView.ViewHolder{

        ImageView category_pic;
        TextView category_name;
        public CatViewHolder(@NonNull View itemView) {
            super(itemView);

            category_name=itemView.findViewById(R.id.category_name);
            category_pic=itemView.findViewById(R.id.category_pic);
        }
    }
}
