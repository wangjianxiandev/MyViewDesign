package com.example.adminstator.myviewdesign.RegionTest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.util.AttributeSet;
import android.view.View;

import com.example.adminstator.myviewdesign.PaintDesign.PaintTest;

/**
 * Created with Android Studio.
 * Description:
 * User: wjx
 * Date: 2019-05-16
 * Time: 9:23
 */
public class RegionTest extends View {
    public RegionTest(Context context) {
        super(context);
    }

//    public RegionTest(Context context,  AttributeSet attrs) {
//        super(context, attrs);
//    }
//
//    public RegionTest(Context context,  AttributeSet attrs, int defStyleAttr) {
//        super(context, attrs, defStyleAttr);
//    }

    private void drawRegion(Canvas canvas, Region region, Paint paint){
        RegionIterator regionIterator = new RegionIterator(region);
        Rect rect = new Rect();
        while(regionIterator.next(rect)){
            canvas.drawRect(rect, paint);
        }
    }
    @Override
    protected void onDraw(Canvas canvas) {
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setStyle(Paint.Style.STROKE);
//        drawRegion(canvas, );}

//}
    }
}