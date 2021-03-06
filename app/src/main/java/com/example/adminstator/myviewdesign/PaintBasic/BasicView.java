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
 * Date: 2019-04-29
 * Time: 20:44
 */
public class BasicView extends View {
    public BasicView(Context context){
        super(context);
    }
    public BasicView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }
    public BasicView(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        Paint paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.FILL);
        paint.setStrokeWidth(2);
        Path path = new Path();
        path.addRect(100,100,300, 300, Path.Direction.CW);
        path.addCircle(300,300,100, Path.Direction.CW);
        path.setFillType(Path.FillType.WINDING);
        canvas.drawPath(path, paint);

//        Path path1  = new Path();
//        RectF rectF = new RectF(10,10,200,100);
//        path1.addOval(rectF, Path.Direction.CCW);
//        canvas.drawPath(path1,paint);

    }
    private void drawRegion(Canvas  canvas, Region region, Paint paint){
        RegionIterator regionIterator = new RegionIterator(region);
        Rect r = new Rect();
        while (regionIterator.next(r)){
            canvas.drawRect(r, paint);
        }
    }
}
