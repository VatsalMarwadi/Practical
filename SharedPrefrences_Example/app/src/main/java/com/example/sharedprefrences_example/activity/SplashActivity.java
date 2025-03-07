package com.example.sharedprefrences_example.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sharedprefrences_example.R;
import com.example.sharedprefrences_example.utils.ConstantData;

public class SplashActivity extends AppCompatActivity {

    SharedPreferences sp;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_splash);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        sp = getSharedPreferences(ConstantData.SP_NAME,MODE_APPEND);
        boolean islogin = sp.getBoolean(ConstantData.KEY_SP_ISLOGIN,false);

        new Handler().postDelayed(() -> {
            if(islogin) {
                // Start the main activity after the delay
                Intent intent = new Intent(SplashActivity.this, HomeActivity.class);
                startActivity(intent);
                // Finish the splash activity
                finish();
            } else {
                // Start the main activity after the delay
                Intent intent = new Intent(SplashActivity.this, LoginActivity.class);
                startActivity(intent);
                // Finish the splash activity
                finish();
            }
        }, 5000);

    }
}