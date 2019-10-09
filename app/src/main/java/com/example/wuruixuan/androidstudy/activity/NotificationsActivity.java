package com.example.wuruixuan.androidstudy.activity;

import android.app.Notification;
import android.app.NotificationManager;
import android.app.PendingIntent;
import android.content.Context;
import android.content.Intent;
import android.support.v4.app.NotificationCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

import com.example.wuruixuan.androidstudy.R;

public class NotificationsActivity extends AppCompatActivity {

    public static final int N_ID_1 = 0x1;
    private static final String message = "新年快乐！万事如意！";

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_notifications);
    }

    public void sendNormalNotification(View v) {
        // API 11 之前创建通知的方式
//        Notification n = new Notification();
        // API 11 之后使用
//        Notification.Builder builder = new Notification.Builder(this);
        // V4 支持包
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        // 设置相关的属性
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("你有一条新消息");
        builder.setContentText(message);
//        builder.setAutoCancel(true); 点击通知取消掉
        builder.setDefaults(Notification.DEFAULT_ALL); // 声音 震动 呼吸灯
        builder.setNumber(10);
        builder.setTicker("新消息");
//        builder.setOngoing(true); // 设置为常驻通知
        // 定义一个意图，当点击通知时要打开一个界面(Activity)
        Intent intent = new Intent(this, NotificationClickActivity.class);
        intent.putExtra("msg", message);
        // 参数：上下文，请求编码（没用），意图，创建PendingIntent的方式
        // FLAG_UPDATE_CURRENT 如果有，更新Intent，没有就创建
        // FLAG_NO_CREATE      如果有就使用，没有不创建
        // FLAG_CANCEL_CURRENT 取消当前的pi，创建新的
        // FLAG_ONE_SHOT       只使用一次
        PendingIntent pi = PendingIntent.getActivity(this, 0, intent, PendingIntent.FLAG_UPDATE_CURRENT);
        // 通知的事件
        builder.setContentIntent(pi);

        Notification n = builder.build();
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(N_ID_1, n);
    }

    public void sendBigViewNotification(View v) {

    }
}
