package com.example.wuruixuan.androidstudy.activity;


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
public class MainFragment extends Fragment {

    private TextView tv_value;

    public MainFragment() {
        // Required empty public constructor
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container,
                             Bundle savedInstanceState) {
        // Inflate the layout for this fragment
        View view = inflater.inflate(R.layout.fragment_main, container, false);
        tv_value = view.findViewById(R.id.textView_value);
        return view;
    }

    public void changeTextViewValue(String value) {
        tv_value.setText(value);
    }
}
