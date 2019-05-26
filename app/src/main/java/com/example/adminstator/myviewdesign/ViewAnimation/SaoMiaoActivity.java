package com.example.adminstator.myviewdesign.ViewAnimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adminstator.myviewdesign.R;

public class SaoMiaoActivity extends AppCompatActivity {
    private ImageView imageView1;
    private ImageView imageView2;
    private ImageView imageView3;
    private ImageView imageView4;
    private TextView textView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sao_miao);
        imageView1 = (ImageView)findViewById(R.id.circle1);
        imageView2 = (ImageView)findViewById(R.id.circle2);
        imageView3 = (ImageView)findViewById(R.id.circle3);
        imageView4 = (ImageView)findViewById(R.id.circle4);
        textView = (TextView)findViewById(R.id.start_can);
        final Animation animation1 = AnimationUtils.loadAnimation(SaoMiaoActivity.this, R.anim.scale_alpha_anim);
        final Animation animation2 = AnimationUtils.loadAnimation(SaoMiaoActivity.this, R.anim.scale_alpha_anim);
        final Animation animation3 = AnimationUtils.loadAnimation(SaoMiaoActivity.this, R.anim.scale_alpha_anim);
        final Animation animation4 = AnimationUtils.loadAnimation(SaoMiaoActivity.this, R.anim.scale_alpha_anim);

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView1.startAnimation(animation1);
                animation2.setStartOffset(600);
                imageView2.startAnimation(animation2);
                animation3.setStartOffset(1200);
                imageView3.startAnimation(animation3);
                animation4.setStartOffset(1800);
                imageView4.startAnimation(animation4);
            }
        });
    }
}
