package com.example.adminstator.myviewdesign.tuceng;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/24
 * Time: 20:09
 */
public class BitmapCanvasView extends View {
    private Bitmap bitmap;
    private Paint paint;
    private Canvas bitmapCanvas;
    public BitmapCanvasView(Context context,AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        bitmap = Bitmap.createBitmap(500, 500, Bitmap.Config.ARGB_8888);
        bitmapCanvas = new Canvas(bitmap);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setTextSize(50);
        //将文字卸载了bitmap上并没有将图片画在画布上，所以此时什么都不会有
        bitmapCanvas.drawText("Wjx", 0,  100, paint);
       //将bitmap显示出来
        canvas.drawBitmap(bitmap,0, 0, paint);
    }
}
