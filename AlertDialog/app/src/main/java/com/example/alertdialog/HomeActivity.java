package com.example.alertdialog;

import android.os.Bundle;
import android.widget.Button;
import android.widget.RadioGroup;
import android.widget.Toast;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

public class HomeActivity extends AppCompatActivity {

    RadioGroup radioGrp;
    Button btnCheck;
    String name;
    int fees;

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

        radioGrp = findViewById(R.id.radioGrp);
        btnCheck = findViewById(R.id.btnCheck);

        radioGrp.setOnCheckedChangeListener((group, checkedId) -> {
            if (radioGrp.getCheckedRadioButtonId() == R.id.rbAndroid){
                name = "Android";
                fees = Integer.parseInt("30000");
                btnCheck.setOnClickListener(v -> {
                    Toast.makeText(this,"The Fees of "+name+" is Rs."+fees,Toast.LENGTH_SHORT).show();
                });
            } else if (radioGrp.getCheckedRadioButtonId() == R.id.rbFlutter) {
                name = "Flutter";
                fees = Integer.parseInt("60000");
                btnCheck.setOnClickListener(v -> {
                    Toast.makeText(this,"The Fees of "+name+" is Rs."+fees,Toast.LENGTH_SHORT).show();
                });
            } else if (radioGrp.getCheckedRadioButtonId() == R.id.rbReact) {
                name = "React";
                fees = Integer.parseInt("25000");
                btnCheck.setOnClickListener(v -> {
                    Toast.makeText(this, "The Fees of " + name + " is Rs." + fees, Toast.LENGTH_SHORT).show();
                });
            } else if (radioGrp.getCheckedRadioButtonId() == R.id.rbMern) {
                name = "MERN";
                fees = Integer.parseInt("95000");
                btnCheck.setOnClickListener(v -> {
                    Toast.makeText(this,"The Fees of "+name+" is Rs."+fees,Toast.LENGTH_SHORT).show();
                });
            } else {
                name = "DA & DS";
                fees = Integer.parseInt("45000");
                btnCheck.setOnClickListener(v -> {
                    Toast.makeText(this,"The Fees of "+name+" is Rs."+fees,Toast.LENGTH_SHORT).show();
                });
            }
        });
    }
}