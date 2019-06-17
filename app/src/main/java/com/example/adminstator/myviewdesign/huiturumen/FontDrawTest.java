package com.example.adminstator.myviewdesign.huiturumen;

import android.app.PendingIntent;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/14
 * Time: 18:08
 */
public class FontDrawTest extends View {
    public FontDrawTest(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();

        int baseLineX = 0;
        int baseLineY = 200;

        paint.setTextSize(120);
        paint.setStrokeWidth(8);
        paint.setTextAlign(Paint.Align.LEFT);
        canvas.drawText("wjx", baseLineX, baseLineY, paint);

        //获取四条线
        Paint.FontMetrics fontMetrics = paint.getFontMetrics();
        float ascent = baseLineX + fontMetrics.ascent;
        float descent = baseLineX + fontMetrics.descent;
        float top = baseLineX + fontMetrics.top;
        float bottom = baseLineX  + fontMetrics.bottom;

        //将四条线一条条画出来
        paint.setColor(Color.BLUE);
        //基线
        canvas.drawLine(baseLineX, baseLineY, 300, baseLineY, paint);
        //ascent线
        paint.setColor(Color.RED);
        canvas.drawLine(baseLineX, ascent, 3000, ascent, paint);
        //descent线
        paint.setColor(Color.GREEN);
        canvas.drawLine(baseLineX, descent, 3000, descent, paint);
        //top线
        paint.setColor(Color.YELLOW);
        canvas.drawLine(baseLineX, top, 3000, top, paint);
        //bottom线
        paint.setColor(Color.BLACK);
        canvas.drawLine(baseLineX, bottom, 3000, bottom, paint);

    }
}
