package com.example.wuruixuan.androidstudy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.wuruixuan.androidstudy.R;

public class DatePickerActivity extends AppCompatActivity {

    private TextView tv_date;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_date_picker);
        tv_date = findViewById(R.id.textView_date);
    }

    // 设置日期的按钮事件
    public void setDateClick(View view) {
        DatePickerFragment dialogFragment = new DatePickerFragment();
        dialogFragment.show(getFragmentManager(), "datePicker");
    }

    public void setDateValue(int year, int month, int day) {
        tv_date.setText(year + "年" + (month + 1) + "月" + day + "日");
    }
}
