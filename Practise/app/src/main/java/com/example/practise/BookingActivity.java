package com.example.practise;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.google.android.material.bottomsheet.BottomSheetDialog;

import java.util.Calendar;

public class BookingActivity extends AppCompatActivity {

    View layout;
    BottomSheetDialog dialog;
    Button btnBook,btnContinue;
    TextView btnCancle,tvDate,tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_booking);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        layout = LayoutInflater.from(this).inflate(R.layout.raw_bottom_table,null);

        btnBook = findViewById(R.id.btnBook);
        tvDate = layout.findViewById(R.id.tvDate);
        tvTime = layout.findViewById(R.id.tvTime);
        btnCancle = layout.findViewById(R.id.btnCancle);
        btnContinue = layout.findViewById(R.id.btnContinue);

        Calendar calendar = Calendar.getInstance();

        btnBook.setOnClickListener(v -> showBottomSheetDialog());
        btnCancle.setOnClickListener(v -> dialog.dismiss());

        tvDate.setOnClickListener(v -> {

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(
                    this,
                    (view, year1, month1, dayOfMonth) -> {
                        String date = String.format("%02d-%02d-%04d",dayOfMonth,month1+1,year1);
                        tvDate.setText(date);
                    },year,month,day
            );
            dialog.show();
        });

        tvTime.setOnClickListener(v -> {
            int hour = calendar.get(Calendar.HOUR_OF_DAY);
            int mintue = calendar.get(Calendar.MINUTE);

            TimePickerDialog dialog = new TimePickerDialog(
                    this,
                    (view, hourOfDay, minute) -> {
                        String time = String.format("%02d:%02d",hourOfDay,minute);
                        tvTime.setText(time);
                    },hour,mintue,true
            );
            dialog.show();
        });

    }

    private void showBottomSheetDialog() {
        if(dialog == null) {
            dialog = new BottomSheetDialog(this);
            dialog.setContentView(layout);
            dialog.setCancelable(false);
        }
        dialog.show();
    }
}