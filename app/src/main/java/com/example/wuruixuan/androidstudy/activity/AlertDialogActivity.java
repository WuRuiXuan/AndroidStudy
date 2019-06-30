package com.example.wuruixuan.androidstudy.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.example.wuruixuan.androidstudy.R;

public class AlertDialogActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }

    public void dialogClick1(View v) {
        // 创建一个提示对话框的构造者
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("提示");
        builder.setMessage("请问你有女朋友吗？");
        builder.setIcon(R.mipmap.ic_launcher);
        // 正面的按钮
        builder.setPositiveButton("有", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogActivity.this, "你可以走了", Toast.LENGTH_SHORT).show();
            }
        });
        // 反面的按钮
        builder.setNegativeButton("没有", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogActivity.this, "欢迎你来到单身俱乐部", Toast.LENGTH_SHORT).show();
            }
        });
        // 中立的按钮
        builder.setNeutralButton("隐藏", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogActivity.this, "有没有对我来说并不重要", Toast.LENGTH_SHORT).show();
            }
        });

//        AlertDialog dialog = builder.create();
//        dialog.show();

        builder.show();
    }
}
