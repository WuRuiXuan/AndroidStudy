package com.example.wuruixuan.androidstudy.activity;

import android.os.Bundle;
import android.support.v4.view.PagerAdapter;
import android.support.v4.view.ViewPager;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.wuruixuan.androidstudy.R;

import java.util.ArrayList;

public class ViewPagerActivity2 extends AppCompatActivity implements ViewPager.OnPageChangeListener {

    private ViewPager vp;
    private ArrayList<View> views = new ArrayList<>();
    private ImageView[] imageViews;
    private int currentIndex;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_pager2);
        vp = findViewById(R.id.viewPager);
        initViews();
        initPoints();
        vp.setAdapter(new MyPagerAdapter());
        vp.setOnPageChangeListener(this);
    }

    private void initViews() {
        views.add(getLayoutInflater().inflate(R.layout.pager_layout1, null));
        views.add(getLayoutInflater().inflate(R.layout.pager_layout2, null));
        views.add(getLayoutInflater().inflate(R.layout.pager_layout3, null));
        views.add(getLayoutInflater().inflate(R.layout.pager_layout4, null));
    }

    private void initPoints() {
        LinearLayout pointsLayout = findViewById(R.id.points_layout);
        imageViews = new ImageView[views.size()];
        for (int i = 0; i < imageViews.length; i ++) {
            imageViews[i] = (ImageView) pointsLayout.getChildAt(i);
        }
        currentIndex = 0;
        imageViews[currentIndex].setImageResource(R.drawable.touched_holo);
    }

    private void setCurrentPoint(int position) {
        if (currentIndex < 0 || currentIndex == position || currentIndex > imageViews.length - 1) {
            return;
        }
        imageViews[currentIndex].setImageResource(R.drawable.default_holo);
        imageViews[position].setImageResource(R.drawable.touched_holo);
    }

    @Override
    public void onPageScrolled(int position, float positionOffset, int positionOffsetPixels) {

    }

    @Override
    public void onPageSelected(int position) {
        setCurrentPoint(position);
        currentIndex = position;
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
    }
}
