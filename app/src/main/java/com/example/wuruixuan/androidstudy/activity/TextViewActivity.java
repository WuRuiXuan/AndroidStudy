package com.example.wuruixuan.androidstudy.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.TextView;

import com.example.wuruixuan.androidstudy.R;

public class TextViewActivity extends AppCompatActivity {

    private TextView textView1;
    private AutoCompleteTextView autoCompleteTextView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setText("google.com");

        autoCompleteTextView1 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.city_name, android.R.layout.simple_dropdown_item_1line);
        autoCompleteTextView1.setAdapter(adapter);
    }
}
