package com.example.adminstator.myviewdesign.PaintDesign;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created with Android Studio.
 * Description:
 * User: wjx
 * Date: 2019-05-14
 * Time: 21:22
 */
public class PaintTest extends View {
    public PaintTest(Context context){
        super(context);
    }
    public PaintTest(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }
    public PaintTest(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
    }
    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint = new Paint();
        //设置画笔颜色
        paint.setColor(Color.RED);
        //设置画笔宽度
        paint.setStrokeWidth(5);
        //设置文字大小
        paint.setTextSize(12);
        //设置是否为粗体文字
//        paint.setFakeBoldText(true);
        //设置是否使用抗锯齿功能
        paint.setAntiAlias(true);
        //设置下划线
        paint.setUnderlineText(true);
        //设置文字大小
        paint.setTextSize(30);
        paint.setTextAlign(Paint.Align.RIGHT);
        //设置中间删除线
        paint.setStrikeThruText(true);
        //设置字体倾斜度
        paint.setTextSkewX(-0.25f);
        //设置水平拉伸
        paint.setTextScaleX(2);
        //绘图样式，设置填充
        paint.setStyle(Paint.Style.FILL);
        canvas.drawText("王拣贤佩奇",400,100, paint);
    }
}
