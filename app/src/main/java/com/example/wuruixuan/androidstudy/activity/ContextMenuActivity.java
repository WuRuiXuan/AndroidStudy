package com.example.wuruixuan.androidstudy.activity;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.ContextMenu;
import android.view.MenuItem;
import android.view.View;
import android.widget.TextView;

import com.example.wuruixuan.androidstudy.R;

public class ContextMenuActivity extends AppCompatActivity {

    private TextView tv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_context_menu);
        tv = findViewById(R.id.textView_bg);
        // 注册上下文菜单到tv组件上
        registerForContextMenu(tv);
    }

    // 创建上下文菜单的事件方法
    @Override
    public void onCreateContextMenu(ContextMenu menu, View v,
                                    ContextMenu.ContextMenuInfo menuInfo) {
        super.onCreateContextMenu(menu, v, menuInfo);
        getMenuInflater().inflate(R.menu.menu_context, menu);
    }

    @Override
    public boolean onContextItemSelected(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.red:
                tv.setBackgroundColor(Color.RED);
                break;
            case R.id.blue:
                tv.setBackgroundColor(Color.BLUE);
                break;
            case R.id.green:
                tv.setBackgroundColor(Color.GREEN);
                break;
        }
        return super.onContextItemSelected(item);
    }
}
