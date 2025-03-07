package com.example.afinal.activity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.widget.VideoView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.appcompat.widget.AppCompatButton;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.afinal.R;

public class StartActivity extends AppCompatActivity {

    VideoView vvstart;
    AppCompatButton btnstart;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_start);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        vvstart = findViewById(R.id.vvstart);
        btnstart = findViewById(R.id.btnstart);

        Intent intent = getIntent();

        vvstart.setVideoURI(Uri.parse("android.resource://" + getPackageName() + "/" + R.raw.start));
        vvstart.start();

        btnstart.setOnClickListener(v -> {
            Intent i1 = new Intent(this, LoginActivity.class);
            startActivity(i1);
        });
    }
}