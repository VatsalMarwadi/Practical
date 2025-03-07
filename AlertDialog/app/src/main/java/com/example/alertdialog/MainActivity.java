package com.example.alertdialog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AlertDialog;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class MainActivity extends AppCompatActivity {

    Button btnShow;

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

        btnShow = findViewById(R.id.btnShow);

        btnShow.setOnClickListener(v -> {
            AlertDialog.Builder builder = new AlertDialog.Builder(this);
            builder.setTitle("Exit")
                    .setMessage("Are You Sure Want to Exit?")
                    .setPositiveButton("YES",(dialog, which) -> {
                        Toast.makeText(this,"Yes Button Clicked",Toast.LENGTH_SHORT).show();
                    })
                    .setNegativeButton("NO",(dialog, which) -> {
                        Toast.makeText(this,"No Button Clicked",Toast.LENGTH_SHORT).show();
                    }).show();
        });
    }
}