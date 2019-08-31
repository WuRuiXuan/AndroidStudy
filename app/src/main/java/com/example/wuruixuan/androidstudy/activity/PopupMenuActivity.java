package com.example.wuruixuan.androidstudy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MenuInflater;
import android.view.MenuItem;
import android.view.View;
import android.widget.Button;
import android.widget.PopupMenu;
import android.widget.Toast;

import com.example.wuruixuan.androidstudy.R;

public class PopupMenuActivity extends AppCompatActivity implements PopupMenu.OnMenuItemClickListener {

    private Button btn_select;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_popup_menu);
        btn_select = findViewById(R.id.button_select);
    }

    public void selectSizeClick(View view) {
        // 创建弹出式菜单
        PopupMenu popupMenu = new PopupMenu(this, view);
        MenuInflater inflater = popupMenu.getMenuInflater();
        inflater.inflate(R.menu.menu_popup, popupMenu.getMenu());
        // 弹出式菜单的选项单击事件
        popupMenu.setOnMenuItemClickListener(this);
        popupMenu.show();
    }

    @Override
    public boolean onMenuItemClick(MenuItem item) {
        switch (item.getItemId()) {
            case R.id.size_s:
                Toast.makeText(this, "你选择了S号", Toast.LENGTH_SHORT).show();
                break;
            case R.id.size_m:
                Toast.makeText(this, "你选择了M号", Toast.LENGTH_SHORT).show();
                break;
            case R.id.size_l:
                Toast.makeText(this, "你选择了L号", Toast.LENGTH_SHORT).show();
                break;
        }
        return true;
    }
}
