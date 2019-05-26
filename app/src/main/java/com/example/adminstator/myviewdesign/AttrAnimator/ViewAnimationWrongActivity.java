package com.example.adminstator.myviewdesign.AttrAnimator;

import android.animation.Animator;
import android.animation.ValueAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.DecelerateInterpolator;
import android.view.animation.LinearInterpolator;
import android.view.animation.TranslateAnimation;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminstator.myviewdesign.R;


//correct
public class ViewAnimationWrongActivity extends AppCompatActivity {
    private Button button;
    private TextView textView;
    private Button button1;
    final ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 400);
    private static final String TAG = "ViewAnimationWrongActiv";
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_animation_wrong);
        button = (Button)findViewById(R.id.move_text);
        button1 = (Button)findViewById(R.id.clone);
        textView = (TextView)findViewById(R.id.text_click);

        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //使用视图动画但是会发现控件移动后无法点击，但是可以点击原来的位置
//                TranslateAnimation translateAnimation = new TranslateAnimation(Animation.ABSOLUTE, 0, Animation.ABSOLUTE,0,Animation.ABSOLUTE, 0, Animation.ABSOLUTE,400);
//                translateAnimation.setDuration(1000);
//                translateAnimation.setFillAfter(true);
//                textView.startAnimation(translateAnimation);
                doAnimation();
            }
        });

        textView.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Toast.makeText(ViewAnimationWrongActivity.this, textView.getText(), Toast.LENGTH_SHORT).show();
                valueAnimator.cancel();
            }
        });

        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //克隆出一个新的属性动画
                valueAnimator.setDuration(1000);
                valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
                valueAnimator.setRepeatMode(ValueAnimator.REVERSE);

                valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValue = (int) valueAnimator.getAnimatedValue();
                        textView.layout(0, curValue+button.getHeight(), textView.getWidth(), curValue+button.getHeight()+textView.getHeight());
                    }

                });
                final ValueAnimator valueAnimator1 = valueAnimator.clone();
                valueAnimator1.setStartDelay(1000);
                valueAnimator1.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
                    @Override
                    public void onAnimationUpdate(ValueAnimator animation) {
                        int curValueClone = (int) valueAnimator1.getAnimatedValue();
                        textView.layout(0,curValueClone+button.getHeight()+button1.getHeight(), textView.getWidth(), curValueClone+button1.getHeight()+button.getHeight()+textView.getHeight());
                    }
                });
                //因为属性等话并不作用于控件上，所以只需要自己启动，并将动画和他的动作进行绑定即可
                valueAnimator1.start();
            }
        });


    }



    private void doAnimation(){

        valueAnimator.setDuration(1000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int curValue = (int) valueAnimator.getAnimatedValue();
                textView.layout(0, curValue+button.getHeight(), textView.getWidth(), curValue+button.getHeight()+textView.getHeight());
            }

        });

        //添加执行情况的监听器
        valueAnimator.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {
                Log.d(TAG, "Start");
            }

            @Override
            public void onAnimationEnd(Animator animation) {
                Log.d(TAG, "End");
            }

            @Override
            public void onAnimationCancel(Animator animation) {
                Log.d(TAG, "Cancel");
            }

            @Override
            public void onAnimationRepeat(Animator animation) {
                Log.d(TAG, "Repeat");
            }
        });
//        启动前将监听器全部都删除掉
//        valueAnimator.removeAllListeners();
        valueAnimator.start();
    }


}
