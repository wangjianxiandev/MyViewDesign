package com.example.adminstator.myviewdesign.DrawableBitmapTranslate;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.Drawable;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.adminstator.myviewdesign.R;

public class DrawableBitmapActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_drawable_bitmap);
        imageView = findViewById(R.id.bitmap_drawable);
//        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.niuniu);
//        Drawable bitmapDrawable = new BitmapDrawable(bitmap);
//        imageView.setBackground(bitmapDrawable);
//        Bitmap bitmap
        Drawable drawable = getResources().getDrawable(R.drawable.rotation);
        Bitmap bitmap = DrawableToBitmap(drawable);
        imageView.setImageBitmap(bitmap);
    }

    private Bitmap DrawableToBitmap(Drawable drawable){
        Bitmap bitmap = null;
        int width = drawable.getIntrinsicWidth();
        int height = drawable.getIntrinsicHeight();
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        drawable.setBounds(0, 0, width, height);
        drawable.draw(canvas);
        return bitmap;
    }
}
