package com.example.adminstator.myviewdesign.DongHuaJinJie.zhifubao;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/11
 * Time: 17:33
 */
public class AliPayView extends View {
    private Path mDstPath;
    private Path mCirclePath;
    private PathMeasure pathMeasure;
    private float currentValue;
    private int mCentx = 100;
    private int mCenty = 100;
    private int mRadius = 50;
    private boolean next = false;
    private Paint paint;
    public void init(){
        mCirclePath = new Path();
        mDstPath = new Path();
        pathMeasure = new PathMeasure();
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStrokeWidth(8);
        paint.setStyle(Paint.Style.STROKE);
    }
    public AliPayView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        init();
        mCirclePath.addCircle(mCentx, mCenty, mRadius, Path.Direction.CW);
        mCirclePath.moveTo(mCentx - mRadius / 2, mCenty);
        mCirclePath.lineTo(mCentx, mCenty + mRadius / 2);
        mCirclePath.lineTo(mCentx + mRadius / 2, mCenty - mRadius / 3);
        pathMeasure.setPath(mCirclePath,false);

        ValueAnimator valueAnimator = ValueAnimator.ofFloat(0, 2);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                currentValue = (Float)animation.getAnimatedValue();
                invalidate();
            }
        });
        valueAnimator.setDuration(3000);
        valueAnimator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        if(currentValue < 1){
            float stop = pathMeasure.getLength() * currentValue;
            pathMeasure.getSegment(0, stop, mDstPath, true);
        }else{
            if(!next){
                next = true;
                pathMeasure.getSegment(0, pathMeasure.getLength(), mDstPath, true);
                pathMeasure.nextContour();
            }
            float stop = pathMeasure.getLength() * (currentValue - 1);
            pathMeasure.getSegment(0, stop, mDstPath, true);
        }
        canvas.drawPath(mDstPath,paint);
    }
}
