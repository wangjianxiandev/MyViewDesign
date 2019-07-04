package com.example.adminstator.myviewdesign.Juzhenyunsuan;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.ColorMatrix;
import android.graphics.ColorMatrixColorFilter;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.example.adminstator.myviewdesign.R;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/07/04
 * Time: 18:12
 */
public class MyMatrixColorView extends View {
    private Paint paint;
    private Bitmap bitmap;
    public MyMatrixColorView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setAntiAlias(true);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
//        canvas.drawBitmap(bitmap, null, new Rect(0, 0, 500, 500* bitmap.getHeight() / bitmap.getWidth()), paint);
//        canvas.translate(510, 0);
//        ColorMatrix colorMatrix = new ColorMatrix(new float[]{
//                1/2f, 1/2f, 1/2f, 0,  0,
//                1/3f, 1/3f, 1/3f, 0, 0,
//                1/4f, 1/4f, 1/4f, 0, 0,
//                0,0,0,1,0,
//        });
//        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
//        canvas.drawBitmap(bitmap, null, new Rect(0, 0, 500, 500 * bitmap.getHeight()/bitmap.getWidth()), paint);
        canvas.drawBitmap(bitmap, null, new Rect(0, 0,500,500 * bitmap.getHeight() / bitmap.getWidth()), paint);
        canvas.save();
        canvas.translate(510, 0);
//生成色彩变换矩阵
        ColorMatrix colorMatrix =  new ColorMatrix();
        colorMatrix.setScale(1, 1.3f, 1,1);
        paint.setColorFilter(new ColorMatrixColorFilter(colorMatrix));
                canvas.drawBitmap(bitmap, null, new Rect(0, 0, 500, 500 * bitmap.getHeight()/ bitmap.getWidth()), paint);
    }
}
