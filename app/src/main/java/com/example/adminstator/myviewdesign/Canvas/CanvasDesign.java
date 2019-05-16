package com.example.adminstator.myviewdesign.Canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.Typeface;
import android.util.AttributeSet;
import android.view.View;

import java.lang.reflect.Type;

/**
 * Created with Android Studio.
 * Description:
 * User: wjx
 * Date: 2019-05-15
 * Time: 17:32
 */
public class CanvasDesign extends View {
    public CanvasDesign(Context context) {
        super(context);
    }

    public CanvasDesign(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public CanvasDesign(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }
    @Override
    protected void onDraw(Canvas  canvas){
//        Paint paint = new Paint();
//        paint.setColor(Color.BLUE);
//        paint.setTextSize(45);
//        paint.setStrokeWidth(5);
//        paint.setStyle(Paint.Style.STROKE);
//        Path circlePath = new Path();
//        circlePath.addCircle(220, 300, 150, Path.Direction.CCW);
//        canvas.drawPath(circlePath, paint);
//        Path circlePath2 = new Path();
//        circlePath2.addCircle(600, 300, 150, Path.Direction.CCW);
//        canvas.drawPath(circlePath2, paint);
//        String string = "王拣贤佩奇王拣贤佩奇王拣贤佩奇";
//        canvas.drawTextOnPath(string, circlePath, 0,0,paint);
//        canvas.drawTextOnPath(string, circlePath2, 80, 30,paint);

//        Paint paint = new Paint();
//        Typeface typeface = Typeface.defaultFromStyle(Typeface.BOLD_ITALIC);
//        paint.setColor(Color.BLUE);
//        paint.setTypeface(typeface);
//
//        paint.setTextSize(50);
        Paint paint = new Paint();
        paint.setColor(Color.BLUE);
        paint.setTextSize(50);
        String string = "宋体";
        Typeface font = Typeface.create(string, Typeface.NORMAL);
        paint.setTypeface(font);
        canvas.drawText("王拣贤佩奇",10, 100, paint);
    }
}
