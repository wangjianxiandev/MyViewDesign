package com.example.adminstator.myviewdesign;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.AlphaAnimation;
import android.view.animation.Animation;
import android.view.animation.AnimationSet;
import android.view.animation.RotateAnimation;
import android.view.animation.ScaleAnimation;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class ScaleActivity extends AppCompatActivity {
    private static final String TAG = "ScaleActivity";
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {

        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_scale);
        button = (Button) findViewById(R.id.btn_scale);
        textView = (TextView) findViewById(R.id.scale_text);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ScaleAnimation scaleAnimation = new ScaleAnimation(0.0f, 1.4f, 0.0f, 1.4f, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
                scaleAnimation.setRepeatCount(2);
                scaleAnimation.setDuration(700);
                textView.startAnimation(scaleAnimation);
                scaleAnimation.setAnimationListener(new Animation.AnimationListener() {
                    @Override
                    public void onAnimationStart(Animation animation) {
                        Log.d("ScaleActivity", "onAnimationStart");
                    }

                    @Override
                    public void onAnimationEnd(Animation animation) {
                        Log.d("ScaleActivity", "onAnimationEnd");
                    }

                    @Override
                    public void onAnimationRepeat(Animation animation) {
                        Log.d("ScaleActivity", "onAnimationRepeat");
                    }
                });


//                AlphaAnimation alphaAnimation = new AlphaAnimation(0.0f, 1.0f);
//                alphaAnimation.setDuration(700);
//                textView.startAnimation(alphaAnimation);
//
//                RotateAnimation rotateAnimation = new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF, 0.5f);
//                rotateAnimation.setDuration(700);
//                textView.startAnimation(rotateAnimation);
//
//                TranslateAnimation translateAnimation = new TranslateAnimation(0, 0, 80, 80);
//                translateAnimation.setDuration(700);
//                translateAnimation.setFillBefore(true);
//                textView.startAnimation(translateAnimation);


//                Animation scale_Anim = new ScaleAnimation(0.0f, 1.4f,0.0f,1.4f, Animation.RELATIVE_TO_SELF,0.5f, Animation.RELATIVE_TO_SELF,0.5f);
//                Animation alpha_Anim = new AlphaAnimation(0.0f, 1.0f);
//                Animation rotate_Anim = new RotateAnimation(0, 720, Animation.RELATIVE_TO_SELF, 0.5f, Animation.RELATIVE_TO_SELF,0.5f);
//                Animation tran_Anim = new TranslateAnimation(Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,-80, Animation.RELATIVE_TO_SELF,0, Animation.RELATIVE_TO_SELF,-80);
//                AnimationSet animationSet = new AnimationSet(true);
//                animationSet.addAnimation(scale_Anim);
//                animationSet.addAnimation(alpha_Anim);
//                animationSet.addAnimation(rotate_Anim);
////                animationSet.addAnimation(tran_Anim);
//                animationSet.setDuration(3000);
//                animationSet.setFillAfter(true);
//                textView.startAnimation(animationSet);


            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ScaleActivity.this, "wjx", Toast.LENGTH_SHORT).show();
            }
        });
    }
}
