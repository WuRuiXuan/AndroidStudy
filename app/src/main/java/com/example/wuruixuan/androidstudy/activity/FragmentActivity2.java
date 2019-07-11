package com.example.wuruixuan.androidstudy.activity;

import android.app.FragmentManager;
import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wuruixuan.androidstudy.R;

public class FragmentActivity2 extends AppCompatActivity {

    private ContentFragment fr_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment2);
        addContentLayout();
    }

    private void addContentLayout() {
        FragmentManager fm = getFragmentManager();
        // 开启一个事务
        FragmentTransaction ft = fm.beginTransaction();
        fr_content = new ContentFragment();
        // 添加Fragment
        ft.add(R.id.content_layout, fr_content);
//        ft.remove();
//        ft.replace();
        // 提交事务
        ft.commit();
    }
}
