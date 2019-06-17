package com.example.adminstator.myviewdesign.DongHuaJinJie.SVGExample;

import android.graphics.drawable.Animatable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;

import com.example.adminstator.myviewdesign.R;

public class SearchVectorActivity extends AppCompatActivity {

    private EditText editText;
    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_search_vector);
        editText = (EditText)findViewById(R.id.edit);
        imageView = (ImageView)findViewById(R.id.anim_img);
        //将焦点放到imageView上
        imageView.setFocusable(true);
        imageView.setFocusableInTouchMode(true);
        imageView.requestFocus();
        imageView.requestFocusFromTouch();
        editText.setOnFocusChangeListener(new View.OnFocusChangeListener() {
            @Override
            public void onFocusChange(View v, boolean hasFocus) {
                AnimatedVectorDrawableCompat animatedVectorDrawableCompat = AnimatedVectorDrawableCompat.create(
                        SearchVectorActivity.this, R.drawable.animated_vector_search
                );
                imageView.setImageDrawable(animatedVectorDrawableCompat);
                ((Animatable)imageView.getDrawable()).start();
            }
        });
    }
}
