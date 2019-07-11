package com.example.wuruixuan.androidstudy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.wuruixuan.androidstudy.R;

public class FragmentActivity3 extends AppCompatActivity implements MenuFragment.MyMenuListener {

    private MenuFragment fr_menu;
    private MainFragment fr_main;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_fragment3);
        fr_menu = (MenuFragment) getFragmentManager().findFragmentById(R.id.menu_fragment);
        fr_main = (MainFragment) getFragmentManager().findFragmentById(R.id.main_fragment);
    }

    @Override
    public void changeValue(String value) {
        fr_main.changeTextViewValue(value);
    }
}
