package com.example.wuruixuan.androidstudy.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.GridView;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wuruixuan.androidstudy.R;

public class GridViewActivity2 extends AppCompatActivity {

    private GridView gv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_grid_view2);
        gv = findViewById(R.id.gridView);
        gv.setAdapter(new MyAdapter(this));
        gv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> adapterView, View view, int i, long l) {
                System.out.println("adapterView:" + adapterView); // GridView
                System.out.println("view:" + view); // 每一个选项的布局
                System.out.println("i:" + i); // 所在的位置（index）
                System.out.println("l:" + l); // id
//                ImageView iv = view.findViewById(R.id.imageView);
                TextView tv = view.findViewById(R.id.textView);
                Toast.makeText(GridViewActivity2.this, tv.getText(), Toast.LENGTH_SHORT).show();
            }
        });
    }

    static class MyAdapter extends BaseAdapter {

        private Context context;
        private String[] names = {"转账", "查询", "金融", "基金", "信用卡", "商城", "充值", "红包"};
        private int[] images = {R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher,
                R.mipmap.ic_launcher, R.mipmap.ic_launcher, R.mipmap.ic_launcher};

        public MyAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return names.length;
        }

        @Override
        public Object getItem(int i) {
            return names[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            LayoutInflater inflater = LayoutInflater.from(context);
            View itemView = inflater.inflate(R.layout.item_layout, null);
            ImageView iv = itemView.findViewById(R.id.imageView);
            TextView tv = itemView.findViewById(R.id.textView);
            iv.setImageResource(images[i]);
            tv.setText(names[i]);
            return itemView;
        }
    }
}
