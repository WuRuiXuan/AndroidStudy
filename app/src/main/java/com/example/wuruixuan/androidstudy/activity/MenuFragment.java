package com.example.wuruixuan.androidstudy.activity;


import android.app.Activity;
import android.content.Context;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;

import com.example.wuruixuan.androidstudy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class MenuFragment extends Fragment implements View.OnClickListener {

    private MyMenuListener myMenuListener;
    private Button bt_news, bt_musics;

    public MenuFragment() {
        // Required empty public constructor
    }

    @Override
    public void onAttach(Activity activity) {
        super.onAttach(activity);
        myMenuListener = (MyMenuListener) activity;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_menu, container, false);
        bt_news = view.findViewById(R.id.button_news);
        bt_musics = view.findViewById(R.id.button_musics);
        bt_news.setOnClickListener(this);
        bt_musics.setOnClickListener(this);
        return view;
    }

    // 定义一个回调接口
    public static interface MyMenuListener {
        public void changeValue(String value);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button_news:
                myMenuListener.changeValue("news");
                break;
            case R.id.button_musics:
                myMenuListener.changeValue("musics");
                break;
        }
    }
}
