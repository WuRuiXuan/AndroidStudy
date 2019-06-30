package com.example.wuruixuan.androidstudy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.Spinner;

import com.example.wuruixuan.androidstudy.R;

public class SpinnerActivity extends AppCompatActivity {

    private Spinner spinner;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_spinner);

        spinner = (Spinner) findViewById(R.id.spinner1);
        String[] roles = {"管理员", "vip会员", "普通会员", "游客"};

        // 创建一个数组适配器
        // 方式一：（上下文，下拉列表里的布局，显示下拉选项的组件id，数据）
        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_dropdown_item_1line, android.R.id.text1, roles);

        // 方式二：（上下文，数据，布局）
        ArrayAdapter adapter2 = ArrayAdapter.createFromResource(this, R.array.city, android.R.layout.simple_spinner_dropdown_item);

        adapter.setDropDownViewResource(android.R.layout.simple_spinner_dropdown_item);

        // 通过适配器进行数据的绑定
        spinner.setAdapter(adapter);
    }
}
