package com.example.afinal.utils;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import androidx.annotation.NonNull;
import androidx.recyclerview.widget.RecyclerView;

import com.bumptech.glide.Glide;
import com.example.afinal.R;
import com.example.afinal.activity.ProductDetailActivity;
import com.example.afinal.model.CatModel;
import com.example.afinal.model.ProModel;

import java.util.ArrayList;

public class ProAdapter extends RecyclerView.Adapter<ProAdapter.ProViewHolder> {

    ArrayList<ProModel> list;

    public ProAdapter(ArrayList<ProModel> list) {
        this.list = list;
    }

    @NonNull
    @Override
    public ProAdapter.ProViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        LayoutInflater layoutInflater = LayoutInflater.from(parent.getContext());
        View listItem = layoutInflater.inflate(R.layout.raw_product, parent, false);
        ProAdapter.ProViewHolder viewHolder = new ProAdapter.ProViewHolder(listItem);
        return viewHolder;
    }

    @Override
    public void onBindViewHolder(@NonNull ProAdapter.ProViewHolder holder, int position) {

        ProModel model = list.get(position);
        holder.product_name.setText(model.getProduct_name());
        holder.product_discount.setText(model.getProduct_discount());
        holder.product_price.setText(model.getProduct_price());
        holder.product_pic1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Intent intent=new Intent(holder.product_pic1.getContext(), ProductDetailActivity.class);
                intent.putExtra("food",model);
                holder.product_name.getContext().startActivity(intent);
            }
        });
        Glide.with(holder.product_pic1.getContext()).load(ConstantData.SERVER_ADDRESS + model.getProduct_pic1()).into(holder.product_pic1);
        Glide.with(holder.product_vegnon.getContext()).load(ConstantData.SERVER_ADDRESS + model.getProduct_vegnon()).into(holder.product_vegnon);
    }

    @Override
    public int getItemCount() {
        return list.size();
    }

    public class ProViewHolder extends RecyclerView.ViewHolder {

        ImageView product_pic1,product_vegnon;
        TextView product_name,product_discount,product_price;

        @SuppressLint("WrongViewCast")
        public ProViewHolder(@NonNull View itemView) {
            super(itemView);

            product_pic1 = itemView.findViewById(R.id.product_pic1);
            product_vegnon = itemView.findViewById(R.id.product_vegnon);
            product_name = itemView.findViewById(R.id.product_name);
            product_discount = itemView.findViewById(R.id.product_discount);
            product_price = itemView.findViewById(R.id.product_price);

        }
    }
}
