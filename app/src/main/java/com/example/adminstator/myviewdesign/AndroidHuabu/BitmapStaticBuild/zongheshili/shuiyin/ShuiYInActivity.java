package com.example.adminstator.myviewdesign.AndroidHuabu.BitmapStaticBuild.zongheshili.shuiyin;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.adminstator.myviewdesign.R;

public class ShuiYInActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shui_yin);
        imageView = (ImageView)findViewById(R.id.shuiyin);
        Bitmap src = BitmapFactory.decodeResource(getResources(),R.drawable.scenery);
        Bitmap waterBmp = BitmapFactory.decodeResource(getResources(), R.drawable.watermark);
        Bitmap result = createWaterBitmap(src, waterBmp);
        imageView.setImageBitmap(result);
    }

    private Bitmap createWaterBitmap(Bitmap src, Bitmap waterBmp) {
        if(src == null){
            return null;
        }
        int width = src.getWidth();
        int height = src.getHeight();
        int wWidth = waterBmp.getWidth();
        int wHeight = waterBmp.getHeight();
        Bitmap newBmp = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(newBmp);
        canvas.drawBitmap(src, 0, 0, null);
        canvas.drawBitmap(waterBmp, width-wWidth+5, height - wHeight+5, null);
        return newBmp;
    }
}
