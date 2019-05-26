package com.example.adminstator.myviewdesign.InterpolatorOwn;

import android.animation.IntEvaluator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.adminstator.myviewdesign.R;

public class MyInterpolatorActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_interpolator);
        button = (Button)findViewById(R.id.myInterpolatormove_text);
        textView = (TextView)findViewById(R.id.myInterpolatortext_click);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ValueAnimator valueAnimator = ValueAnimator.ofInt(0,400);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curvalue = (int) valueAnimator.getAnimatedValue();
                        textView.layout(0, curvalue+button.getHeight(),textView.getWidth(), curvalue+textView.getHeight()+button.getHeight());
                    }
                });
                valueAnimator.setDuration(3000);
                valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
                valueAnimator.setRepeatMode(ValueAnimator.RESTART);
                valueAnimator.setEvaluator(new ReserveEvaluator());
                valueAnimator.setInterpolator(new MyInterpolator());
                valueAnimator.start();
            }
        });
    }

}
