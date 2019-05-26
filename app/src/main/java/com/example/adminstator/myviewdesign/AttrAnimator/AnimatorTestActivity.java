package com.example.adminstator.myviewdesign.AttrAnimator;

import android.animation.ValueAnimator;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;

import com.example.adminstator.myviewdesign.R;

public class AnimatorTestActivity extends AppCompatActivity {
    private static final String TAG = "AnimatorTestActivity";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_test);
        final ValueAnimator valueAnimator = ValueAnimator.ofInt(0,400);
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (Integer)valueAnimator.getAnimatedValue();
                Log.d(TAG, "curValue"+curValue);
            }
        });
        valueAnimator.start();
    }
}
