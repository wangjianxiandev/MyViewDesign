package com.example.adminstator.myviewdesign.CircleImageViewTest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.adminstator.myviewdesign.R;

import de.hdodenhof.circleimageview.CircleImageView;

/**
 * 使用circleImageView实现圆形头像
 */
public class CircleImageViewTestActivity extends AppCompatActivity {

    private CircleImageView circleImageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_circle_image_view_test);
        circleImageView = (CircleImageView)findViewById(R.id.circle_image);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.androidfirst);
        circleImageView.setImageBitmap(bitmap);
//        circleImageView.setImageResource(R.drawable.androidfirst);
    }
}
