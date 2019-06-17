package com.example.adminstator.myviewdesign.huiturumen;

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
 * Time: 20:12
 */
public class DingDianXieZiTest extends View {
    public DingDianXieZiTest(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);


        /**
         * 根据左上角进行绘制文字
         */

        String text = "wjx";
        int top = 200;
        int baseLineX = 0;
        Paint paint = new Paint();
        paint.setTextSize(120);
        paint.setTextAlign(Paint.Align.LEFT);
        //画top线
        paint.setColor(Color.BLACK);
        canvas.drawLine(baseLineX, top, 3000 , top,paint);
        Paint.FontMetricsInt fontMetricsInt = paint.getFontMetricsInt();
        int baselineY = top - fontMetricsInt.top;
        //画基线
        canvas.drawLine(baseLineX, baselineY, 3000 ,baselineY, paint);

        paint.setColor(Color.RED);
        canvas.drawText(text, baseLineX, baselineY, paint);

        /**
         * 根据中线绘图
         */

    }
}
