package com.example.adminstator.myviewdesign.AndroidHuabu.ShapeExample;

import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Region;
import android.graphics.RegionIterator;
import android.graphics.drawable.shapes.Shape;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/27
 * Time: 21:32
 */
public class OwnShapeView extends Shape {
    private Region region;
    public OwnShapeView(Region region){
        if(region!=null){
            this.region = region;
        }
    }
    @Override
    public void draw(Canvas canvas, Paint paint) {
        RegionIterator iter = new RegionIterator(region);
        Rect r = new Rect();
        while (iter.next(r)){
            canvas.drawRect(r, paint);
        }
    }
}
