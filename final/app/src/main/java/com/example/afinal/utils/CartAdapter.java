package com.example.afinal.utils;



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
import com.example.afinal.R;
import com.example.afinal.model.OrderModel;

import java.util.List;

public class CartAdapter extends RecyclerView.Adapter<CartAdapter.CartViewHolder> {

    private Context context;
    private List<OrderModel> orderList;

    public onClickListener onClickListener;

    public CartAdapter(Context context, List<OrderModel> orderList,onClickListener onClickListener) {
        this.context = context;
        this.orderList = orderList;
        this.onClickListener=onClickListener;
    }

    @NonNull
    @Override
    public CartViewHolder onCreateViewHolder(@NonNull ViewGroup parent, int viewType) {
        View view = LayoutInflater.from(context).inflate(R.layout.item_cart, parent, false);
        return new CartViewHolder(view);
    }

    @Override
    public void onBindViewHolder(@NonNull CartViewHolder holder, int position) {
        OrderModel order = orderList.get(position);

        // Bind data to views
        holder.cartShoesName.setText(order.getPname());
        holder.cartShoesPrice.setText(String.valueOf(order.getTot_amount()));
        holder.cartShoesColor.setText(String.valueOf(order.getAmount()));
        holder.qty.setText(String.valueOf(order.getQty()));
        Glide.with(context).load(ConstantData.SERVER_ADDRESS+order.getPic1()).into(holder.cartImage);

        // Handle quantity increment
        holder.qtyAdd.setOnClickListener(v -> {
            int currentQty = order.getQty();
            currentQty++;
            order.setQty(currentQty);
            holder.qty.setText(String.valueOf(currentQty));
            updateTotalPrice(holder, order);
            onClickListener.onPlus(order);
        });

        // Handle quantity decrement
        holder.qtyLess.setOnClickListener(v -> {
            int currentQty = order.getQty();
            if (currentQty > 1) {
                currentQty--;
                order.setQty(currentQty);
                holder.qty.setText(String.valueOf(currentQty));
                updateTotalPrice(holder, order);
                onClickListener.onMinus(order);
            }
        });

        // Handle delete button
        holder.btnDeleteCart.setOnClickListener(v -> {
            orderList.remove(position);
            notifyItemRemoved(position);
            notifyItemRangeChanged(position, orderList.size());
            onClickListener.onDelete(order);
        });
    }

    @Override
    public int getItemCount() {
        return orderList.size();
    }

    // Helper method to update total price
    private void updateTotalPrice(CartViewHolder holder, OrderModel order) {
        int totalAmount = order.getAmount() * order.getQty();
        holder.tvTotal.setText(String.valueOf(totalAmount));
    }

    // ViewHolder class
    public static class CartViewHolder extends RecyclerView.ViewHolder {
        TextView cartShoesName, cartShoesPrice, qty, tvTotal,cartShoesColor;
        ImageView btnDeleteCart,cartImage;
        TextView qtyAdd, qtyLess;

        public CartViewHolder(@NonNull View itemView) {
            super(itemView);
            cartShoesName = itemView.findViewById(R.id.cartShoesName);
            cartImage = itemView.findViewById(R.id.cartImage);
            cartShoesPrice = itemView.findViewById(R.id.cartShoesPrice);
            cartShoesColor = itemView.findViewById(R.id.cartShoesColor);
            qty = itemView.findViewById(R.id.qty);
            tvTotal = itemView.findViewById(R.id.tvTotal);
            btnDeleteCart = itemView.findViewById(R.id.btnDeleteCart);
            qtyAdd = itemView.findViewById(R.id.qty_add);
            qtyLess = itemView.findViewById(R.id.qty_less);
        }
    }

    public  interface onClickListener{
            public void onPlus(OrderModel orderModel);
            public void onMinus(OrderModel orderModel);
            public void onDelete(OrderModel orderModel);
    }
}
