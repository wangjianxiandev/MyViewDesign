package com.example.adminstator.myviewdesign.huitujinjie.Beijiai;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/16
 * Time: 21:22
 */
public class BeiJiAi extends View {
    public BeiJiAi(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Path path = new Path();
        Paint paint = new Paint();
        paint.setColor(Color.BLACK);
        paint.setStrokeWidth(2);
        paint.setStyle(Paint.Style.STROKE);
        path.moveTo(100,  300);
//        path.quadTo(200, 200, 300, 300);
//        path.quadTo(400, 400, 500, 300);
        //以终点(100, 300)为基础
        path.rQuadTo(100,-100, 200, 0);
        //以终点(300, 300)为基础
        path.rQuadTo(100, 100, 200, 0);
        canvas.drawPath(path, paint);
    }
}
