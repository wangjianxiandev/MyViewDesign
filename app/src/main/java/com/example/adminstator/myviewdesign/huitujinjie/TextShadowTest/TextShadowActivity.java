package com.example.adminstator.myviewdesign.huitujinjie.TextShadowTest;

import android.graphics.Color;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.TextView;

import com.example.adminstator.myviewdesign.R;

public class TextShadowActivity extends AppCompatActivity {
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_text_shadow);
        textView = (TextView)findViewById(R.id.shadow_text);
        textView.setShadowLayer(3, 5, 5, Color.GRAY);
    }
}
