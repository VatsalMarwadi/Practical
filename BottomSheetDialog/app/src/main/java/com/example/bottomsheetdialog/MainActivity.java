package com.example.bottomsheetdialog;

import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomsheet.BottomSheetDialog;

public class MainActivity extends AppCompatActivity {

    View layout;
    BottomSheetDialog dialog;
    Button btnOpen,btnClose;

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

        layout= LayoutInflater.from(this).inflate(R.layout.raw_bottom_sheet,null);

        btnOpen = findViewById(R.id.btnOpen);
        btnClose = layout.findViewById(R.id.btnClose);

        btnOpen.setOnClickListener(v -> showBottomSheetDialog());
        btnClose.setOnClickListener(v -> dialog.dismiss());

    }

    public void showBottomSheetDialog() {
        if(dialog == null) {
            dialog = new BottomSheetDialog(this);
            dialog.setContentView(layout);
            dialog.setCancelable(false);
        }
        dialog.show();
    }
}