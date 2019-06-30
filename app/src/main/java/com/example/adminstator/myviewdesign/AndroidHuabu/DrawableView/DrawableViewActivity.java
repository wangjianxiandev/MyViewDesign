package com.example.adminstator.myviewdesign.AndroidHuabu.DrawableView;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.adminstator.myviewdesign.R;

public class DrawableViewActivity extends AppCompatActivity {

    private ImageView imageView;
    private CustomDrawable customDrawable;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_view);
        imageView = (ImageView)findViewById(R.id.img);
        textView = (TextView)findViewById(R.id.tv);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.niuniu);
        customDrawable = new CustomDrawable(bitmap);
        imageView.setImageDrawable(customDrawable);
        textView.setBackground(customDrawable);
    }

}
