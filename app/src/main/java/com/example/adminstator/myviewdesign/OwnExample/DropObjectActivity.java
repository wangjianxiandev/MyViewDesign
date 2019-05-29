package com.example.adminstator.myviewdesign.OwnExample;

import android.animation.ValueAnimator;
import android.graphics.Point;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adminstator.myviewdesign.R;

public class DropObjectActivity extends AppCompatActivity {

    private Button button;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drop_object);
        button = (Button)findViewById(R.id.start_anim);
        imageView = (ImageView)findViewById(R.id.ball_img);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                doAnimStart();
            }
        });
    }

    private void doAnimStart() {
        final ValueAnimator valueAnimator = ValueAnimator.ofObject(new FallingBallEvaluator(), new Point(0, 0), new Point(500, 500));
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                Point curValue = (Point) valueAnimator.getAnimatedValue();
                imageView.layout(curValue.x, curValue.y, curValue.x+imageView.getWidth(), curValue.y+imageView.getHeight());
            }
        });
        valueAnimator.setDuration(1000);
        valueAnimator.start();
    }
}
