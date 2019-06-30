package com.example.adminstator.myviewdesign.AndroidHuabu.BitmapSuoFang;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.adminstator.myviewdesign.R;

public class BitmapSuoFangActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_suo_fang);
        imageView = (ImageView)findViewById(R.id.iv);
        Bitmap bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.niuniuya);
        System.out.println(bitmap.getWidth()+" "+bitmap.getHeight()+" "+bitmap.getByteCount());
        BitmapFactory.Options options = new BitmapFactory.Options();
        options.inScaled = false;
        Bitmap bmp = BitmapFactory.decodeResource(getResources(),R.drawable.niuniuya,options);
        System.out.println(bmp.getWidth()+" "+bmp.getHeight()+" "+bmp.getByteCount());
        options.inScaled = true;
        options.inDensity = 1;
        options.inTargetDensity = 2;
        Bitmap bmp1 = BitmapFactory.decodeResource(getResources(), R.drawable.niuniuya, options);
        System.out.println(bmp1.getWidth()+" "+bmp1.getHeight()+" "+bmp1.getByteCount());
        options.inPreferredConfig = Bitmap.Config.RGB_565;
        Bitmap bmp2 = BitmapFactory.decodeResource(getResources(), R.drawable.niuniuya, options);
        System.out.println(bmp2.getWidth()+" "+bmp2.getHeight()+" "+bmp2.getByteCount());

    }
}
