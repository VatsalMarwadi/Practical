package com.example.alertdialog;

import android.os.Bundle;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class RadioBtnActivity extends AppCompatActivity {

    RadioGroup radioGrp;
    String gender;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_radio_btn);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        radioGrp = findViewById(R.id.radioGrp);

        radioGrp.setOnCheckedChangeListener((group, checkedId) -> {
            if(radioGrp.getCheckedRadioButtonId() == R.id.rbMale){
                gender = "Male";
                Toast.makeText(this,"Selected "+gender,Toast.LENGTH_SHORT).show();
            } else {
                gender = "Female";
                Toast.makeText(this,"Selected "+gender,Toast.LENGTH_SHORT).show();
            }
        });
    }
}