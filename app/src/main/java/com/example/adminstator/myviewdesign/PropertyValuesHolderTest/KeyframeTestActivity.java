package com.example.adminstator.myviewdesign.PropertyValuesHolderTest;

import android.animation.Keyframe;
import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.BounceInterpolator;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adminstator.myviewdesign.AttrAnimator.CharEvaluator;
import com.example.adminstator.myviewdesign.R;

public class KeyframeTestActivity extends AppCompatActivity {

    private ImageView imageView;
    private Button button;
    private Button button1;
    private MyTextView myTextView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_keyframe_test);
        imageView = (ImageView)findViewById(R.id.phone);
        button = (Button)findViewById(R.id.keychange);
        button1 = (Button)findViewById(R.id.OfObjectButton);
        myTextView = (MyTextView) findViewById(R.id.mytextVIew);
        button1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                Keyframe frame0 = Keyframe.ofObject(0f, new Character('A'));
                Keyframe frame1 = Keyframe.ofObject(0.1f, new Character('L'));
                Keyframe frame2 = Keyframe.ofObject(1, new Character('Z'));
                PropertyValuesHolder frameHolder = PropertyValuesHolder.ofKeyframe("CharText", frame0, frame1,frame2);
                frameHolder.setEvaluator(new CharEvaluator());
                ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(myTextView, frameHolder);
                objectAnimator.setDuration(3000);
                objectAnimator.start();
            }
        });
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                keyMove();
            }
        });
    }
    public void keyMove(){
        Keyframe frame0 = Keyframe.ofFloat(0f, 0);
        Keyframe frame1 = Keyframe.ofFloat(0.1f, -20f);
        Keyframe frame2 = Keyframe.ofFloat(0.2f, 20f);
        Keyframe frame3 = Keyframe.ofFloat(0.3f, -20f);
        Keyframe frame4 = Keyframe.ofFloat(0.4f, 20f);
        Keyframe frame5 = Keyframe.ofFloat(0.5f, -20f);
        Keyframe frame6 = Keyframe.ofFloat(0.6f, 20f);
        Keyframe frame7 = Keyframe.ofFloat(0.7f, -20f);
        Keyframe frame8 = Keyframe.ofFloat(0.8f, 20f);
        Keyframe frame9 = Keyframe.ofFloat(0.9f, -20f);
        Keyframe frame10 = Keyframe.ofFloat(1);
        frame10.setValue(0);
        frame5.setInterpolator(new BounceInterpolator());
        PropertyValuesHolder rotationFrameHolder = PropertyValuesHolder.ofKeyframe("rotation", frame0, frame1,frame2,frame3,frame4,frame5,frame6,frame7,frame8,frame9,frame10);

        Keyframe scaleXFrame0 = Keyframe.ofFloat(0f,1);
        Keyframe scaleXFrame1 = Keyframe.ofFloat(0.1f,1.1f);
        Keyframe scaleXFrame9 = Keyframe.ofFloat(0.9f,1.1f);
        Keyframe scaleXFrame10 = Keyframe.ofFloat(1,1);
        PropertyValuesHolder scaleFrameHolder1 = PropertyValuesHolder.ofKeyframe("ScaleX", scaleXFrame0, scaleXFrame1,scaleXFrame9,scaleXFrame10);

        Keyframe scaleYFrame0 = Keyframe.ofFloat(0f, 1);
        Keyframe scaleYFrame1 = Keyframe.ofFloat(0.1f, 1.1f);
        Keyframe scaleYFrame9 = Keyframe.ofFloat(0.9f, 1.1f);
        Keyframe scaleYFrame10 = Keyframe.ofFloat(1, 1);
        PropertyValuesHolder scaleFrameHolder2 = PropertyValuesHolder.ofKeyframe("ScaleY",scaleYFrame0, scaleYFrame1,scaleYFrame9,scaleYFrame10);


        ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(imageView, rotationFrameHolder, scaleFrameHolder1,scaleFrameHolder2);
        objectAnimator.setDuration(3000);
        objectAnimator.start();

    }
}
