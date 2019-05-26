package com.example.adminstator.myviewdesign.ViewAnimation;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;

import com.example.adminstator.myviewdesign.R;

public class MainActivity extends AppCompatActivity {
    private TextView textView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        button = (Button) findViewById(R.id.btn);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                textView = (TextView) findViewById(R.id.text);
                //加载缩放动画
                ScaleAnimation scaleanimation = (ScaleAnimation) AnimationUtils.loadAnimation(MainActivity.this, R.anim.scaleanim);
                //加载透明度动画
                AlphaAnimation alphaanimation = (AlphaAnimation) AnimationUtils.loadAnimation(MainActivity.this, R.anim.alphaanim);
                //加载旋转动画
                RotateAnimation rotateanimation= (RotateAnimation) AnimationUtils.loadAnimation(MainActivity.this, R.anim.rotateanimation);
                //加载平移动画
                TranslateAnimation translateAnimation = (TranslateAnimation) AnimationUtils.loadAnimation(MainActivity.this, R.anim.translateanim);
                //加载组合动画
                Animation setanimation = AnimationUtils.loadAnimation(MainActivity.this, R.anim.setanimation);
                //开始动画
//                textView.startAnimation(scaleanimation);
//                textView.startAnimation(alphaanimation);
//                textView.startAnimation(rotateanimation);
//                textView.startAnimation(translateAnimation);
                textView.startAnimation(setanimation);
            }
        });
    }
}
