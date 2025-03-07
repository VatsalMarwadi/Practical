package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.EditText;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RegisterActivity extends AppCompatActivity {

    Button btnReg;
    EditText etUname;
    EditText etEmail;
    EditText etPass;
    EditText etCno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnReg = findViewById(R.id.btnReg);
        etUname = findViewById(R.id.etUname);
        etEmail = findViewById(R.id.etEmail);
        etPass = findViewById(R.id.etPass);
        etCno = findViewById(R.id.etCno);

        btnReg.setOnClickListener(v -> {
            String uname = etUname.getText().toString().trim();
            String email = etEmail.getText().toString().trim();
            String pass = etPass.getText().toString().trim();
            String cno = etCno.getText().toString().trim();
            Intent i1 = new Intent(this, Register2Activity.class);
            i1.putExtra("UNAME",uname);
            i1.putExtra("EMAIL",email);
            i1.putExtra("PASS",pass);
            i1.putExtra("CNO",cno);
            startActivity(i1);
        });
    }
}