package com.example.practise.utils;

import android.annotation.SuppressLint;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.practise.R;

import java.util.ArrayList;

public class ProAdapter extends RecyclerView.Adapter<ProAdapter.ProViewHolder> {

    ArrayList<ProModel> list;

    public ProAdapter(ArrayList<ProModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ProViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.raw_product, parent, false);
        ProAdapter.ProViewHolder viewHolder = new ProAdapter.ProViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProViewHolder holder, int position) {

        ProModel model = list.get(position);
        holder.product_name.setText(model.product_name);
        holder.product_discount.setText(model.product_discount);
        holder.product_price.setText(model.product_price);
        holder.product_category.setText(model.product_category);
        Glide.with(holder.product_pic1.getContext()).load(model.getProduct_pic1()).into(holder.product_pic1);

    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ProViewHolder extends RecyclerView.ViewHolder {

        ImageView product_pic1;
        TextView product_name,product_discount,product_price,product_category;

        @SuppressLint("WrongViewCast")
        public ProViewHolder(@NonNull View itemView) {
            super(itemView);

            product_pic1 = itemView.findViewById(R.id.product_pic1);
            product_name = itemView.findViewById(R.id.product_name);
            product_category = itemView.findViewById(R.id.product_category);
            product_discount = itemView.findViewById(R.id.product_discount);
            product_price = itemView.findViewById(R.id.product_price);

        }
    }
}
