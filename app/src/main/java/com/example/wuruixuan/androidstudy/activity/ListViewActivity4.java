package com.example.wuruixuan.androidstudy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ListView;
import android.widget.SimpleAdapter;

import com.example.wuruixuan.androidstudy.R;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListViewActivity4 extends AppCompatActivity {

    private ListView lv;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view4);
        lv = findViewById(R.id.listView);

        // 准备数据，每一个HashMap是一条记录
        HashMap<String, String> title1 = new HashMap<>();
        title1.put("title", "title-1");
        HashMap<String, String> title2 = new HashMap<>();
        title2.put("title", "title-2");
        HashMap<String, String> title3 = new HashMap<>();
        title3.put("title", "title-3");

        ArrayList<Map<String, String>> list = new ArrayList<>();
        list.add(title1);
        list.add(title2);
        list.add(title3);

        // 把数据填充到Adapter
        SimpleAdapter adapter = new SimpleAdapter(this, list, R.layout.list_item4, new String[]{"title"}, new int[]{R.id.textView_title});
        lv.setAdapter(adapter);
    }
}
