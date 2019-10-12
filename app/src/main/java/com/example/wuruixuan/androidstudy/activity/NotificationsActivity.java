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
import android.widget.RemoteViews;

import com.example.wuruixuan.androidstudy.R;

public class NotificationsActivity extends AppCompatActivity {

    public static final int N_ID_1 = 0x1;
    public static final int N_ID_2 = 0x2;
    public static final int N_ID_3 = 0x3;
    public static final int N_ID_4 = 0x4;

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
        NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("消息");
        builder.setContentText("消息");
        builder.setNumber(5);
        // 设置大视图样式
        NotificationCompat.InboxStyle style = new NotificationCompat.InboxStyle();
        style.setBigContentTitle("吟诗作赋");
        style.addLine("两个黄鸟鸣羽木");
        style.addLine("一行白鸟上月天");
        style.setSummaryText("作者：豆腐");
        builder.setStyle(style);

        Notification n = builder.build();
        NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(N_ID_2, n);
    }

    public void sendProgressBarNotification(View v) {
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        builder.setSmallIcon(R.mipmap.ic_launcher);
        builder.setContentTitle("更新中...");
        builder.setContentText("正在由装逼模式更新至牛逼模式");
        // 第三个参数 true - 不确定进度
        builder.setProgress(100, 5, false);

        final NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(N_ID_3, builder.build());

        // 模拟更新的线程
        new Thread(new Runnable() {
            @Override
            public void run() {
                for (int progress = 0; progress < 100; progress+=5) {
                    builder.setProgress(100, progress, false);
                    nm.notify(N_ID_3, builder.build());
                    try {
                        Thread.sleep(500);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
                builder.setProgress(0, 0, false);
                builder.setContentText("更新完成，由于机主逼格不够，正在返回逗逼模式");
                nm.notify(N_ID_3, builder.build());
            }
        }).start();
    }

    public void sendCustomViewNotification(View v) {
        final NotificationCompat.Builder builder = new NotificationCompat.Builder(this);
        // 创建一个远程的视图
        RemoteViews views = new RemoteViews(getPackageName(), R.layout.notification_custom_layout);
        builder.setContent(views);
        builder.setTicker("云音乐");
        builder.setSmallIcon(android.R.drawable.ic_dialog_email);
        final NotificationManager nm = (NotificationManager) getSystemService(Context.NOTIFICATION_SERVICE);
        nm.notify(N_ID_4, builder.build());
    }
}
