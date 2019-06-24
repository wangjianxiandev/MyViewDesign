package com.example.adminstator.myviewdesign.tuceng.tucengyuhuabu;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.adminstator.myviewdesign.tuceng.BitmapCanvasView;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/24
 * Time: 20:26
 */
public class XferModeView extends View {
    private int width = 400;
    private int height = 400;
    private Bitmap dstBitmap;
    private Bitmap srcBitmap;
    private Paint paint;
    public XferModeView(Context context,AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        paint = new Paint();
        paint.setColor(Color.BLACK);
        dstBitmap = makeDst(width, height);
        srcBitmap = makeSrc(width, height);
    }

    /**
     * 创建一张矩形图片
     * @param width
     * @param height
     * @return
     */
    static Bitmap makeSrc(int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bitmap);
        Paint paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setColor(0xFF66AAFF);
        c.drawRect(0, 0, width, height,paint);
        return bitmap;
    }

    /**
     * 创建一张圆形图片
     * @param width
     * @param height
     * @return
     */
    static Bitmap makeDst(int width, int height) {
        Bitmap bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas c = new Canvas(bitmap);
        Paint p = new Paint(Paint.ANTI_ALIAS_FLAG);

        p.setColor(0xFFFFCC44);
        c.drawOval(new RectF(0, 0 ,width, height), p);
        return bitmap;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.GREEN);
//        int layerId = canvas.saveLayer(0, 0, width * 2, height * 2, paint, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(dstBitmap, 0, 0 ,paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(srcBitmap, width/2, height/2, paint);
        paint.setXfermode(null);
//        canvas.restoreToCount(layerId);
    }
}
