package com.example.wuruixuan.androidstudy;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class ImageViewActivity extends AppCompatActivity {

    private ImageView imageView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_image_view);

        imageView = (ImageView) findViewById(R.id.imageView1);

        imageView.setScaleType(ImageView.ScaleType.FIT_CENTER);
    }
}
