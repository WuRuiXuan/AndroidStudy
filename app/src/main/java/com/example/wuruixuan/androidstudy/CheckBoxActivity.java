package com.example.wuruixuan.androidstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CheckBox;
import android.widget.CompoundButton;
import android.widget.Toast;

public class CheckBoxActivity extends AppCompatActivity implements CompoundButton.OnCheckedChangeListener {

    private CheckBox checkBox1, checkBox2, checkBox3;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_check_box);

        checkBox1 = (CheckBox) findViewById(R.id.checkBox1);
        checkBox2 = (CheckBox) findViewById(R.id.checkBox2);
        checkBox3 = (CheckBox) findViewById(R.id.checkBox3);

        checkBox1.setOnCheckedChangeListener(this);
        checkBox2.setOnCheckedChangeListener(this);
        checkBox3.setOnCheckedChangeListener(this);
    }

    @Override
    public void onCheckedChanged(CompoundButton compoundButton, boolean b) {
        switch (compoundButton.getId()) {
            case R.id.checkBox1:
            {
                if (b) {
                    Toast.makeText(this, "你选中了小说选项", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, "你取消了小说选项", Toast.LENGTH_SHORT).show();
                }
            }
            break;
            case R.id.checkBox2:
            {
                if (b) {
                    Toast.makeText(this, "你选中了游戏选项", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, "你取消了游戏选项", Toast.LENGTH_SHORT).show();
                }
            }
            break;
            case R.id.checkBox3:
            {
                if (b) {
                    Toast.makeText(this, "你选中了电影选项", Toast.LENGTH_SHORT).show();
                }
                else {
                    Toast.makeText(this, "你取消了电影选项", Toast.LENGTH_SHORT).show();
                }
            }
            break;
            default:
        }
    }
}
