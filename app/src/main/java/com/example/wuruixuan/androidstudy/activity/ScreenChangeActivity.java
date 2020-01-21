package com.example.wuruixuan.androidstudy.activity;

import android.app.Activity;
import android.content.res.Configuration;
import android.os.PersistableBundle;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.wuruixuan.androidstudy.R;

/**
 * 横竖屏切换时默认情况下会重新创建Activity
 * 为了保存当前Activity的状态，我们可以重写onSaveInstanceState方法来保存相关数据
 * 然后在onCreate方法中还原数据
 * 或
 * 在Manifest文件中设置configChanges
 * 横竖屏切换时Activity就不会重新创建，onSaveInstanceState方法也不会调用
 * 而是调用onConfigurationChanged方法
 */
public class ScreenChangeActivity extends Activity {

    int index = 0;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_screen_change);
        System.out.println("ScreenChangeActivity--onCreate");

        // 还原状态值
        if (savedInstanceState != null) {
            index = savedInstanceState.getInt("index");
        }
    }

    public void changeClick(View view) {
        // 横竖屏切换后状态值不会保存（index从1开始）
        System.out.println("index=" + ++index);
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        System.out.println("onSaveInstanceState");
        outState.putInt("index", index);
    }

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        System.out.println("onConfigurationChanged");
    }

    // 横竖屏界面使用不同布局：在res目录下新建layout-land目录（Project模式下），在该目录下新建layout文件（与原竖屏layout文件名称相同）
}
