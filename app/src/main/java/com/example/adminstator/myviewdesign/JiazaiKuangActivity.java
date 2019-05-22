package com.example.adminstator.myviewdesign;

import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.animation.Animation;
import android.view.animation.LinearInterpolator;
import android.view.animation.RotateAnimation;
import android.widget.ImageView;

public class JiazaiKuangActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_jiazai_kuang);
        imageView = (ImageView)findViewById(R.id.routeImage);
        RotateAnimation rotateAnimation = new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
        rotateAnimation.setDuration(2000);
        rotateAnimation.setInterpolator(new LinearInterpolator());
        imageView.startAnimation(rotateAnimation);

    }
}
