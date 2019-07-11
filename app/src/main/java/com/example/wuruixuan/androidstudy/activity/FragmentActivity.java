package com.example.wuruixuan.androidstudy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wuruixuan.androidstudy.R;

public class FragmentActivity extends AppCompatActivity {

    private TitleFragment fr_title;
    private ContentFragment fr_content;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment);
        // 通过FragmentManager(Fragment管理器)
        fr_title = (TitleFragment) getFragmentManager().findFragmentById(R.id.title_fragment);
        fr_content = (ContentFragment) getFragmentManager().findFragmentById(R.id.content_fragment);
    }
}
