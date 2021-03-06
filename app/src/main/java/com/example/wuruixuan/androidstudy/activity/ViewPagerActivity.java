package com.example.wuruixuan.androidstudy.activity;

import android.graphics.Color;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.PagerTabStrip;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Toast;

import com.example.wuruixuan.androidstudy.R;

import java.util.ArrayList;

public class ViewPagerActivity extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager vp;
    private PagerTabStrip pts;
    private String[] titles = {"第一幅画", "第二幅画", "第三幅画", "第四幅画"};
    private ArrayList<View> views = new ArrayList<>();

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager);

        vp = findViewById(R.id.viewPager);
        pts = findViewById(R.id.pagerTabStrip);
        initViews();
        vp.setAdapter(new MyPagerAdapter());
        vp.setOnPageChangeListener(this);
    }

    private void initViews() {
        views.add(getLayoutInflater().inflate(R.layout.pager_layout1, null));
        views.add(getLayoutInflater().inflate(R.layout.pager_layout2, null));
        views.add(getLayoutInflater().inflate(R.layout.pager_layout3, null));
        views.add(getLayoutInflater().inflate(R.layout.pager_layout4, null));

        pts.setBackgroundColor(getResources().getColor(android.R.color.holo_blue_light));
        pts.setTabIndicatorColor(getResources().getColor(android.R.color.holo_blue_bright));
        pts.setTextColor(Color.WHITE);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        Toast.makeText(this, "page---" + position, Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onPageScrollStateChanged(int state) {

    }

    class MyPagerAdapter extends PagerAdapter {

        @Override
        public int getCount() {
            return views.size();
        }

        // 判断视图是否为返回的对象
        @Override
        public boolean isViewFromObject(View view, Object object) {
            return view == object;
        }

        @Override
        public Object instantiateItem(ViewGroup container, int position) {
            View v = views.get(position);
            container.addView(v);
            return v;
        }

        @Override
        public void destroyItem(ViewGroup container, int position, Object object) {
            View v = views.get(position);
            container.removeView(v);
        }

        @Override
        public CharSequence getPageTitle(int position) {
            return titles[position];
        }
    }
}
