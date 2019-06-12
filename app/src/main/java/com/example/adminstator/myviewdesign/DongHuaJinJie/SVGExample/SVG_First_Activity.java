package com.example.adminstator.myviewdesign.DongHuaJinJie.SVGExample;

import android.graphics.drawable.Animatable;
import android.support.graphics.drawable.AnimatedVectorDrawableCompat;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.adminstator.myviewdesign.R;

public class SVG_First_Activity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_svg__first_);
        imageView = (ImageView)findViewById(R.id.svg_first);
        AnimatedVectorDrawableCompat animatedVectorDrawableCompat = AnimatedVectorDrawableCompat.create(
                SVG_First_Activity.this, R.drawable.line_animator_vector
        );
        imageView.setImageDrawable(animatedVectorDrawableCompat);
        ((Animatable)imageView.getDrawable()).start();
    }
}
