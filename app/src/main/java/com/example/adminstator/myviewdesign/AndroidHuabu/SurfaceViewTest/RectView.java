package com.example.adminstator.myviewdesign.AndroidHuabu.SurfaceViewTest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import android.view.View;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/07/03
 * Time: 15:07
 */
public class RectView extends SurfaceView {
    private Paint paint;
    public RectView(Context context) {
        super(context);
        init();
    }

    public RectView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public RectView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.argb(0x1F, 0xFF, 0xFF, 0xFF));
        paint.setTextSize(30);
        SurfaceHolder surfaceHolder = getHolder();
        surfaceHolder.addCallback(new SurfaceHolder.Callback() {
            @Override
            public void surfaceCreated(SurfaceHolder holder) {
                drawText(holder);
            }

            @Override
            public void surfaceChanged(SurfaceHolder holder, int format, int width, int height) {

            }

            @Override
            public void surfaceDestroyed(SurfaceHolder holder) {

            }
        });
    }
    private void drawText(final SurfaceHolder surfaceHolder){
        new Thread(new Runnable() {
            @Override
            public void run() {
                while(true) {
                    Rect dirtyRect = new Rect(0, 0, 1, 1);
                    Canvas canvas = surfaceHolder.lockCanvas(dirtyRect);
                    Rect canvasRect = canvas.getClipBounds();
                    if (getWidth() == canvasRect.width() && getHeight() == canvasRect.height()) {
                        canvas.drawColor(Color.BLACK);
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    } else {
                        surfaceHolder.unlockCanvasAndPost(canvas);
                        break;
                    }
                }

                for(int i = 0;i<10;i++){
                    if(i == 0){
                        Canvas canvas = surfaceHolder.lockCanvas(new Rect(10, 10, 600, 600));

                        dumpCanvasRect(canvas);
                        canvas.drawColor(Color.RED);
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                    if(i == 1){
                        Canvas canvas = surfaceHolder.lockCanvas(new Rect(30, 30, 570, 570));
                        dumpCanvasRect(canvas);
                        canvas.drawColor(Color.GREEN);
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                    if(i==2){
                        Canvas canvas = surfaceHolder.lockCanvas(new Rect(60,60,540,540));
                        dumpCanvasRect(canvas);
                        canvas.drawColor(Color.BLUE);
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                    if(i==3){
                        Canvas canvas = surfaceHolder.lockCanvas(new Rect(200, 200, 400, 400));
                        dumpCanvasRect(canvas);
                        canvas.drawColor(Color.argb(0x3F, 0xFF, 0xFF, 0xFF));
                        paint.setColor(Color.RED);
                        canvas.drawCircle(300, 300, 100, paint);
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }

                    if(i==4){
                        Canvas canvas = surfaceHolder.lockCanvas(new Rect(250, 250, 350, 350));
                        dumpCanvasRect(canvas);
                        paint.setColor(Color.RED);
                        canvas.drawText(i + " ", 300, 300, paint);
                        surfaceHolder.unlockCanvasAndPost(canvas);
                    }
                    try{
                        Thread.sleep(800);
                    }catch (Exception e){
                        e.printStackTrace();
                    }
                }
            }
        }).start();
    }

    private void dumpCanvasRect(Canvas canvas){
        if(canvas != null){
            Rect rect = canvas.getClipBounds();
            System.out.println(rect.width()+" "+rect.height());
        }
    }


    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        paint.setColor(Color.RED);
        canvas.drawRect(new Rect(10, 10, 600, 600), paint);
        paint.setColor(Color.GREEN);
        canvas.drawRect(new Rect(30, 30, 570,  570),paint);
        paint.setColor(Color.BLUE);
        canvas.drawRect(new Rect(60, 60, 540, 540), paint);
        paint.setColor(Color.argb(0x3F, 0xFF, 0xFF, 0xFF));
        canvas.drawCircle(300, 300, 100,paint);
        paint.setColor(Color.GREEN);
        canvas.drawText("6", 300, 300, paint);
    }
}
