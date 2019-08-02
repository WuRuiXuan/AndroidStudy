package com.example.wuruixuan.androidstudy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AbsListView;
import android.widget.BaseAdapter;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wuruixuan.androidstudy.R;

import java.util.Vector;

public class ListViewActivity6 extends AppCompatActivity implements AbsListView.OnScrollListener {

    private ListView lv;
    private int index;
    private static Vector<News> news = new Vector<>();
    private MyAdapter adapter;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view6);
        lv = findViewById(R.id.listView);
        initData();
        adapter = new MyAdapter();
        lv.setAdapter(adapter);
        View loadingView = getLayoutInflater().inflate(R.layout.loading, null);
        lv.addFooterView(loadingView);
    }

    /**
     * 初始化数据
     */
    private void initData() {
        for (int i = 0; i < 10; i++) {
            News n = new News();
            n.title = "title--" + index;
            n.content = "content--" + index;
            index++;
            news.add(n);
        }
    }

    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {

        }
    }

    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {

    }

    static class News {
        String title;
        String content;
    }

    class MyAdapter extends BaseAdapter {

        @Override
        public int getCount() {
            return news.size();
        }

        @Override
        public Object getItem(int i) {
            return news.get(i);
        }

        @Override
        public long getItemId(int i) {
            return 0;
        }

        @Override
        public View getView(int i, View view, ViewGroup viewGroup) {
            ViewHolder vh;
            if (view == null) {
                view = getLayoutInflater().inflate(R.layout.list_item6, null);
                vh = new ViewHolder();
                vh.tv_title = view.findViewById(R.id.textView_title);
                vh.tv_content = view.findViewById(R.id.textView_content);
                view.setTag(vh);
            }
            else {
                vh = (ViewHolder) view.getTag();
            }
            News n = news.get(i);
            vh.tv_title.setText(n.title);
            vh.tv_content.setText(n.content);
            return view;
        }
    }

    static class ViewHolder {
        TextView tv_title;
        TextView tv_content;
    }

    class LoadDataThread extends Thread {
        @Override
        public void run() {
            initData();
            try {
                Thread.sleep(2000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
    }
}
