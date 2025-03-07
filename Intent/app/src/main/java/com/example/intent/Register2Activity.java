package com.example.intent;

import android.content.Intent;
import android.os.Bundle;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class Register2Activity extends AppCompatActivity {

    Button btnPre;
    TextView tvUname;
    TextView tvEmail;
    TextView tvPass;
    TextView tvCno;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_register2);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        btnPre=findViewById(R.id.btnPre);
        tvUname=findViewById(R.id.tvUname);
        tvEmail=findViewById(R.id.tvEmail);
        tvPass=findViewById(R.id.tvPass);
        tvCno=findViewById(R.id.tvCno);

        Intent intent = getIntent();
        String Uname = intent.getStringExtra("UNAME");
        String Email = intent.getStringExtra("EMAIL");
        String Pass = intent.getStringExtra("PASS");
        String Cno = intent.getStringExtra("CNO");
        tvUname.setText(Uname);
        tvEmail.setText(Email);
        tvPass.setText(Pass);
        tvCno.setText(Cno);

        btnPre.setOnClickListener(v -> {
            Intent i1 = new Intent(this,RegisterActivity.class);
            startActivity(i1);
        });
    }
}