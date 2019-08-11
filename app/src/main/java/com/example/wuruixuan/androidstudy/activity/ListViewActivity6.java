package com.example.wuruixuan.androidstudy.activity;

import android.os.Handler;
import android.os.Message;
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
    private MyAdapter myAdapter;
    private MyHandler handler; // 线程之间通讯的机制
    private final static int DATA_UPDATE = 0x1; // 数据更新完成后的标记

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view6);
        lv = findViewById(R.id.listView);
        lv.setOnScrollListener(this);
        initData();
        myAdapter = new MyAdapter();
        lv.setAdapter(myAdapter);
        handler = new MyHandler(myAdapter);
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

    private int visibleLastIndex; // 用来可显示的最后一条数据的索引
    @Override
    public void onScrollStateChanged(AbsListView view, int scrollState) {
        if (myAdapter.getCount() == visibleLastIndex && scrollState == AbsListView.OnScrollListener.SCROLL_STATE_IDLE) {
            new LoadDataThread().start();
        }
    }

    @Override
    public void onScroll(AbsListView absListView, int firstVisibleItem, int visibleItemCount, int totalItemCount) {
        visibleLastIndex = firstVisibleItem + visibleItemCount - 1;
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

    static class MyHandler extends Handler {
        private MyAdapter adapter;

        private MyHandler(MyAdapter myAdapter) {
            super();
            this.adapter = myAdapter;
        }

        @Override
        public void handleMessage(Message msg) {
            switch (msg.what) {
                case DATA_UPDATE:
                    adapter.notifyDataSetChanged();
                    break;
            }
        }
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
//            adapter.notifyDataSetChanged();
            // 通过handler给主线程发送一个消息标记
            handler.sendEmptyMessage(DATA_UPDATE);
        }
    }
}
