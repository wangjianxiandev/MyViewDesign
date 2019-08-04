package com.example.adminstator.myviewdesign.SweepGradientTest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.RectF;
import android.graphics.SweepGradient;
import android.util.AttributeSet;
import android.util.TypedValue;
import android.view.View;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/07/16
 * Time: 22:02
 */
public class SweepGradientDemo extends View {
    public SweepGradientDemo(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public SweepGradientDemo(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    public SweepGradientDemo(Context context, AttributeSet attrs, int defStyleAttr, int defStyleRes) {
        super(context, attrs, defStyleAttr, defStyleRes);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint  = new Paint();
        paint.setColor(Color.GREEN);
        paint.setStrokeWidth(15);
        paint.setAntiAlias(true);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeCap(Paint.Cap.ROUND);

        SweepGradient sweepGradient = new SweepGradient((getMeasuredWidth() - 40)/2, (getMeasuredHeight() - 40)/2, new int[]{Color.RED, Color.GREEN, Color.BLUE}, null);
        Matrix matrix = new Matrix();
        matrix.setRotate(180, getMeasuredWidth()/2, getMeasuredHeight()/2);
        sweepGradient.setLocalMatrix(matrix);
        paint.setShader(sweepGradient);
        RectF rectF = new RectF(20, 20, getMeasuredWidth() - 20, getMeasuredHeight() - 20);
        canvas.drawArc(rectF, 0, 360, false, paint);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        setMeasuredDimension((int) TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 240, getResources().getDisplayMetrics()),
                (int)TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, 240, getResources().getDisplayMetrics()));
    }
}
