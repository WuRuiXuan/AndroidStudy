package com.example.wuruixuan.androidstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.CompoundButton;
import android.widget.Switch;
import android.widget.ToggleButton;

public class ToggleButtonActivity extends AppCompatActivity {

    private ToggleButton toggleButton1;
    private Switch aSwitch1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_toggle_button);

        toggleButton1 = (ToggleButton) findViewById(R.id.toggleButton1);
        aSwitch1 = (Switch) findViewById(R.id.switch1);

        aSwitch1.setOnCheckedChangeListener(new CompoundButton.OnCheckedChangeListener() {
            @Override
            public void onCheckedChanged(CompoundButton compoundButton, boolean b) {

            }
        });
    }
}
