package com.example.wuruixuan.androidstudy.activity;

import android.app.Activity;
import android.content.pm.ActivityInfo;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Window;
import android.view.WindowManager;

import com.example.wuruixuan.androidstudy.R;

public class ScreenOrientationActivity extends Activity { // 去除标题栏需要继承Activity

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 1. 在Manifest文件中设置屏幕方向
        // 2. 通过代码设置屏幕方向
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE);
//        setRequestedOrientation(ActivityInfo.SCREEN_ORIENTATION_PORTRAIT);

        // 设置全屏
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // 去除标题栏
//        requestWindowFeature(Window.FEATURE_NO_TITLE);

        // 在Manifest文件中设置主题

        setContentView(R.layout.activity_screen_orientation);
    }
}
