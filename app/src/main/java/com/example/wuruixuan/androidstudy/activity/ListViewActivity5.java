package com.example.wuruixuan.androidstudy.activity;

import android.content.Context;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wuruixuan.androidstudy.R;

/**
 * 优化：
 * 1、使ListView的宽高固定，避免内容变化导致ListView重新渲染
 * 2、使用ConvertView减少对象的创建
 * 3、使用ViewHolder减少对象的查找
 */

public class ListViewActivity5 extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view5);
        lv = findViewById(R.id.listView);
        lv.setAdapter(new MyAdapter(this));
    }

    /**
     * 使用自定义适配器
     */

    static class MyAdapter extends BaseAdapter {

        private String[] titles = {"title-1", "title-2", "title-3", "title-4", "title-5"};
        private int[] icons = {android.R.drawable.ic_dialog_dialer, android.R.drawable.ic_dialog_alert,
                android.R.drawable.ic_dialog_email, android.R.drawable.ic_dialog_info, android.R.drawable.ic_dialog_map};
        private Context context;

        private MyAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object getItem(int position) {
            return titles[position];
        }

        @Override
        public long getItemId(int position) {
            return position;
        }

        @Override
        public View getView(int position, View convertView, ViewGroup parent) {
            ViewHolder vh;
            if (convertView == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                convertView = inflater.inflate(R.layout.list_item5, null);
                vh = new ViewHolder();
                vh.iv_icon = convertView.findViewById(R.id.imageView_icon);
                vh.tv_title = convertView.findViewById(R.id.textView_title);
                convertView.setTag(vh);
            }
            else {
                vh = (ViewHolder) convertView.getTag();
            }

            vh.iv_icon.setImageResource(icons[position]);
            vh.tv_title.setText(titles[position]);

            return convertView;
        }
    }

    // 用于保存第一次查找的组件，避免下次重复查找
    static class ViewHolder {
        ImageView iv_icon;
        TextView tv_title;
    }
}
