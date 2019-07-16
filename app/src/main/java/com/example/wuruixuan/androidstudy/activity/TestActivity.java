package com.example.wuruixuan.androidstudy.activity;

import android.content.DialogInterface;
import android.support.v7.app.AlertDialog;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.wuruixuan.androidstudy.R;

public class TestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test);
    }

    public final static int YES_NO_OPTION = 0x101;

    public final static int YES_OPTION = 1;
    public final static int NO_OPTION = 0;

    public static int result = 2;

    public static int showConfirmDialog(AppCompatActivity activity, String msg, String title, int option) {
        if (option == YES_NO_OPTION) {
            AlertDialog.Builder builder = new AlertDialog.Builder(activity);
            builder.setTitle("提示");
            builder.setMessage(msg);
            builder.setPositiveButton("是", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    result = YES_OPTION;
                    dialogInterface.dismiss();
                }
            });
            builder.setNegativeButton("否", new DialogInterface.OnClickListener() {
                @Override
                public void onClick(DialogInterface dialogInterface, int i) {
                    result = NO_OPTION;
                    dialogInterface.dismiss();
                }
            });
            builder.show();
        }
        while (true) {
            if (result != 2) {
                break;
            }
        }
        return result;
    }

    public void showDialog(View view) {
        showConfirmDialog(this, "测试", "提示信息", YES_NO_OPTION);
    }
}
