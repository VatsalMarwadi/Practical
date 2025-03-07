package com.example.afinal.activity;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.recyclerview.widget.LinearLayoutManager;
import androidx.recyclerview.widget.RecyclerView;

import com.example.afinal.Api.OrderApi;
import com.example.afinal.R;
import com.example.afinal.model.OrderModel;
import com.example.afinal.model.OrderOutputModel;
import com.example.afinal.utils.CartAdapter;
import com.example.afinal.utils.ConstantData;

public class CartActivity extends AppCompatActivity {

    RecyclerView rcylCart;
    TextView tvAmount,tvGst,tvDiscount,tvDelivery,tvTotal;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_cart);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        rcylCart = findViewById(R.id.rcylCart);

        tvAmount = findViewById(R.id.tvAmount);
        tvGst = findViewById(R.id.tvGst);
        tvDiscount = findViewById(R.id.tvDiscount);
        tvDelivery = findViewById(R.id.tvDelivery);
        tvTotal = findViewById(R.id.tvTotal);

        SharedPreferences sp = getSharedPreferences(ConstantData.SP_NAME,MODE_PRIVATE);
        String uid = sp.getString("uid","0");
        new OrderApi().getOrder(this,uid,"1");

    }

    public  void setRcylCart(OrderOutputModel model){
        double amt=0,tot=0,gst=0;
        for (int i=0;i<model.getOrder().size();i++){
            amt+=Double.parseDouble(model.getOrder().get(i).getTot_amount()+"");
            gst=(amt+0.05);
            tot=amt+gst;

            tvAmount.setText(amt+"");
            tvGst.setText(gst+"");
            tvTotal.setText(tot+"");

        }
        rcylCart.setLayoutManager(new LinearLayoutManager(this));
        CartAdapter adapter = new CartAdapter(this, model.getOrder(), new CartAdapter.onClickListener() {
            @Override
            public void onPlus(OrderModel orderModel) {

            }

            @Override
            public void onMinus(OrderModel orderModel) {

            }

            @Override
            public void onDelete(OrderModel orderModel) {

            }
        });
        rcylCart.setAdapter(adapter);
    }

}