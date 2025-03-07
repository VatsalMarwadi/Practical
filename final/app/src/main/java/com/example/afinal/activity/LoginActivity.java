package com.example.afinal.activity;

import android.annotation.SuppressLint;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.afinal.Api.Login_Register_Api;
import com.example.afinal.fragment.ProfileFragment;
import com.example.afinal.R;
import com.example.afinal.model.PersonModel;
import com.example.afinal.utils.ConstantData;
import com.example.afinal.utils.Validation;

public class LoginActivity extends AppCompatActivity {

    TextView tvRes;
    TextView btnLogin;
    EditText etEmail,etPass;
    SharedPreferences sp;

    @SuppressLint("MissingInflatedId")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_login);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvRes = findViewById(R.id.tvRes);
        btnLogin = findViewById(R.id.btnLogin);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);

        Intent intent = getIntent();

        tvRes.setOnClickListener(v -> {
            Intent i1 = new Intent(this, RegisterActivity.class);
            startActivity(i1);
        });

        btnLogin.setOnClickListener( v -> {

            String Email = etEmail.getText().toString().trim();
            String Password = etPass.getText().toString().trim();

            if (Email.isEmpty()) {
                Toast.makeText(this,"Enter Email",Toast.LENGTH_SHORT).show();
            } else {
                PersonModel personModel=new PersonModel("",Email,"","",Password,"","");
                new Login_Register_Api().loginUser(LoginActivity.this,personModel);
            }

        });

    }
}