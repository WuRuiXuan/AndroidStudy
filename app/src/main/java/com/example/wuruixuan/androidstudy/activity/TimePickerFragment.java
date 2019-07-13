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
        // 通过getActivity方法获取该Fragment所依赖的Activity对象
        timePickerActivity = (TimePickerActivity) getActivity();
    }

    // 创建对话框的事件方法：该方法会在Activity的按钮事件中调用show方法时，检查是否已存在Dialog，当不存在时会触发该方法，否则直接显示
    @Override
    public Dialog onCreateDialog(Bundle savedInstanceState) {

        // 获取当前系统时间
        Calendar c = Calendar.getInstance();
        hour = c.get(Calendar.HOUR_OF_DAY);
        minute = c.get(Calendar.MINUTE);

        TimePickerDialog dialog = new TimePickerDialog(getActivity(), this, hour, minute, true);
        return dialog;
    }

    // 时间对话框中“完成”按钮的单击事件
    @Override
    public void onTimeSet(TimePicker timePicker, int i, int i1) {
        this.hour = i;
        this.minute = i1;
        // 把用户设置的时间显示到界面TextView组件上
        timePickerActivity.setTimeValue(i, i1);
    }
}
