package com.example.wuruixuan.androidstudy.activity;

import android.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;

import com.example.wuruixuan.androidstudy.R;

public class PopBackTaskActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_pop_back_task);
    }

    public void oneClick(View view) {
//        PopBackFragment p1 = new PopBackFragment("one");
        PopBackFragment p1 = PopBackFragment.getInstance("one");
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content, p1);
        // 把当前Fragment添加到Activity栈
        ft.addToBackStack(null);
        ft.commit();
    }

    public void twoClick(View view) {
//        PopBackFragment p2 = new PopBackFragment("two");
        PopBackFragment p2 = PopBackFragment.getInstance("two");
        FragmentTransaction ft = getFragmentManager().beginTransaction();
        ft.replace(R.id.content, p2);
        // 把当前Fragment添加到Activity栈
        ft.addToBackStack(null);
        ft.commit();
    }

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == event.KEYCODE_BACK) {
            if (getFragmentManager().getBackStackEntryCount() == 0) {
                finish();
            }
            else {
                getFragmentManager().popBackStack();
            }
            return true;
        }
        return super.onKeyDown(keyCode, event);
    }
}
