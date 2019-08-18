package com.example.wuruixuan.androidstudy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextSwitcher;
import android.widget.TextView;
import android.widget.ViewSwitcher;

import com.example.wuruixuan.androidstudy.R;

public class TextSwitcherActivity extends AppCompatActivity implements ViewSwitcher.ViewFactory, View.OnTouchListener {

    private TextSwitcher ts;
    private String[] texts = {"岁月真是一把无情的杀猪刀", "我有钱我任性"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_switcher);
        ts = findViewById(R.id.textSwitcher);
        ts.setFactory(this);
        ts.setOnTouchListener(this);
    }

    @Override
    public View makeView() {
        TextView tv = new TextView(this);
        tv.setText(texts[index]);
        return tv;
    }

    float startX = 0.0f;
    float endX = 0.0f;
    int index;

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
                index = index + 1 < texts.length ? ++index : 0;
                ts.setInAnimation(this, android.R.anim.fade_in);
                ts.setOutAnimation(this, android.R.anim.fade_out);
            } else if (endX - startX > 20) { // 上一张
                index = index - 1 < 0 ? texts.length - 1 : --index;
                ts.setInAnimation(this, android.R.anim.fade_in);
                ts.setOutAnimation(this, android.R.anim.fade_out);
            }
            ts.setText(texts[index]);

            return true;
        }
        return false;
    }
}
