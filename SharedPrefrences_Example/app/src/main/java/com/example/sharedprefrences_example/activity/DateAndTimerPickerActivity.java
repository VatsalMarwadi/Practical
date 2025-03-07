package com.example.sharedprefrences_example.activity;

import android.app.DatePickerDialog;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.example.sharedprefrences_example.R;

import java.util.Calendar;

public class DateAndTimerPickerActivity extends AppCompatActivity {

    TextView tvDate,tvTime;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_date_and_timer_picker);
        ViewCompat.setOnApplyWindowInsetsListener(findViewById(R.id.main), (v, insets) -> {
            Insets systemBars = insets.getInsets(WindowInsetsCompat.Type.systemBars());
            v.setPadding(systemBars.left, systemBars.top, systemBars.right, systemBars.bottom);
            return insets;
        });

        tvDate = findViewById(R.id.tvDate);
        tvTime = findViewById(R.id.tvTime);

        Calendar calendar = Calendar.getInstance();

        tvDate.setOnClickListener(v -> {

            int year = calendar.get(Calendar.YEAR);
            int month = calendar.get(Calendar.MONTH);
            int day = calendar.get(Calendar.DAY_OF_MONTH);

            DatePickerDialog dialog = new DatePickerDialog(
                    this,
                    (view, year1, month1, dayOfMonth) -> {
                        String date = String.format("%02d-%02d-%04d",dayOfMonth,month1+1,year1);
                        tvDate.setText("Selected Date : " + date);
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
                    tvTime.setText("Selected Time : " + time);
                },hour,mintue,true
            );
            dialog.show();
        });

    }
}