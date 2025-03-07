package com.example.sharedprefrences_example.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sharedprefrences_example.R;
import com.example.sharedprefrences_example.utils.ConstantData;

public class HomeActivity extends AppCompatActivity {

    TextView tvEmail;
    Button btnLogout;
    SharedPreferences sp;

    @SuppressLint("WrongConstant")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_home);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvEmail = findViewById(R.id.tvEmail);
        btnLogout = findViewById(R.id.btnLogout);

        sp = getSharedPreferences(ConstantData.SP_NAME,MODE_APPEND);
        String email = sp.getString(ConstantData.KEY_SP_EMAIL,"");
        tvEmail.setText("Hello, "+email);

        btnLogout.setOnClickListener(v -> {
            SharedPreferences.Editor ed = sp.edit();
            ed.clear();
            ed.apply();

            Intent intent = new Intent(this, LoginActivity.class);
            startActivity(intent);
            finish();
        });
    }
}