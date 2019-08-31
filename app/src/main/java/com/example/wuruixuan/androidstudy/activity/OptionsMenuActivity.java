package com.example.wuruixuan.androidstudy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.example.wuruixuan.androidstudy.R;

/**
 * 选项菜单
 */

public class OptionsMenuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_options_menu);
    }

    // 用于创建选项菜单的事件方法，在打开界面时会被自动调用
    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        // getMenuInflater 获取一个菜单填充器
        getMenuInflater().inflate(R.menu.menu_options, menu);
        // 添加菜单项（组ID，当前选项ID，排序，标题）
//        menu.add(0, 100, 1, "设置游戏");
//        menu.add(0, 200, 2, "开始游戏");
//        menu.add(0, 300, 3, "退出游戏");
        return super.onCreateOptionsMenu(menu);
    }

    // 菜单选项的单击事件处理方法
    @Override
    public boolean onOptionsItemSelected(MenuItem item) {
        int id = item.getItemId();
        switch (id) {
            case 100:
                Toast.makeText(this, "正在打开设置游戏界面...", Toast.LENGTH_SHORT).show();
                break;
            case 200:
                Toast.makeText(this, "正在启动游戏界面...", Toast.LENGTH_SHORT).show();
                break;
            case 300:
                Toast.makeText(this, "正在关闭游戏...", Toast.LENGTH_SHORT).show();
                break;

            case R.id.game_settings:
                Toast.makeText(this, "正在打开设置游戏界面...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.game_start:
                Toast.makeText(this, "正在启动游戏界面...", Toast.LENGTH_SHORT).show();
                break;
            case R.id.game_exit:
                Toast.makeText(this, "正在关闭游戏...", Toast.LENGTH_SHORT).show();
                break;
        }
        return super.onOptionsItemSelected(item);
    }
}
