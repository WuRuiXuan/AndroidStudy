package com.example.wuruixuan.androidstudy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.DatePicker;
import android.widget.TimePicker;
import android.widget.Toast;

import com.example.wuruixuan.androidstudy.R;

public class TimeDatePickerActivity extends AppCompatActivity {

    private TimePicker tp;
    private DatePicker dp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_date_picker);
        tp = findViewById(R.id.timePicker);
        dp = findViewById(R.id.datePicker);
    }

    public void saveClick(View view) {
        int hour = tp.getCurrentHour();
        int minute = tp.getCurrentMinute();
        Toast.makeText(this, hour + ":" + minute, Toast.LENGTH_SHORT).show();
    }

    public void okClick(View view) {
        int year = dp.getYear();
        int month = dp.getMonth();
        int day = dp.getDayOfMonth();
        Toast.makeText(this, year + "年" + (month + 1) + "月" + day + "日", Toast.LENGTH_SHORT).show();
    }
}
