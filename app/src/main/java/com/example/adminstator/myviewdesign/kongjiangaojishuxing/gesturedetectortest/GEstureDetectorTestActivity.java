package com.example.adminstator.myviewdesign.kongjiangaojishuxing.gesturedetectortest;

import android.app.Activity;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.GestureDetector;
import android.view.MotionEvent;
import android.view.View;
import android.widget.TextView;

import com.example.adminstator.myviewdesign.R;

public class GEstureDetectorTestActivity extends Activity implements View.OnTouchListener {

    private TextView textView;
    private GestureDetector gestureDetector;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_gesture_detector_test);
        gestureDetector = new GestureDetector(new gestureListener());
        gestureDetector.setOnDoubleTapListener(new doubleTapListener());
        textView = (TextView)findViewById(R.id.tv_gesture);
        textView.setOnTouchListener(GEstureDetectorTestActivity.this);
        textView.setFocusable(true);
        textView.setClickable(true);
        textView.setLongClickable(true);
    }

    @Override
    public boolean onTouch(View v, MotionEvent event) {
        return gestureDetector.onTouchEvent(event);
    }

    private class gestureListener implements GestureDetector.OnGestureListener{

        @Override
        public boolean onDown(MotionEvent e) {
            System.out.println("onDown");
            return true;
        }

        @Override
        public void onShowPress(MotionEvent e) {
            System.out.println("onShowPress");
        }

        @Override
        public boolean onSingleTapUp(MotionEvent e) {
            System.out.println("onSingleTapUp");
            return true;
        }

        @Override
        public boolean onScroll(MotionEvent e1, MotionEvent e2, float distanceX, float distanceY) {
            System.out.println("onScroll");
            return true;
        }

        @Override
        public void onLongPress(MotionEvent e) {
            System.out.println("onLongPress");
        }

        @Override
        public boolean onFling(MotionEvent e1, MotionEvent e2, float velocityX, float velocityY) {
            System.out.println("onFling");
            return true;
        }
    }
    private class doubleTapListener implements GestureDetector.OnDoubleTapListener{

        @Override
        public boolean onSingleTapConfirmed(MotionEvent e) {
            System.out.println("onSimgleTapConfirmed");
            return true;
        }

        @Override
        public boolean onDoubleTap(MotionEvent e) {
            System.out.println("onDoubleTap");
            return true;
        }

        @Override
        public boolean onDoubleTapEvent(MotionEvent e) {
            //结果0表示ACTION_DOWN, 1表示ACTION_UP, 2表示ACTION_MOVE
            System.out.println("onDoubleTapEvent" + e.getAction());
            return true;
        }
    }
}
