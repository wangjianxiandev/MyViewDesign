package com.example.adminstator.myviewdesign.hunhemoshi.TwitterDemo;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.util.AttributeSet;
import android.view.View;

import com.example.adminstator.myviewdesign.R;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/20
 * Time: 16:48
 */
public class TeitterView extends View {
    private Paint bitPaint;
    private Bitmap BmpDst, BmpSrc;
    public TeitterView(Context context, AttributeSet attrs) {
        super(context, attrs);
        bitPaint = new Paint();
        BmpDst = BitmapFactory.decodeResource(getResources(), R.drawable.twiter_bg, null);
        BmpSrc = BitmapFactory.decodeResource(getResources(), R.drawable.twiter_light, null);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //新建图层
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(BmpDst, 0, 0, bitPaint);
        bitPaint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.MULTIPLY));
        canvas.drawBitmap(BmpSrc, 0, 0, bitPaint);
        bitPaint.setXfermode(null);
        //还原图层
        canvas.restoreToCount(layerId);
    }
}
