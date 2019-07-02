package com.example.adminstator.myviewdesign.AndroidHuabu.BitmapStaticBuild.zongheshili;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.adminstator.myviewdesign.R;

public class StrokeImageActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_stroke_image);
        imageView = (ImageView)findViewById(R.id.stroke);
    }
}
