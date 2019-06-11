package com.example.adminstator.myviewdesign.DongHuaJinJie;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PathMeasure;
import android.util.AttributeSet;
import android.view.View;

import com.example.adminstator.myviewdesign.PaintDesign.PaintTest;

/**
 * Created with Android Studio.
 * Description:
 * User: wjx
 * Date: 2019-06-09
 * Time: 13:59
 */
public class PathMeasureDesign extends View {
    private Paint paint;
    private PathMeasure pathMeasure;
    private PathMeasure pathMeasure1;
    private Path path;
    public PathMeasureDesign(Context context,  AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public void init(){
        paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(8);
        path = new Path();
        pathMeasure = new PathMeasure();
        pathMeasure1  = new PathMeasure();
    }
    @Override
    protected void onDraw(Canvas canvas) {
        setLayerType(LAYER_TYPE_SOFTWARE , null);
        super.onDraw(canvas);
        canvas.translate(100, 100);
        path.addRect(-50,-50, 50, 50, Path.Direction.CW);
        Path dst = new Path();
        dst.lineTo(10, 100);
        pathMeasure.setPath(path,false);
        pathMeasure.getSegment(0, 150, dst, false);
        canvas.drawPath(dst, paint);
    }
}
