package com.example.adminstator.myviewdesign.PropertyValuesHolderTest.ViewPropertyAnimatorTest;

import android.animation.Animator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.adminstator.myviewdesign.R;

import java.util.concurrent.TimeoutException;

public class TestByActivity extends AppCompatActivity {

    private Button button;
    private TextView tv1;
    private TextView tv2;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_test_by);
        button = (Button)findViewById(R.id.start_vp);
        tv1 = (TextView)findViewById(R.id.tv1);
        tv2 = (TextView)findViewById(R.id.tv2);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //只能放大到2，之后不在变化
                tv1.animate().scaleY(2);
                //每次放大增加2，每次都会发生变化
                tv2.animate().scaleYBy(2).setListener(new Animator.AnimatorListener() {
                    @Override
                    public void onAnimationStart(Animator animation) {

                    }

                    @Override
                    public void onAnimationEnd(Animator animation) {

                    }

                    @Override
                    public void onAnimationCancel(Animator animation) {

                    }

                    @Override
                    public void onAnimationRepeat(Animator animation) {

                    }
                });
            }
        });
    }
}
