package com.example.adminstator.myviewdesign.PropertyValuesHolderTest;

import android.animation.ObjectAnimator;
import android.animation.PropertyValuesHolder;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import com.example.adminstator.myviewdesign.R;

public class PropertyActivity extends AppCompatActivity {

    private Button button;
    private TextView textView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_property);
        button = (Button)findViewById(R.id.pro_bn);
        textView = (TextView)findViewById(R.id.pro_text);
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                PropertyValuesHolder propertyValuesHolder = PropertyValuesHolder.ofFloat("Rotation",60f, -60f);
                PropertyValuesHolder propertyValuesHolder1 = PropertyValuesHolder.ofFloat("alpha", 0.1f, 1f);
                ObjectAnimator objectAnimator = ObjectAnimator.ofPropertyValuesHolder(textView, propertyValuesHolder, propertyValuesHolder1);
                objectAnimator.setDuration(100);
                objectAnimator.start();
            }
        });
    }
}
