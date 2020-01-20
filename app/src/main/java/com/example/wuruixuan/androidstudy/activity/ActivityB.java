package com.example.wuruixuan.androidstudy.activity;

import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ArrayAdapter;
import android.widget.EditText;
import android.widget.ListView;
import android.widget.TextView;

import com.example.wuruixuan.androidstudy.R;
import com.example.wuruixuan.androidstudy.activity.classes.Cat;
import com.example.wuruixuan.androidstudy.activity.classes.Dog;

public class ActivityB extends AppCompatActivity {

    private TextView tv_info;
    private ListView lv;

    final String[] numbers = {"17474749174", "13838389438", "18944447777", "13295279527", "13548694869"};

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_b);

        tv_info = findViewById(R.id.info);
        lv = findViewById(R.id.listView);

        ArrayAdapter<String> adapter = new ArrayAdapter<String>(this, android.R.layout.simple_list_item_1, android.R.id.text1, numbers);
        lv.setAdapter(adapter);
        lv.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                String number = numbers[position];
                Intent intent = new Intent();
                intent.putExtra("number", number); // 设置返回结果
                setResult(RESULT_OK, intent);
                finish();// 结束当前界面
            }
        });

        Intent intent = getIntent();
        if (intent.getBundleExtra("data") != null) {
            Bundle data = intent.getBundleExtra("data");
            String info = data.getString("info");
            tv_info.setText(info);
        }
        else if (intent.getStringExtra("info") != null) {
            String info = intent.getStringExtra("info");
            int age = intent.getIntExtra("age", 18); // 第二个参数为取不到时的默认值
            tv_info.setText(info + "-" + age);
        }
        else if (intent.getSerializableExtra("cat") != null) {
            Cat cat = (Cat) intent.getSerializableExtra("cat");
            tv_info.setText(cat.toString());
        }
        else if (intent.getParcelableExtra("dog") != null) {
            Dog dog = (Dog) intent.getParcelableExtra("dog");
            tv_info.setText(dog.toString());
        }
    }


}
