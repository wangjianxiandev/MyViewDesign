package com.example.adminstator.myviewdesign.AppbarTest;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;

import com.example.adminstator.myviewdesign.R;

public class AppbarTestActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_appbar_test);
        getWindow().getDecorView().setPadding(100, 100, 100, 100);
    }
}
