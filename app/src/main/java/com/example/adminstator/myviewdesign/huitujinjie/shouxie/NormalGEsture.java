package com.example.adminstator.myviewdesign.huitujinjie.shouxie;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;
import android.widget.Switch;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/16
 * Time: 21:31
 */
public class NormalGEsture extends View {
    private Path path;
    private Paint paint;
    private float preX, preY;
    public NormalGEsture(Context context, AttributeSet attrs) {
        super(context, attrs);
        path = new Path();
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
    }


    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:{
                path.moveTo(event.getX(), event.getY());
                //B点坐标(preX, preY)
                preX = event.getX();
                preY = event.getY();
                //返回true表示当前控件已经消费了按下的动作，之后的ACTION_DOWN和ACTION_UP也会继续传递到当前控件中
                // 如果为false, 那么以后的滑动动作就不会传递到当前控件中
                return true;
            }
            case MotionEvent.ACTION_MOVE:
                //此处代码不能实现平滑绘制
//                path.lineTo(event.getX(), event.getY());
                float endX = (preX + event.getX())/2;
                float endY = (preY + event.getY())/2;
                path.quadTo(preX, preY, endX, endY);
                //获取下一个控制点的坐标
                preX = event.getX();
                preY = event.getY();
                //如果可以判断出在主线程使用Invalidate()，如果无法判断是在那个线程为了线程安全则使用postInvalidate()函数，内部实现handler
                postInvalidate();
                break;
            default:
                break;
        }
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawPath(path, paint);
    }
}
