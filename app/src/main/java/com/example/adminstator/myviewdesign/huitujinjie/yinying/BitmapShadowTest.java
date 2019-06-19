package com.example.adminstator.myviewdesign.huitujinjie.yinying;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
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
 * @date: 2019/06/18
 * Time: 17:51
 */
public class BitmapShadowTest extends View {
    private Paint paint;
    private Bitmap bitmap;
    private Bitmap alphaBitmap;
    public BitmapShadowTest(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        paint = new Paint();
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.circle3);
        //新建一个Alpha值相同的副本
        alphaBitmap = bitmap.extractAlpha();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = 200;
        int height = width * alphaBitmap.getWidth()/alphaBitmap.getHeight();
        //绘制灰色阴影
        paint.setColor(Color.GRAY);
        paint.setMaskFilter(new BlurMaskFilter(10,BlurMaskFilter.Blur.NORMAL));
        canvas.drawBitmap(alphaBitmap, null, new Rect(10, 10,  width, height),paint);
        //绘制黑色阴影


        //首先将画布左移，这样可以露出阴影的一部分
        canvas.translate(-5,-5);
        //将发光指控，否则画出来的图像也具有内外发光
        paint.setMaskFilter(null);
        //画出原图像
        canvas.drawBitmap(bitmap, null, new Rect(0, 0, width, height), paint);

//        canvas.translate(width, 0);
//        paint.setColor(Color.BLACK);
//        canvas.drawBitmap(alphaBitmap, null, new Rect(10, 10, width, height), paint);

    }
}
