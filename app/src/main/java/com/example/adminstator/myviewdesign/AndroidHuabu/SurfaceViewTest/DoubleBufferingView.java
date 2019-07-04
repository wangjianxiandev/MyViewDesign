package com.example.adminstator.myviewdesign.AndroidHuabu.SurfaceViewTest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.SurfaceHolder;
import android.view.SurfaceView;

import java.util.ArrayList;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/07/03
 * Time: 14:38
 */
public class DoubleBufferingView extends SurfaceView {
    private Paint paint;

    public DoubleBufferingView(Context context) {
        super(context);
        init();
    }

    public DoubleBufferingView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    public DoubleBufferingView(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        init();
    }

    private void init() {
        paint = new Paint();
        paint.setColor(Color.RED);
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

//    private void drawText(final SurfaceHolder holder) {
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//                for(int i = 0;i<10;i++){
//                    Canvas canvas = holder.lockCanvas();
//                    if(canvas != null){
//                        canvas.drawText(i+" ",i * 30, 50, paint);
//                    }
//                    holder.unlockCanvasAndPost(canvas);
//                    try{
//                        Thread.sleep(800);
//                    }catch (Exception e){
//                        e.printStackTrace();
//                    }
//                }
//            }
//        }).start();
//    }
    //一次性全部画上
//    private void drawText(final SurfaceHolder holder){
//        Canvas canvas = holder.lockCanvas();
//        for(int i  =  0;i<10;i++){
//            if(canvas != null){
//                canvas.drawText(i + " ", i * 30, 50, paint);
//            }
//        }
//        holder.unlockCanvasAndPost(canvas);
//    }
    //分10次画，但是每次都将画布内容保存起来，下次绘制的时候将所有内容全部画上区
//    private ArrayList<Integer> arrayList = new ArrayList<Integer>();
//    private void drawText(SurfaceHolder holder){
//        new Thread(()->{
//            for(int i = 0 ;i<10;i++){
//                Canvas canvas = holder.lockCanvas();
//                arrayList.add(i);
//                if(canvas!=null){
//                    for(int num : arrayList) {
//                        canvas.drawText(num + " ", num * 30, 50, paint);
//                    }
//                }
//                try{
//                    Thread.sleep(800);
//                }catch (Exception e){
//                    e.printStackTrace();
//                }
//                holder.unlockCanvasAndPost(canvas);
//            }
//        }).start();
//
//    }

    /**
     * 增量绘制
     * @param surfaceHolder
     */
    private void drawText(final SurfaceHolder surfaceHolder){
        new Thread(()->{
            while(true){
                Rect dirtyRect = new Rect(0, 0, 1, 1);
                Canvas canvas = surfaceHolder.lockCanvas(dirtyRect);
                Rect canvasRect = canvas.getClipBounds();
                if(getWidth() == canvasRect.width() && getHeight() == canvasRect.height()){
                    canvas.drawColor(Color.WHITE);
                    surfaceHolder.unlockCanvasAndPost(canvas);
                }else{
                    surfaceHolder.unlockCanvasAndPost(canvas);
                    break;
                }
            }
            for(int i = 0;i < 10;i++){
                int itemWidth = 50;
                int itemHeight = 50;
                Rect rect = new Rect(i * itemWidth, 0, (i+1) * itemWidth - 10, itemHeight);
                Canvas canvas = surfaceHolder.lockCanvas(rect);
                if(canvas != null){
                    canvas.drawColor(Color.WHITE
                    );
                    canvas.drawText(i + " ", i*itemWidth+10, itemHeight/2, paint);

                }
                surfaceHolder.unlockCanvasAndPost(canvas);
                try {
                    Thread.sleep(800);
                }catch (Exception e){
                    e.printStackTrace();
                }
            }
        }).start();
    }

}
