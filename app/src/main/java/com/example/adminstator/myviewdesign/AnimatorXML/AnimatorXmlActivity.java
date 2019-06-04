package com.example.adminstator.myviewdesign.AnimatorXML;

import android.animation.AnimatorInflater;
import android.animation.ValueAnimator;
import android.os.TestLooperManager;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.adminstator.myviewdesign.R;

public class AnimatorXmlActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_animator_xml);
        button = (Button)findViewById(R.id.move_text_xml);
        textView = (TextView)findViewById(R.id.text_xml);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                final ValueAnimator valueAnimator = (ValueAnimator) AnimatorInflater.loadAnimator(AnimatorXmlActivity.this, R.animator.animator);
                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValue  = (int) valueAnimator.getAnimatedValue();
                        textView.layout(0, curValue+button.getHeight(), textView.getWidth(), button.getHeight()+textView.getHeight()+curValue);
                    }
                });
                valueAnimator.start();
            }
        });

    }
}
