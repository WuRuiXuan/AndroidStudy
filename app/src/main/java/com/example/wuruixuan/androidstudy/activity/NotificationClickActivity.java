package com.example.wuruixuan.androidstudy.activity;

import android.app.NotificationManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.wuruixuan.androidstudy.R;

public class NotificationClickActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_click_notification);

        // 点击通知取消掉
        NotificationManager nm = (NotificationManager) getSystemService(NOTIFICATION_SERVICE);
        nm.cancel(NotificationsActivity.N_ID_1);

        String msg = getIntent().getStringExtra("msg");
        TextView tv = findViewById(R.id.msg);
        tv.setText(msg);
    }
}
