package com.example.adminstator.myviewdesign.Canvas;

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
 * User: wjx
 * Date: 2019-05-16
 * Time: 9:56
 */
public class CanvasTran extends View {
    public CanvasTran(Context context) {
        super(context);
    }

    public CanvasTran(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public CanvasTran(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Paint paint_green = generatePaint(Color.GREEN, Paint.Style.STROKE, 3);
        Paint paint_red = generatePaint(Color.RED, Paint.Style.STROKE, 3);
        Rect rect = new Rect(10, 10, 200, 100);
//        canvas.drawRect(rect, paint_green);
//        //旋转30度
//        canvas.rotate(30);
//        canvas.drawRect(rect, paint_red);
        canvas.drawRect(rect, paint_green);
        //sx水平方向伸缩的比例，假设原坐标轴的比例为n, 不变时为1，变更后的X轴密度为n * sx,所以sx是小数表述的缩小整数表示的放大
        //sy垂直方向的伸缩的比例，，同样sy为小数表示的缩小，sy为整数表示的放大
//        canvas.scale(0.5f, 1);

        //sx为将画布在x轴方向上倾斜相应的较堵，sx为倾斜角度的正切值
        //sy为将画布在y轴方向上倾斜相应的较堵，sy为倾斜较堵的正切值
        //x轴方向上倾斜60的正切值为1.732
        canvas.skew(1.732f,  0);
        canvas.drawRect(rect, paint_red);




    }
    private Paint generatePaint(int color, Paint.Style style, int width){
        Paint paint = new Paint();
        paint.setColor(color);
        paint.setStyle(style);
        paint.setStrokeWidth(width);
        return paint;
    }

}
