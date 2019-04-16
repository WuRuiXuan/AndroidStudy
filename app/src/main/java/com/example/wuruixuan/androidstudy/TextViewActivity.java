package com.example.wuruixuan.androidstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Editable;
import android.text.TextWatcher;
import android.view.KeyEvent;
import android.widget.ArrayAdapter;
import android.widget.AutoCompleteTextView;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

public class TextViewActivity extends AppCompatActivity {

    private TextView textView1;
    private EditText editText1;
    private AutoCompleteTextView autoCompleteTextView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_view);

        textView1 = (TextView)findViewById(R.id.textView1);
        textView1.setText("codingke.com");

        editText1 = (EditText)findViewById(R.id.editText1);
        // 监听输入变化
        editText1.addTextChangedListener(new TextWatcher() {
            @Override
            public void beforeTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                System.out.println("beforeTextChanged--" + charSequence);
            }

            @Override
            public void onTextChanged(CharSequence charSequence, int i, int i1, int i2) {
                System.out.println("onTextChanged--" + charSequence);
            }

            @Override
            public void afterTextChanged(Editable editable) {
                System.out.println("afterTextChanged--" + editable.toString());
            }
        });
        // 监听回车键
        editText1.setOnEditorActionListener(new TextView.OnEditorActionListener() {
            @Override
            public boolean onEditorAction(TextView textView, int i, KeyEvent keyEvent) {
                Toast.makeText(TextViewActivity.this, textView.getText().toString(), Toast.LENGTH_SHORT).show();
                return true;
            }
        });

        autoCompleteTextView1 = (AutoCompleteTextView) findViewById(R.id.autoCompleteTextView1);
        ArrayAdapter adapter = ArrayAdapter.createFromResource(this, R.array.city_name, android.R.layout.simple_dropdown_item_1line);
        autoCompleteTextView1.setAdapter(adapter);
    }
}
