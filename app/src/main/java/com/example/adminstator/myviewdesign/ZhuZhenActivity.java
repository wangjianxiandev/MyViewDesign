package com.example.adminstator.myviewdesign;

import android.graphics.drawable.AnimationDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class ZhuZhenActivity extends AppCompatActivity {
    private ImageView imageView;
    private Button buttonstart;
    private Button buttonend;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zhu_zhen);
        imageView = (ImageView)  findViewById(R.id.frame_image);
        buttonstart = (Button)findViewById(R.id.startframe);
        buttonend = (Button)findViewById(R.id.endframe);

        final AnimationDrawable animationDrawable = (AnimationDrawable)imageView.getBackground();
        buttonstart.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.start();
            }
        });
        buttonend.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                animationDrawable.stop();
            }
        });
    }
}
