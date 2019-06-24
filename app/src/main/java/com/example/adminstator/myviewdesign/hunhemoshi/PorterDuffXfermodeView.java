package com.example.adminstator.myviewdesign.hunhemoshi;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/20
 * Time: 15:09
 */
public class PorterDuffXfermodeView extends View {
    private int width = 200;
    private int height = 200;
    private Bitmap dstBmp;
    private Bitmap srcBmp;
    private Paint paint;
    public PorterDuffXfermodeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        dstBmp = makeDst(width, height);
        srcBmp = makeSrc(width, height);
        paint = new Paint();
    }
    private Bitmap makeDst(int w, int h){
        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);
        //画一张空白的图片，然后再图片上画一个黄色的圆形，中间有一个圆形的位图，除圆形以外其他都是空白像素
        p.setColor(0xFFFFCC44);
        canvas.drawOval(new RectF(0, 0, w, h), p);
        return bm;
    }

    private Bitmap makeSrc(int w, int h){
        Bitmap bm = Bitmap.createBitmap(w, h, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bm);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

        p.setColor(0xFF66AAFF);
        canvas.drawRect(0, 0, w,h, p);
        return bm;
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int layId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(dstBmp, 0, 0, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_ATOP));
        canvas.drawBitmap(srcBmp, width/2, height/2, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(layId);
    }
}
