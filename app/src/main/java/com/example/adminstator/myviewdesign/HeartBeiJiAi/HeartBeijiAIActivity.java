package com.example.adminstator.myviewdesign.HeartBeiJiAi;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.adminstator.myviewdesign.R;

public class HeartBeijiAIActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_heart_beiji_ai);
        HeartBaseView heartBaseView = findViewById(R.id.heart);
        ((HeartBeiJiAiTest) heartBaseView).start();
    }
}
