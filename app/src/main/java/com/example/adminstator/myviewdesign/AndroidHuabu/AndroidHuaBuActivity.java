package com.example.adminstator.myviewdesign.AndroidHuabu;

import android.graphics.drawable.GradientDrawable;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.adminstator.myviewdesign.R;

public class AndroidHuaBuActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_android_hua_bu);
        button = (Button)findViewById(R.id.add_shape_corner);
        textView = (TextView)findViewById(R.id.shape_tv);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                //通过textView的getBackground获得shape标签
                GradientDrawable gradientDrawable = (GradientDrawable)textView.getBackground();
                gradientDrawable.setCornerRadius(20);
            }
        });

    }
}
