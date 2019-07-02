package com.example.adminstator.myviewdesign.AndroidHuabu.SurfaceViewTest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/07/01
 * Time: 18:52
 */
public class SurfaceGesturePath extends SurfaceView {
    private Paint paint;
    private Path path;
    public SurfaceGesturePath(Context context) {
        super(context);
        init();
    }

    public SurfaceGesturePath(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public SurfaceGesturePath(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        //如果不加这句话会一直黑屏，这个语句是告知系统哪个控件需要在屏幕重绘时重新绘制，哪些不用
        setWillNotDraw(false);
        paint = new Paint();
        path = new Path();
        paint.setColor(Color.RED);
        paint.setStrokeWidth(5);
        paint.setStyle(Paint.Style.STROKE);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        int x = (int) event.getX();
        int y = (int) event.getY();
        if(event.getAction() == MotionEvent.ACTION_DOWN){
            path.moveTo(x, y);
            return true;
        }else if(event.getAction() == MotionEvent.ACTION_MOVE){
            path.lineTo(x,y);
        }
        drawCanvas();
        return super.onTouchEvent(event);
    }

    /**
     * surfaceView的正确使用方式
     */
    private void drawCanvas() {
        new Thread(new Runnable() {
            @Override
            public void run() {
                SurfaceHolder surfaceHolder = getHolder();
                Canvas canvas = surfaceHolder.lockCanvas();
                canvas.drawPath(path, paint);
                surfaceHolder.unlockCanvasAndPost(canvas);
            }
        }).start();
    }
}
