package com.example.adminstator.myviewdesign.AnimatorSetTest;

import android.animation.Animator;
import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.TextView;

import com.example.adminstator.myviewdesign.R;

public class ZuheDonghuaActivity extends AppCompatActivity {

    private Button button;
    private TextView textView1;
    private TextView textView2;
    private Button button1;
    private AnimatorSet myAnimatorSet;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_zuhe_donghua);
        button = (Button)findViewById(R.id.start_set);
        button1 = (Button)findViewById(R.id.cancel);
        textView1 = (TextView)findViewById(R.id.textview1);
        textView2 = (TextView)findViewById(R.id.textview2);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAnimatorSet = doAnimator();
            }
        });
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                myAnimatorSet.cancel();
            }
        });
    }

    private AnimatorSet doAnimator() {
        ObjectAnimator objectAnimator1 = ObjectAnimator.ofInt(textView1,"BackgroundColor", 0xffff00ff, 0xffffff00,0xffff00ff);
        ObjectAnimator objectAnimator2 = ObjectAnimator.ofFloat(textView1,"translationY",0 , 300, 0);
        //延时2秒，循环无穷次
        objectAnimator2.setStartDelay(2000);
        objectAnimator2.setDuration(2000000);
        objectAnimator2.setInterpolator(new BounceInterpolator());
        objectAnimator2.setRepeatCount(ValueAnimator.INFINITE);
        ObjectAnimator objectAnimator3 = ObjectAnimator.ofFloat(textView2, "translationY", 0, 400, 0);
        objectAnimator3.setStartDelay(2000);
        AnimatorSet animatorSet = new AnimatorSet();
//        animatorSet.playSequentially(objectAnimator1, objectAnimator2, objectAnimator3);
//        animatorSet.setDuration(2000);

//        animatorSet.start();
        AnimatorSet.Builder builder = animatorSet.play(objectAnimator1);
        animatorSet.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                System.out.println("start");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                System.out.println("end");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                System.out.println("cancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                System.out.println("repeat");
            }
        });
        builder.with(objectAnimator2);
        builder.after(objectAnimator3);
        animatorSet.setDuration(1000);
        animatorSet.start();
        return animatorSet;
    }
}
