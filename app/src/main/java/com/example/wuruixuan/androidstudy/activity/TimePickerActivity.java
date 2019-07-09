package com.example.wuruixuan.androidstudy.activity;

import android.app.DialogFragment;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.TextView;

import com.example.wuruixuan.androidstudy.R;

public class TimePickerActivity extends AppCompatActivity {

    private TextView tv_time;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_time_picker);
        tv_time = findViewById(R.id.textView_time);
    }

    public void setTimeClick(View view) {
        DialogFragment timePickerFragment = new TimePickerFragment();
        timePickerFragment.show(getFragmentManager(), "timePicker");
    }

    public void setTimeValue(int hour, int minute) {
        tv_time.setText(hour + ":" + minute);
    }
}
