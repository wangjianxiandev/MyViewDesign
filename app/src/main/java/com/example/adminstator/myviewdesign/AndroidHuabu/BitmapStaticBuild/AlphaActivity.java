package com.example.adminstator.myviewdesign.AndroidHuabu.BitmapStaticBuild;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.adminstator.myviewdesign.R;

public class AlphaActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_alpha);
        imageView = (ImageView)findViewById(R.id.alpha);
        imageView = (ImageView)findViewById(R.id.alpha);
        Bitmap srcBmp = BitmapFactory.decodeResource(getResources(), R.drawable.cat_dog);
        Paint paint = new Paint();
        BlurMaskFilter blurMaskFilter = new BlurMaskFilter(6, BlurMaskFilter.Blur.NORMAL);
        paint.setMaskFilter(blurMaskFilter);
        int[] offsetXY = new int[2];
        Bitmap alphabitmap = srcBmp.extractAlpha(paint, offsetXY);
        Bitmap bitmap = Bitmap.createBitmap(alphabitmap.getWidth(), alphabitmap.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        paint.setColor(Color.GRAY);
        canvas.drawBitmap(alphabitmap, 0, 0, paint);
        canvas.drawBitmap(srcBmp, -offsetXY[0], -offsetXY[1], null);
        imageView.setImageBitmap(bitmap);
        srcBmp.recycle();

    }
}
