package com.example.wuruixuan.androidstudy;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.os.Handler;
import android.os.Message;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ImageView;

import java.io.IOException;
import java.io.InputStream;
import java.lang.ref.WeakReference;
import java.net.MalformedURLException;
import java.net.URL;

// 访问网络的操作必须在工作线程中完成

public class NetImageActivity extends AppCompatActivity {

    private ImageView iv;
    private final MyHandler handler = new MyHandler(this);
    private static final int LOAD_SUCCESS = 0x1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_net_image);
        iv = findViewById(R.id.imageView);
    }

    private static class MyHandler extends Handler {
        private final WeakReference<NetImageActivity> weakReference;
        public MyHandler(NetImageActivity netImageActivity) {
            weakReference = new WeakReference<NetImageActivity>(netImageActivity);
        };

        @Override
        public void handleMessage(Message msg) {
            NetImageActivity netImageActivity = weakReference.get();
            if (netImageActivity != null) {
                switch (msg.what) {
                    case LOAD_SUCCESS:
                        netImageActivity.iv.setImageBitmap((Bitmap) msg.obj);
                        break;
                }
            }
        }
    }

    public void showNetImage(View view) {
        new Thread(new Runnable() {
            @Override
            public void run() {
                try {
                    URL url = new URL("https://timgsa.baidu.com/timg?image&quality=80&size=b9999_10000&sec=1561816980082&di=7b214f98b6cd2dca3458415239d2e3c1&imgtype=0&src=http%3A%2F%2Fphoto.16pic.com%2F00%2F37%2F79%2F16pic_3779428_b.jpg");
                    InputStream in = url.openStream();
                    Bitmap bitmap = BitmapFactory.decodeStream(in);
                    Message msg = handler.obtainMessage(LOAD_SUCCESS, bitmap);
                    handler.sendMessage(msg);
                } catch (MalformedURLException e) {
                    e.printStackTrace();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }).start();
    }
}
