package com.example.wuruixuan.androidstudy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.ImageSwitcher;
import android.widget.ImageView;
import android.widget.ViewSwitcher;

import com.example.wuruixuan.androidstudy.R;

public class ImageSwitcherActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory, View.OnTouchListener {

    private ImageSwitcher is;
    private int[] images = { R.mipmap.a, R.mipmap.b, R.mipmap.c, R.mipmap.d };

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_switcher);
        is = findViewById(R.id.imageSwitcher);
        is.setFactory(this);
        is.setOnTouchListener(this);
    }

    @Override
    public View makeView() {
        ImageView iv = new ImageView(this);
        iv.setImageResource(images[0]);
        return iv;
    }

    float startX = 0.0f;
    float endX = 0.0f;
    private int index;

    // 触屏事件
    @Override
    public boolean onTouch(View v, MotionEvent event) {
        int action = event.getAction(); // 获取当前的事件动作
        if (action == MotionEvent.ACTION_DOWN) {
            startX = event.getX();
            return true;
        }
        else if (action == MotionEvent.ACTION_UP) {
            endX = event.getX();
            if (startX - endX > 20) { // 下一张
                index = index + 1 < images.length ? ++index : 0;
                is.setInAnimation(this, android.R.anim.fade_in);
                is.setOutAnimation(this, android.R.anim.fade_out);
            } else if (endX - startX > 20) { // 上一张
                index = index - 1 < 0 ? images.length - 1 : --index;
                is.setInAnimation(this, android.R.anim.fade_in);
                is.setOutAnimation(this, android.R.anim.fade_out);
            }
            is.setImageResource(images[index]);

            return true;
        }
        return false;
    }
}
