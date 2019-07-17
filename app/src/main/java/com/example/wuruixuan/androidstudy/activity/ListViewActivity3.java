package com.example.wuruixuan.androidstudy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.ListView;

import com.example.wuruixuan.androidstudy.R;

public class ListViewActivity3 extends AppCompatActivity {

    private ListView lv1;
    private ListView lv2;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_list_view3);
        lv1 = findViewById(R.id.listView1);
        lv2 = findViewById(R.id.listView2);

        String[] names = getResources().getStringArray(R.array.name);
        // 单选模式
        ArrayAdapter<String> arrayAdapter1 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_single_choice, names);
        lv1.setChoiceMode(ListView.CHOICE_MODE_SINGLE);
        lv1.setAdapter(arrayAdapter1);
        // 多选模式
        ArrayAdapter<String> arrayAdapter2 = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_multiple_choice, names);
        lv2.setChoiceMode(ListView.CHOICE_MODE_MULTIPLE);
        lv2.setAdapter(arrayAdapter2);
    }
}
