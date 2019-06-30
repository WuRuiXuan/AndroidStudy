package com.example.wuruixuan.androidstudy.activity;

import android.os.Bundle;
import android.support.design.widget.FloatingActionButton;
import android.support.design.widget.Snackbar;
import android.support.v7.app.AppCompatActivity;
import android.support.v7.widget.Toolbar;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wuruixuan.androidstudy.R;

public class ToastActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // 绑定布局文件
        setContentView(R.layout.activity_toast);
    }

    public void viewText(View v) {
        // 上下文也可以用this
        Toast.makeText(getApplicationContext(), "今天天气真好", Toast.LENGTH_SHORT).show();
    }

    public void viewImage(View v) {
        Toast toast = new Toast(this);
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.img1);
        toast.setView(imageView);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }

    public void viewImageText(View v) {
        Toast toast = new Toast(this);

        TextView textView = new TextView(this);
        textView.setText("可爱的猫猫");
        ImageView imageView = new ImageView(this);
        imageView.setImageResource(R.drawable.img1);

        LinearLayout layout = new LinearLayout(this);
        layout.setOrientation(LinearLayout.VERTICAL);
        layout.setGravity(Gravity.CENTER);
        layout.addView(imageView);
        layout.addView(textView);

        toast.setView(layout);
        toast.setDuration(Toast.LENGTH_SHORT);
        toast.setGravity(Gravity.CENTER, 0, 0);
        toast.show();
    }
}
