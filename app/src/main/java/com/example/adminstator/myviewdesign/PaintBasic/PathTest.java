package com.example.adminstator.myviewdesign.PaintBasic;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created with Android Studio.
 * Description:
 * User: wjx
 * Date: 2019-05-03
 * Time: 19:40
 */

public class PathTest extends View {
    public PathTest(Context context){
        super(context);
    }
    public PathTest(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }
    public PathTest(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(2);


        Path CCWPath = new Path();
        RectF rect1 = new RectF(50,50,240,200);
        CCWPath.addRect(rect1, Path.Direction.CCW);

        Path CWPath = new Path();
        RectF rect2 = new RectF(290, 50, 480, 200);
        CWPath.addRect(rect2, Path.Direction.CW);

        canvas.drawPath(CCWPath, paint);
        canvas.drawPath(CWPath, paint);

        String text = "hhhhhhh";
        paint.setColor(Color.GREEN);
        paint.setTextSize(35);
        canvas.drawTextOnPath(text, CCWPath, 0, 7, paint);
        canvas.drawTextOnPath(text, CWPath, 0, 7, paint);

        Path path = new Path();
        path.addCircle(100, 100, 50, Path.Direction.CCW);
        canvas.drawPath(path, paint);


    }
    private void drawRegion(Canvas  canvas, Region region, Paint paint){
        RegionIterator regionIterator = new RegionIterator(region);
        Rect r = new Rect();
        while (regionIterator.next(r)){
            canvas.drawRect(r, paint);
        }
    }
}
