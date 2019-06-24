package com.example.adminstator.myviewdesign.hunhemoshi.mubiaotuxiangmoshi;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.renderscript.Sampler;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

import com.example.adminstator.myviewdesign.R;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/23
 * Time: 9:27
 */
public class TextWave_Design extends View {
    private Paint paint;
    private Path path;
    private int mItemWaveLength = 1000;
    private int dx;
    private Bitmap bitmapSrc, bitmapDst;
    public TextWave_Design(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        path = new Path();
        paint.setColor(Color.GREEN);
        paint.setStyle(Paint.Style.FILL_AND_STROKE);

        bitmapSrc = BitmapFactory.decodeResource(getResources(), R.drawable.text_shade);
        bitmapDst = Bitmap.createBitmap(bitmapSrc.getWidth(), bitmapSrc.getHeight(),Bitmap.Config.ARGB_8888);
        startAnim();

    }

    private void startAnim() {
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, mItemWaveLength);
        valueAnimator.setDuration(2000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        valueAnimator.start();

    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        generageWavePath();
        Canvas c = new Canvas(bitmapDst);
        c.drawColor(Color.BLACK, PorterDuff.Mode.CLEAR);
        c.drawPath(path, paint);
        canvas.drawBitmap(bitmapSrc, 0, 0, paint);
        int layerId = canvas.saveLayer(0, 0,  getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.drawBitmap(bitmapDst, 0, 0 , paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_IN));
        canvas.drawBitmap(bitmapSrc, 0, 0, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }

    private void generageWavePath() {
        path.reset();
        int originY = bitmapSrc.getHeight() / 2;
        int halfWaveLen =  mItemWaveLength / 2;
        path.moveTo(-mItemWaveLength+dx, originY);
        for(int i = -mItemWaveLength;i<=getHeight()+mItemWaveLength;i+=mItemWaveLength){
            path.rQuadTo(halfWaveLen/2,-50, halfWaveLen, 0);
            path.rQuadTo(halfWaveLen/2, 50, halfWaveLen,0);
        }
        path.lineTo(bitmapSrc.getWidth(), bitmapSrc.getHeight());
        path.lineTo(0, bitmapSrc.getHeight());
        path.close();
    }
}
