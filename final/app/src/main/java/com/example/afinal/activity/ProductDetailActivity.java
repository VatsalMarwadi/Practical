package com.example.afinal.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.denzcoskun.imageslider.ImageSlider;
import com.example.afinal.Api.OrderApi;
import com.example.afinal.R;
import com.example.afinal.model.OrderModel;
import com.example.afinal.model.ProModel;
import com.example.afinal.utils.ConstantData;
import com.google.android.material.bottomsheet.BottomSheetDialog;

public class ProductDetailActivity extends AppCompatActivity {

    View layout;
    BottomSheetDialog dialog;
    TextView tvAddcart,back;
    Button btnClose;
    ImageView product_vegnon;
    TextView product_name,product_desc,product_price,product_discount,product_ingredient,product_flavour,product_category,product_sugerfree,product_bestseller;
    ImageSlider image_slider_product;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_product_detail);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ProModel model = (ProModel) getIntent().getSerializableExtra("food");
        layout = LayoutInflater.from(this).inflate(R.layout.raw_bottom_sheet,null);

        image_slider_product = findViewById(R.id.image_slider_product);
        product_vegnon = findViewById(R.id.product_vegnon);
        product_bestseller = findViewById(R.id.product_bestseller);
        product_name = findViewById(R.id.product_name);
        product_desc = findViewById(R.id.product_desc);
        product_price = findViewById(R.id.product_price);
        product_discount = findViewById(R.id.product_discount);
        product_ingredient = findViewById(R.id.product_ingredient);
        product_flavour = findViewById(R.id.product_flavour);
        product_category = findViewById(R.id.product_category);
        product_sugerfree = findViewById(R.id.product_sugerfree);

        tvAddcart = findViewById(R.id.tvAddcart);
        back = findViewById(R.id.back);
        btnClose = layout.findViewById(R.id.btnClose);

        if (model.getProduct_bestseller() == "on")
        {
            product_bestseller.setText("BestSellar");
        }
        product_name.setText(model.getProduct_name());
        product_desc.setText(model.getProduct_desc());
        product_price.setText(model.getProduct_price());
        product_discount.setText(model.getProduct_discount());
        product_ingredient.setText(model.getProduct_ingredient());
        product_flavour.setText(model.getProduct_flavour());
        product_category.setText(model.getProduct_category());
        product_sugerfree.setText(model.getProduct_sugerfree());

        SharedPreferences sp = getSharedPreferences(ConstantData.SP_NAME,MODE_PRIVATE);
        String uid = sp.getString(ConstantData.KEY_SP_USER_ID,"0");
        tvAddcart.setOnClickListener(v -> {

        if (uid.equals("0")){
            Intent intent=new Intent(this, LoginActivity.class);
            startActivity(intent);
            Toast.makeText(this, "Please login to continue....", Toast.LENGTH_SHORT).show();
        } else {
                OrderModel orderModel = new OrderModel();
                orderModel.setUid(uid);
                orderModel.setPid(model.getId());
                orderModel.setPname(model.getProduct_name());
                orderModel.setPic1(model.getProduct_pic1());
                orderModel.setQty(1);
                orderModel.setC_o("Cash");
                orderModel.setC_code("null");
                orderModel.setDate("date");
                orderModel.setTime("time");
                orderModel.setAddress("address");
                new OrderApi().addOrder(ProductDetailActivity.this,orderModel);
        }
        });

        back.setOnClickListener(v -> {
            finish();
        });

    }

}