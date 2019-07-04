package com.example.adminstator.myviewdesign.Juzhenyunsuan;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.widget.ImageView;
import android.widget.SeekBar;

import com.example.adminstator.myviewdesign.R;

public class MatrixActivity extends AppCompatActivity {

    private ImageView imageView;
    private SeekBar seekBar;
    private Bitmap bitmap;
    private Bitmap tempBitmap;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_matrix);
        imageView = (ImageView) findViewById(R.id.image_bitmap);
        seekBar = (SeekBar)findViewById(R.id.seekbar);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
        tempBitmap = Bitmap.createBitmap(bitmap.getWidth(), bitmap.getHeight(), Bitmap.Config.ARGB_8888);
        seekBar.setOnSeekBarChangeListener(new SeekBar.OnSeekBarChangeListener() {
            @Override
            public void onProgressChanged(SeekBar seekBar, int progress, boolean fromUser) {
                Bitmap bitmap1 = handleColorMatrixBmp(progress);
                imageView.setImageBitmap(bitmap1);
            }

            @Override
            public void onStartTrackingTouch(SeekBar seekBar) {

            }

            @Override
            public void onStopTrackingTouch(SeekBar seekBar) {

            }
        });
    }

    private Bitmap handleColorMatrixBmp(int progress) {
        //创建一个相同尺寸的可变长的位图去，用于绘制调色后的图片
        Canvas canvas = new Canvas(tempBitmap);
        Paint paint = new Paint();
        ColorMatrix colorMatrix = new ColorMatrix();
        colorMatrix.setSaturation(progress);
        colorMatrix.setRotate(0, progress-180);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return tempBitmap;
    }
}
