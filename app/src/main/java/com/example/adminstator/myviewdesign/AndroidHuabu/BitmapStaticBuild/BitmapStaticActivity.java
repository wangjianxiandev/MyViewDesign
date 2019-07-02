
package com.example.adminstator.myviewdesign.AndroidHuabu.BitmapStaticBuild;

import android.graphics.Bitmap;
import android.graphics.Color;
import android.media.Image;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;

import com.example.adminstator.myviewdesign.R;

public class BitmapStaticActivity extends AppCompatActivity {

    private ImageView imageView;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bitmap_static);
        imageView = (ImageView)findViewById(R.id.bitmap);
        createBmpByColors();

    }
    private int[] initColors(int width, int height){
        int[] colors = new int[width * height];
        //根据width和height遍历每个像素，生成argb值
        for(int y = 0;y<height;y++){
            for(int x = 0;x < width;x++){
                int r = x * 255 / (width - 1);
                int g = y * 255 / (width - 1);
                int b = 255 - Math.min(r,g);
                int a = Math.max(r,g);
                colors[y * width + x] = Color.argb(a,r,g,b);
            }
        }
        return colors;
    }

    private void createBmpByColors(){
        int width = 300, height = 200;
        int[] colors = initColors(width, height);
        Bitmap bitmap = Bitmap.createBitmap(colors, width, height, Bitmap.Config.ARGB_8888);
        imageView.setImageBitmap(bitmap);
    }



}
