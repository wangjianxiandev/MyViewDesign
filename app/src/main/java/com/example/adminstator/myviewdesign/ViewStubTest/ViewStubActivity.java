package com.example.adminstator.myviewdesign.ViewStubTest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.view.ViewStub;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.adminstator.myviewdesign.R;

public class ViewStubActivity extends AppCompatActivity {

    private ViewStub viewStub;
    private Button buttonText;
    private Button buttonImage;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_view_stub);
        buttonText = findViewById(R.id.show_text);
        buttonImage  = findViewById(R.id.show_image);
        buttonText.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewStub textStub = findViewById(R.id.view_stub_text);
//                textStub.inflate();
                textStub.setVisibility(View.VISIBLE);
                TextView textView = findViewById(R.id.view_stub_textview);
                textView.setText("niuniu");
            }
        });
        buttonImage.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ViewStub imageStub = findViewById(R.id.view_stub_image);
                imageStub.inflate();
                ImageView imageView = findViewById(R.id.view_stub_imageview);
                Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.niuniu);
                imageView.setImageBitmap(bitmap);
            }
        });
    }
}
