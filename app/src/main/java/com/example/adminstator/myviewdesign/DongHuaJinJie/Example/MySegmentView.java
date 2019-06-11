package com.example.adminstator.myviewdesign.DongHuaJinJie.Example;

import android.animation.ValueAnimator;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;

import com.example.adminstator.myviewdesign.R;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/09
 * Time: 15:25
 */
public class MySegmentView extends View {
    private Paint paint;
    private Path dstPath;
    private Path circlePath;
    private PathMeasure pathMeasure;
    private float mCurAnimValue;

    private Bitmap bitmap;
    private float[] pos = new float[2];
    private float[] tan = new float[2];
    public MySegmentView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE ,null);
//        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.arraw);


        paint = new Paint(Paint.ANTI_ALIAS_FLAG);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(4);
        paint.setColor(Color.BLACK);

        dstPath = new Path();
        circlePath = new Path();
        circlePath.addCircle(100, 100, 50, Path.Direction.CW);

        pathMeasure = new PathMeasure(circlePath, true);
        ValueAnimator animator = ValueAnimator.ofFloat(0, 1);
        animator.setRepeatCount(ValueAnimator.INFINITE);
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mCurAnimValue  = (Float)animation.getAnimatedValue();
                invalidate();
            }
        });
        animator.setDuration(2000);
        animator.start();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        float length = pathMeasure.getLength();
        float stop  = pathMeasure.getLength() * mCurAnimValue;
        //当进度小于0.5时start=0, 进度大于0.5时，start  = 2 * value - 1
        float start = (float) (stop - ((0.5 - Math.abs(mCurAnimValue - 0.5))*length));
        //清空之前生成的路径
        dstPath.reset();
        pathMeasure.getSegment(0, stop, dstPath, true);


        //返回该点的坐标和对应单位圆上的坐标
        pathMeasure.getPosTan(stop, pos, tan);
        //根据返回的x,y的坐标，返回对应的弧度值计算对应的角度值
        float degrees = (float) (Math.atan2(tan[1], tan[0]) * 180.0 /Math.PI);

//        Matrix matrix = new Matrix();
//        matrix.postRotate(degrees, bitmap.getWidth()/2, bitmap.getHeight()/2);
//        matrix.postTranslate(pos[0] - bitmap.getWidth()/2, pos[1] - bitmap.getHeight()/2);
//        canvas.drawPath(dstPath, paint);
//        canvas.drawBitmap(bitmap, matrix, paint);
    }
}