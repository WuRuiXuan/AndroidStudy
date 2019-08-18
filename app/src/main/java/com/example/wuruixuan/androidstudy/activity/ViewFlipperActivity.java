package com.example.wuruixuan.androidstudy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.widget.ViewFlipper;

import com.example.wuruixuan.androidstudy.R;

public class ViewFlipperActivity extends AppCompatActivity {

    private ViewFlipper vf;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_flipper);
        vf = findViewById(R.id.viewFlipper);
    }

    float startX = 0.0f;
    float endX = 0.0f;

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int action = event.getAction(); // 获取当前的事件动作
        if (action == MotionEvent.ACTION_DOWN) {
            startX = event.getX();
        }
        else if (action == MotionEvent.ACTION_UP) {
            endX = event.getX();
            if (startX > endX) { // 下一张
                vf.setInAnimation(this, R.anim.in_right_left);
                vf.setOutAnimation(this, R.anim.out_right_left);
                vf.showNext();
            } else if (endX > startX) { // 上一张
                vf.setInAnimation(this, R.anim.in_left_right);
                vf.setOutAnimation(this, R.anim.out_left_right);
                vf.showPrevious();
            }
        }
        return super.onTouchEvent(event);
    }
}
