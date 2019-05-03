package com.example.adminstator.myviewdesign.PaintBasic;

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
 * User: wjx
 * Date: 2019-05-03
 * Time: 19:47
 */
public class TianChongMoShi extends View {
    public TianChongMoShi(Context context){
        super(context);
    }
    public TianChongMoShi(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }
    public TianChongMoShi(Context context, AttributeSet attributeSet, int defStyle){
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



    }
}
