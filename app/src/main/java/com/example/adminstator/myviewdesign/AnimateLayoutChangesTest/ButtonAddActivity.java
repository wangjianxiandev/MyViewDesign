package com.example.adminstator.myviewdesign.AnimateLayoutChangesTest;

import android.animation.LayoutTransition;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.ViewGroup;
import android.widget.Button;
import android.widget.LinearLayout;

import com.example.adminstator.myviewdesign.R;

public class ButtonAddActivity extends AppCompatActivity {
    private static final String TAG = "ButtonAddActivity";
    private Button add;
    private Button remove;
    private LinearLayout linearLayout;
    private int i = 0;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_button_add);
        add = (Button)findViewById(R.id.button_add);
        remove = (Button)findViewById(R.id.button_remove);
        linearLayout =  (LinearLayout)findViewById(R.id.linearlayoutcontainer);
        //创建layoutTransition对象
        LayoutTransition layoutTransition = new LayoutTransition();
        //创建动画
        ObjectAnimator objectAnimator = ObjectAnimator.ofFloat(null,"rotationY", 0f, 360f, 0f);
        //设置动画
        layoutTransition.setAnimator(LayoutTransition.APPEARING, objectAnimator);

        ObjectAnimator objectAnimator1 = ObjectAnimator.ofFloat(null, "rotation", 0f, 90f, 0f);
        layoutTransition.setAnimator(LayoutTransition.DISAPPEARING, objectAnimator1);
        //将动画加到ViewGroup中
        linearLayout.setLayoutTransition(layoutTransition);
        layoutTransition.addTransitionListener(new LayoutTransition.TransitionListener() {
            @Override
            public void startTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {
                System.out.println("start" + view.getClass().getName());
            }

            @Override
            public void endTransition(LayoutTransition transition, ViewGroup container, View view, int transitionType) {
                System.out.println("end" + view.getClass().getName());
            }
        });

        add.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                i++;
                Button button = new Button(ButtonAddActivity.this);
                button.setText("Button" + i);
                LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT);
                button.setLayoutParams(params);
                linearLayout.addView(button, 0);
            }
        });
        remove.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(i>0){
                    linearLayout.removeViewAt(0);
                    i--;
                }
            }
        });
    }
}
