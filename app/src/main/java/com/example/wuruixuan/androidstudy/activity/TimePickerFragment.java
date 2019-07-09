package com.example.wuruixuan.androidstudy.activity;

import android.app.Dialog;
import android.app.DialogFragment;
import android.app.TimePickerDialog;
import android.os.Bundle;
import android.widget.TimePicker;
//import android.support.v4.app.DialogFragment; // 老版本用v4

import java.util.Calendar;

public class TimePickerFragment extends DialogFragment implements TimePickerDialog.OnTimeSetListener {

    int hour;
    int minute;
    private TimePickerActivity timePickerActivity;

    @Override
    public void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        timePickerActivity = (TimePickerActivity) getActivity();
    }

    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // 获取当前系统时间
        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        TimePickerDialog dialog = new TimePickerDialog(getActivity(), this, hour, minute, true);
        return dialog;
    }

    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        this.hour = i;
        this.minute = i1;
        timePickerActivity.setTimeValue(i, i1);
    }
}
