package com.example.adminstator.myviewdesign.AttrAnimator;

import android.animation.ArgbEvaluator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.AccelerateInterpolator;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;


import com.example.adminstator.myviewdesign.R;

public class ArgbEvaluatorActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_argb_evaluator);
        button = (Button)findViewById(R.id.argb_color);
        textView = (TextView)findViewById(R.id.change_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                doAnimator();
                doChangeLetter();
            }
        });
        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ArgbEvaluatorActivity.this, "wjx", Toast.LENGTH_SHORT).show();
            }
        });
    }

    private void doChangeLetter() {
        final ValueAnimator valueAnimator = ValueAnimator.ofObject(new CharEvaluator(), new Character('A'), new Character('Z'));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                char text = (Character)valueAnimator.getAnimatedValue();
                textView.setText(String.valueOf(text));
            }
        });
        valueAnimator.setDuration(10000);
        valueAnimator.setInterpolator(new AccelerateInterpolator());
        valueAnimator.start();
    }


    private void doAnimator(){
        final ValueAnimator valueAnimator = ValueAnimator.ofInt(0xffffff00, 0xff0000ff);
        valueAnimator.setEvaluator(new ArgbEvaluator());
        valueAnimator.setDuration(1000);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) valueAnimator.getAnimatedValue();
                textView.setBackgroundColor(curValue);
            }
        });
        valueAnimator.start();
    }
}
