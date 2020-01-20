package com.example.wuruixuan.androidstudy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wuruixuan.androidstudy.R;
import com.example.wuruixuan.androidstudy.activity.classes.Cat;
import com.example.wuruixuan.androidstudy.activity.classes.Dog;

public class ActivityB extends AppCompatActivity {

    private TextView tv_info;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        tv_info = findViewById(R.id.info);

        Intent intent = getIntent();
        if (intent.getBundleExtra("data") != null) {
            Bundle data = intent.getBundleExtra("data");
            String info = data.getString("info");
            tv_info.setText(info);
        }
        else if (intent.getStringExtra("info") != null) {
            String info = intent.getStringExtra("info");
            int age = intent.getIntExtra("age", 18); // 第二个参数为取不到时的默认值
            tv_info.setText(info + "-" + age);
        }
        else if (intent.getSerializableExtra("cat") != null) {
            Cat cat = (Cat) intent.getSerializableExtra("cat");
            tv_info.setText(cat.toString());
        }
        else if (intent.getParcelableExtra("dog") != null) {
            Dog dog = (Dog) intent.getParcelableExtra("dog");
            tv_info.setText(dog.toString());
        }
    }
}
