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

        public MyAdapter(Context context) {
            this.context = context;
        }

        @Override
        public int getCount() {
            return titles.length;
        }

        @Override
        public Object getItem(int i) {
            return titles[i];
        }

        @Override
        public long getItemId(int i) {
            return i;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder vh;
            if (view == null) {
                LayoutInflater inflater = LayoutInflater.from(context);
                view = inflater.inflate(R.layout.list_item5, null);
                vh = new ViewHolder();
                vh.iv_icon = view.findViewById(R.id.imageView_icon);
                vh.tv_title = view.findViewById(R.id.textView_title);
                view.setTag(vh);
            }
            else {
                vh = (ViewHolder) view.getTag();
            }

            vh.iv_icon.setImageResource(icons[i]);
            vh.tv_title.setText(titles[i]);

            return view;
        }
    }

    // 用于保存第一次查找的组件，避免下次重复查找
    static class ViewHolder {
        ImageView iv_icon;
        TextView tv_title;
    }
}
