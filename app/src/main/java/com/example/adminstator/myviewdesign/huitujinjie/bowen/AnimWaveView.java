package com.example.adminstator.myviewdesign.huitujinjie.bowen;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;
import android.view.animation.LinearInterpolator;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/17
 * Time: 9:56
 */
public class AnimWaveView extends View {
    private Paint paint;
    private Path path;
    private int mItemWaveLength = 1200;
    private int dx;
    public AnimWaveView(Context context, AttributeSet attrs) {
        super(context, attrs);
        path = new Path();
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.FILL);
        startAnim();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        path.reset();
        int originY = 300;
        int halfWaveLen = mItemWaveLength/2;
        //开始的时候向左移动一个波长
        path.moveTo(-mItemWaveLength+dx, originY);
        //在屏幕中画满波纹
        for(int i = -mItemWaveLength;i<=getWidth()+mItemWaveLength;i+=mItemWaveLength){
            //波纹的前一半
            path.rQuadTo(halfWaveLen/2, -100, halfWaveLen,0);
            //波纹的后一半
            path.rQuadTo(halfWaveLen/2,100, halfWaveLen,  0);
        }
        path.lineTo(getWidth(), getHeight());
        path.lineTo(0, getHeight());
        path.close();
        canvas.drawPath(path, paint);
    }

    public void startAnim(){
        final ValueAnimator valueAnimator = ValueAnimator.ofInt(0, mItemWaveLength);
        valueAnimator.setDuration(2000);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setInterpolator(new LinearInterpolator());
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                dx = (int) valueAnimator.getAnimatedValue();
                postInvalidate();
            }
        });
        valueAnimator.start();
    }
}
