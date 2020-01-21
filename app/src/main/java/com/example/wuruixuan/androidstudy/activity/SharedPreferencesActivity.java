package com.example.wuruixuan.androidstudy.activity;

import android.content.Context;
import android.content.SharedPreferences;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.TextUtils;
import android.widget.EditText;

import com.example.wuruixuan.androidstudy.R;

public class SharedPreferencesActivity extends AppCompatActivity {

    private EditText et_msg;
    private SharedPreferences sp;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shared_preferences);

        et_msg = findViewById(R.id.editText_msg);

        // 获取当前程序的SharedPreferences对象
        sp = getSharedPreferences("msg", Context.MODE_PRIVATE);
    }

    // 存储数据（保存数据的xml文件在data/data/包名/shared_prefs目录下）
    @Override
    protected void onPause() {
        super.onPause();
        String msg = et_msg.getText().toString();
        if (TextUtils.isEmpty(msg)) {
            return;
        }
        SharedPreferences.Editor editor = sp.edit();
        editor.putString("msg", msg);
        editor.commit();
//        editor.apply();
    }

    // 还原数据
    @Override
    protected void onResume() {
        super.onResume();
        String msg = sp.getString("msg", "");
        et_msg.setText(msg);
        SharedPreferences.Editor editor = sp.edit();
        editor.remove("msg");
//        editor.clear();
        editor.commit();
    }
}
