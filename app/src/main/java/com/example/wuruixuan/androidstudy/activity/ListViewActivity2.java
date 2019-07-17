package com.example.wuruixuan.androidstudy.activity;

import android.app.ListActivity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.ListView;
import android.widget.TextView;
import android.widget.Toast;

import com.example.wuruixuan.androidstudy.R;

public class ListViewActivity2 extends ListActivity { // 默认全屏ListView，不需要设置布局

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        ArrayAdapter<CharSequence> arrayAdapter = ArrayAdapter.createFromResource(this, R.array.name,
                android.R.layout.simple_list_item_1);
        setListAdapter(arrayAdapter);
    }

    @Override
    protected void onListItemClick(ListView l, View v, int position, long id) {
        Toast.makeText(this, ((TextView) v).getText(), Toast.LENGTH_SHORT).show();
    }
}
