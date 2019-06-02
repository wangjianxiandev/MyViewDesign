package com.example.adminstator.myviewdesign.OwnExample;

import android.animation.ObjectAnimator;
import android.animation.TypeEvaluator;
import android.animation.ValueAnimator;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.example.adminstator.myviewdesign.R;

public class ObjectAnimatorFallActivity extends AppCompatActivity {

    private FallingBallImageView fallingBallImageView;
    private Button button;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_object_animator_fall);
        fallingBallImageView = (FallingBallImageView)findViewById(R.id.ball_img);
        button = (Button)findViewById(R.id.start_fall);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAnimation();
            }
        });
    }

    private void doAnimation() {
        ObjectAnimator objectAnimator = ObjectAnimator.ofObject(fallingBallImageView, "fallingPos", new FallingBallEvaluator(), new Point(0,0), new Point(500,500));
        objectAnimator.setDuration(1000);
        objectAnimator.start();
    }
}
