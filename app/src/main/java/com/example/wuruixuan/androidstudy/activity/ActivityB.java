package com.example.wuruixuan.androidstudy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wuruixuan.androidstudy.R;

public class ActivityB extends AppCompatActivity {

    private TextView tv_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        tv_info = findViewById(R.id.info);
        Intent intent = getIntent();
//        Bundle data = intent.getBundleExtra("data");
//        String info = data.getString("info");
        String info = intent.getStringExtra("info");
        int age = intent.getIntExtra("age", 18); // 第二个参数为取不到时的默认值
        tv_info.setText(info + "-" + age);
    }
}
