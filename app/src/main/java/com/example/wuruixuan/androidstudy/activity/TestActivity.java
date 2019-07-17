package com.example.wuruixuan.androidstudy.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.InputType;
import android.view.View;
import android.widget.EditText;

import com.example.wuruixuan.androidstudy.R;

public class TestActivity extends AppCompatActivity {

    private EditText et;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
        et = findViewById(R.id.editText);
    }

    public void editableClick(View view) {
//        et.setCursorVisible(true);
//        et.setFocusable(true);
//        et.setFocusableInTouchMode(true);
        et.setEnabled(true);
    }

    public void notEditableClick(View view) {
//        et.setCursorVisible(false);
//        et.setFocusable(false);
//        et.setFocusableInTouchMode(false);
        et.setEnabled(false);
    }
}
