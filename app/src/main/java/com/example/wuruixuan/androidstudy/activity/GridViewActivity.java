package com.example.wuruixuan.androidstudy.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;

import com.example.wuruixuan.androidstudy.R;

/**
 * GridView组件：
 * 1、自定义适配器：
 * （1）创建一个类，继承BaseAdapter
 * （2）实现4个方法：
 *      getCount：获取要显示的选项总数
 *      getItem：获取每一个选项
 *      getItemId：选项ID
 *      getView：该方法用来为每一个选项生成视图（ImageView），会被多次调用
 */

public class GridViewActivity extends AppCompatActivity {

    private GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view);
        gv = findViewById(R.id.gridView);
        gv.setAdapter(new MyAdapter(this));
    }

    // 使用静态内部类比单纯的内部类效率要高
    static class MyAdapter extends BaseAdapter {
        private int[] images = {R.mipmap.sample_0, R.mipmap.sample_1, R.mipmap.sample_2, R.mipmap.sample_3, R.mipmap.sample_4,
                R.mipmap.sample_5, R.mipmap.sample_6, R.mipmap.sample_7, R.mipmap.sample_0, R.mipmap.sample_1, R.mipmap.sample_2,
                R.mipmap.sample_3, R.mipmap.sample_4, R.mipmap.sample_5, R.mipmap.sample_6, R.mipmap.sample_7};
        private Context context;

        public MyAdapter(Context context) {
            this.context = context;
        };

        @Override
        public int getCount() {
            return images.length;
        }

        @Override
        public Object getItem(int i) {
            return images[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ImageView iv = new ImageView(context);
            iv.setImageResource(images[i]);
            return iv;
        }
    }
}
