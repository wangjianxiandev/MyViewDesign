package com.example.adminstator.myviewdesign;

import android.graphics.drawable.AnimationDrawable;
import android.graphics.drawable.Drawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

public class DongTaiZhenActivity extends AppCompatActivity {
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_dong_tai_zhen);
        imageView = (ImageView)findViewById(R.id.dongtaiImage);
        AnimationDrawable animationDrawable = new AnimationDrawable();
        for(int i = 1;i<=14;i++){
            int id = getResources().getIdentifier("list_icon_gif_playing" + i, "drawable", getPackageName());
            Drawable drawable = getResources().getDrawable(id);
            animationDrawable.addFrame(drawable, 60);

        }
        animationDrawable.setOneShot(false);
        imageView.setBackground(animationDrawable);
        animationDrawable.start();
    }
}
