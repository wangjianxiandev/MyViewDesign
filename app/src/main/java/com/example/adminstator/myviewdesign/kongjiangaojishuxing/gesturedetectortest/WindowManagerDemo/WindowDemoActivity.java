package com.example.adminstator.myviewdesign.kongjiangaojishuxing.gesturedetectortest.WindowManagerDemo;

import android.content.Context;
import android.content.Intent;
import android.graphics.PixelFormat;
import android.os.Build;
import android.provider.Settings;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.ViewGroup;
import android.view.Window;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ImageView;

import com.example.adminstator.myviewdesign.R;

import de.hdodenhof.circleimageview.CircleImageView;

public class WindowDemoActivity extends AppCompatActivity implements View.OnTouchListener {

    private Button add_btn;
    private Button rem_btn;
    private CircleImageView imageView;
    private WindowManager.LayoutParams layoutParams;
    private WindowManager windowManager;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_window_demo);

        if(Build.VERSION.SDK_INT>=Build.VERSION_CODES.M){
            Intent intent = new Intent(Settings.ACTION_MANAGE_OVERLAY_PERMISSION);
            startActivityForResult(intent, 100);
        }
        add_btn = (Button)findViewById(R.id.add_btn);
        rem_btn = (Button)findViewById(R.id.rem_btn);
        windowManager = (WindowManager)getApplicationContext().getSystemService(Context.WINDOW_SERVICE);
        add_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                imageView = new CircleImageView(getApplicationContext());

                imageView.setImageResource(R.drawable.androidfirst);
                layoutParams = new WindowManager.LayoutParams(
                        WindowManager.LayoutParams.WRAP_CONTENT, WindowManager.LayoutParams.WRAP_CONTENT, 2099, WindowManager.LayoutParams.FLAG_NOT_TOUCH_MODAL
                        | WindowManager.LayoutParams.FLAG_NOT_FOCUSABLE
                        | WindowManager.LayoutParams.FLAG_SHOW_WHEN_LOCKED, PixelFormat.TRANSPARENT
                );
                layoutParams.type = WindowManager.LayoutParams.TYPE_SYSTEM_ERROR;
                layoutParams.gravity = Gravity.TOP | Gravity.LEFT;
                layoutParams.x = 0;
                layoutParams.y = 300;
                imageView.setOnTouchListener(WindowDemoActivity.this);
                windowManager.addView(imageView, layoutParams);
            }
        });
        rem_btn.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(imageView != null) {
                    windowManager.removeView(imageView);
                }
            }
        });
    }


    @Override
    public boolean onTouch(View v, MotionEvent event) {

        int rawX = (int) event.getRawX();
        int rawY = (int) event.getRawY();
        switch (event.getAction()){
            case MotionEvent.ACTION_MOVE:{
                layoutParams.x = rawX;
                layoutParams.y = rawY;
                windowManager.updateViewLayout(imageView, layoutParams);
                break;
            }
            default:
                break;
        }
        return false;
    }
}
