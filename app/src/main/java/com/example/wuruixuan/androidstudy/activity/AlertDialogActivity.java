package com.example.wuruixuan.androidstudy.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.Toast;

import com.example.wuruixuan.androidstudy.R;

import java.util.ArrayList;

public class AlertDialogActivity extends AppCompatActivity {

    String result = "Android";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alert_dialog);
    }

    // 提示对话框
    public void dialogClick1(View v) {
        // 创建一个对话框的构造者
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

    // 列表对话框
    public void dialogClick2(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择一个平台");
        final String[] items = {"Android", "iOS", "WindowsPhone"};
        builder.setItems(items, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogActivity.this, items[i], Toast.LENGTH_SHORT).show();
            }
        });
        builder.show();
    }

    // 多选列表对话框
    public void dialogClick3(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择一个平台");
        final ArrayList<String> list = new ArrayList<String>();
        final String[] items = {"Android", "iOS", "WindowsPhone"};
        builder.setMultiChoiceItems(items, null, new DialogInterface.OnMultiChoiceClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i, boolean b) {
                if (b) {
                    list.add(items[i]);
                }
                else {
                    list.remove(items[i]);
                }
            }
        });
        // 正面的按钮
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogActivity.this, list.toString(), Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        // 反面的按钮
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                list.clear();
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    // 单选列表对话框
    public void dialogClick4(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("请选择一个平台");
        final String[] items = {"Android", "iOS", "WindowsPhone"};
        builder.setSingleChoiceItems(items, 0, new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                result = items[i];
                Toast.makeText(AlertDialogActivity.this, "你选中了" + items[i], Toast.LENGTH_SHORT).show();
            }
        });
        // 正面的按钮
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                Toast.makeText(AlertDialogActivity.this, result, Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        // 反面的按钮
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }

    // 自定义对话框
    public void dialogClick5(View view) {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setTitle("登录对话框");
//        builder.setView(R.layout.login_layout); // api 21(android 5.0)支持
        // 实例化布局文件
        final View v = getLayoutInflater().inflate(R.layout.login_layout, null);
        builder.setView(v);

        // 正面的按钮
        builder.setPositiveButton("OK", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                EditText et_username = v.findViewById(R.id.editText_username);
                EditText et_password = v.findViewById(R.id.editText_password);
                String username = et_username.getText().toString();
                String password = et_password.getText().toString();
                Toast.makeText(AlertDialogActivity.this, username + "--" + password, Toast.LENGTH_SHORT).show();
                dialogInterface.dismiss();
            }
        });
        // 反面的按钮
        builder.setNegativeButton("Cancel", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialogInterface, int i) {
                dialogInterface.dismiss();
            }
        });
        builder.show();
    }
}
