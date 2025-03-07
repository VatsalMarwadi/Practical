package com.example.sharedprefrences_example.activity;

import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sharedprefrences_example.R;
import com.example.sharedprefrences_example.utils.Validation;

public class RegExValidationActivity extends AppCompatActivity {

    EditText etName,etEmail,etPassword,etPhone;
    Button btnSubmit;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_reg_ex_validation);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        etName = findViewById(R.id.etName);
        etEmail = findViewById(R.id.etEmail);
        etPassword = findViewById(R.id.etPassword);
        etPhone = findViewById(R.id.etPhone);

        btnSubmit = findViewById(R.id.btnSubmit);

        btnSubmit.setOnClickListener(v -> {
            String email = etEmail.getText().toString().trim();
            String pass = etPassword.getText().toString().trim();

            if (email.isEmpty()){
                Toast.makeText(this,"Enter Email",Toast.LENGTH_SHORT).show();
            } else if (!Validation.isValidEmail(email)) {
                Toast.makeText(this,"Enter Valid Email",Toast.LENGTH_SHORT).show();
            } else if (pass.isEmpty()) {
                Toast.makeText(this,"Enter Password",Toast.LENGTH_SHORT).show();
            } else if (!Validation.isValidEmail(pass)) {
                Toast.makeText(this,"Enter Valid Password",Toast.LENGTH_SHORT).show();
            } else {
                Toast.makeText(this,"All Correct",Toast.LENGTH_SHORT).show();
            }
        });
    }
}