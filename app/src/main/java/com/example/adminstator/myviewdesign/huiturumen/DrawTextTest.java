package com.example.adminstator.myviewdesign.huiturumen;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/14
 * Time: 16:47
 */
public class DrawTextTest extends View {
    public DrawTextTest(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int baseLineX = 0;
        int baseLineY = 200;
        String text = "wjx";

        //画基线
        Paint paint = new Paint();


        paint.setColor(Color.RED);
        canvas.drawLine(baseLineX, baseLineY, 3000, baseLineY, paint);

        //写文字
        paint.setColor(Color.GREEN);
        paint.setTextSize(120);
        paint.setTextAlign(Paint.Align.CENTER);
        canvas.drawText(text, baseLineX, baseLineY, paint);
        Rect rect = new Rect();
        paint.getTextBounds(text, 0, text.length(), rect);
        System.out.println(rect.toShortString());

    }
}
