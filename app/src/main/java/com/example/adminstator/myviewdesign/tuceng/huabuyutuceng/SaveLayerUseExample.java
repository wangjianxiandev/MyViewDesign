package com.example.adminstator.myviewdesign.tuceng.huabuyutuceng;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

import com.example.adminstator.myviewdesign.R;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/25
 * Time: 13:14
 */
public class SaveLayerUseExample extends View {
    private Paint paint;
    private Bitmap bitmap;
    public SaveLayerUseExample(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        paint.setColor(Color.RED);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.dog);

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        int layerId = canvas.saveLayerAlpha(0, 0, 200, 200, 100, Canvas.ALL_SAVE_FLAG);
//        //将新建的图层水平斜切45度，在进行绘画一个矩形,但是只是对新建的画布产生影响，并不会对原有的画布有影响
//        canvas.skew(1.732f, 0);
//        canvas.drawRect(0, 0, 150, 160, paint);
//        //将新的画布画到原始的画布上
        canvas.drawColor(Color.GRAY);

        canvas.restoreToCount(layerId);

    }
}
