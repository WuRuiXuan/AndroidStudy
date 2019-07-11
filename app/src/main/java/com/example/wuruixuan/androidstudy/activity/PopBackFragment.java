package com.example.wuruixuan.androidstudy.activity;


import android.annotation.SuppressLint;
import android.os.Bundle;
import android.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.TextView;

import com.example.wuruixuan.androidstudy.R;

/**
 * A simple {@link Fragment} subclass.
 */
public class PopBackFragment extends Fragment {

//    private String title;

    public PopBackFragment() {
        // Required empty public constructor
    }

//    public PopBackFragment(String title) {
//        this.title = title;
//    }

    // Fragment的传参方法
    public static PopBackFragment getInstance(String title) {
        PopBackFragment p = new PopBackFragment();
        Bundle b = new Bundle();
        b.putString("title", title);
        p.setArguments(b);
        return p;
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        View view = inflater.inflate(R.layout.fragment_pop_back, container, false);
        TextView tv = (TextView) view.findViewById(R.id.textView_text);
        tv.setText(getArguments().getString("title"));
        return view;
    }

}
