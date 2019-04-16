package com.example.wuruixuan.androidstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

public class ButtonActivity extends AppCompatActivity implements View.OnClickListener {

    private Button b1, b2, b3;
    private Button b4;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button);

        b1 = (Button) findViewById(R.id.button1);
        b2 = (Button) findViewById(R.id.button2);
        b3 = (Button) findViewById(R.id.button3);
        b4 = (Button) findViewById(R.id.button4);

        b1.setOnClickListener(this);
        b2.setOnClickListener(this);
        b3.setOnClickListener(this);
        b4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                Toast.makeText(ButtonActivity.this, "button--4", Toast.LENGTH_SHORT).show();
            }
        });
    }

    public void click1(View view) {
        Toast.makeText(this, "button--1", Toast.LENGTH_SHORT).show();
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()) {
            case R.id.button1:
            {
                Toast.makeText(this, "button--1", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.button2:
            {
                Toast.makeText(this, "button--2", Toast.LENGTH_SHORT).show();
            }
            break;
            case R.id.button3:
            {
                Toast.makeText(this, "button--3", Toast.LENGTH_SHORT).show();
            }
            break;
            default:
        }
    }


}
