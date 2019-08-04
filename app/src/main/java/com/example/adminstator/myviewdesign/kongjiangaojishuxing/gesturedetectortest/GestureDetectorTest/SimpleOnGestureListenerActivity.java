package com.example.adminstator.myviewdesign.kongjiangaojishuxing.gesturedetectortest.GestureDetectorTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;
import android.widget.Toast;

import com.example.adminstator.myviewdesign.R;

public class SimpleOnGestureListenerActivity extends AppCompatActivity implements View.OnTouchListener {

    private GestureDetector gestureDetector;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_simple_on_gesture_listener);
        gestureDetector = new GestureDetector(new simpleGestureListener());
        textView = (TextView)findViewById(R.id.tv_simple_gesture);
        textView.setOnTouchListener(this::onTouch);
        textView.setFocusable(true);
        textView.setClickable(true);
        textView.setLongClickable(true);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class simpleGestureListener extends GestureDetector.SimpleOnGestureListener{
        final int FLING_MIN_DISTANCE = 100;
        final int FLING_MIN_VELOCITY = 100;

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            if(e1.getX() - e2.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX) > FLING_MIN_VELOCITY){
                Toast.makeText(SimpleOnGestureListenerActivity.this, "Left", Toast.LENGTH_SHORT).show();
            }else if(e2.getX() - e1.getX() > FLING_MIN_DISTANCE && Math.abs(velocityX)>FLING_MIN_VELOCITY){
                Toast.makeText(SimpleOnGestureListenerActivity.this, "Right", Toast.LENGTH_SHORT).show();
            }
            return true;
        }
    }
}
