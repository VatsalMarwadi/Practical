package com.example.afinal.activity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.ImageView;

import androidx.activity.EdgeToEdge;
import androidx.annotation.NonNull;
import androidx.annotation.Nullable;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.fragment.app.Fragment;
import androidx.fragment.app.FragmentManager;
import androidx.fragment.app.FragmentTransaction;

import com.example.afinal.Api.Data_Api;
import com.example.afinal.fragment.CartFragment;
import com.example.afinal.fragment.HomeFragment;
import com.example.afinal.fragment.ProfileFragment;
import com.example.afinal.R;
import com.example.afinal.fragment.SearchFragment;
import com.example.afinal.model.BannerModel;
import com.example.afinal.model.CatModel;
import com.example.afinal.model.CoupenModel;
import com.example.afinal.model.DataOutputModel;
import com.example.afinal.model.PincodeModel;
import com.example.afinal.model.ProModel;
import com.example.afinal.model.StoreModel;
import com.example.afinal.model.ToppingModel;

import java.util.ArrayList;

import nl.joery.animatedbottombar.AnimatedBottomBar;


public class MainActivity extends AppCompatActivity {

    ImageView ivCart;

    private static final int id_home = 1;
    private static final int id_search = 2;
    private static final int id_cart = 3;
    private static final int id_profile=4;

    public ArrayList<BannerModel> banner;
    public ArrayList<CoupenModel> coupen;
    public ArrayList<CatModel> category;
    public ArrayList<ProModel> product;
    public ArrayList<ToppingModel> topping;
    public ArrayList<PincodeModel> pincode;
    public ArrayList<StoreModel> store;


    AnimatedBottomBar animatedBottomBar;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_main);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        ivCart = findViewById(R.id.ivCart);

        Intent intent = getIntent();

        ivCart.setOnClickListener(v -> {
            Intent i1 = new Intent(this, CartActivity.class);
            startActivity(i1);
        });

        animatedBottomBar=findViewById(R.id.bottom_bar);
        new Data_Api().getData(this);


        animatedBottomBar.setOnTabInterceptListener(new AnimatedBottomBar.OnTabInterceptListener() {
            @Override
            public boolean onTabIntercepted(int i, @Nullable AnimatedBottomBar.Tab tab, int i1, @NonNull AnimatedBottomBar.Tab tab1) {

                if(tab1.getId()==R.id.tab_home){
                    loadFragment(new HomeFragment(banner,category,product));
                } else if (tab1.getId()==R.id.tab_category) {
                    loadFragment(new SearchFragment());
                } else if (tab1.getId()==R.id.tab_coupon) {
                    loadFragment(new CartFragment());
                }else {
                    loadFragment(new ProfileFragment());
                }

                return true;
            }
        });

    }

    private boolean loadFragment(Fragment fragment) {
        if (fragment != null) {
            getSupportFragmentManager().beginTransaction()
                    .replace(R.id.fragment_container, fragment)
                    .commit();
            return true;
        }
        return false;
    }

    public void addFragment(Fragment fragment) {
        FragmentManager fragmentManager = getSupportFragmentManager();
        FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
        fragmentTransaction.replace(R.id.fragment_container,fragment);
        fragmentTransaction.commit();
    }

    public void getData(DataOutputModel data) {
        banner = data.getBanner();
        coupen = data.getCoupen();
        category = data.getCategory();
        product = data.getProduct();
        topping = data.getTopping();
        store = data.getStore();

        addFragment(new HomeFragment(banner,category,product));
    }


}
