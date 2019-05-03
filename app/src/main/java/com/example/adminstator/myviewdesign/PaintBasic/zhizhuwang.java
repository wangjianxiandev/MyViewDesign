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
 * Time: 19:54
 */
public class zhizhuwang extends View {
    //声明雷达和数值的画笔，因为如果在onDraw()方法中创建变量会消耗手机内存，所以在外面初始化
    private Paint radarPaint, valuePaint;
    //雷达网格的最大半径
    private float radius;
    //中心横坐标
    private int centerX;
    //中心纵坐标
    private int centerY;
    //设置层数
    private static final int count = 6;
    //设置角度
    private float angle = (float) (Math.PI*2/count);
    //初始化数据
    private double[] data = {6,4,1,5,3,2};
    //最大值,网格线需要每一层有唯一标识
    private float maxValue = 6;


    public zhizhuwang(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        init();
    }

    private void init(){
        //描绘网格边
        radarPaint = new Paint();
        radarPaint.setStyle(Paint.Style.STROKE);
        radarPaint.setColor(Color.GREEN);
        //描绘点的区域
        valuePaint = new Paint();
        valuePaint.setStyle(Paint.Style.FILL);
        valuePaint.setColor(Color.RED);
    }

    @Override
    protected void onSizeChanged(int w, int h, int oldw, int oldh){
        radius = Math.min(h,w)/2*0.9f;
        //中心坐标
        centerX = w/2;
        centerY = h/2;
        postInvalidate();
        super.onSizeChanged(w,h,oldw,oldh);
    }


    /**
     * 绘制层线（六边形）
     * @param canvas
     */
    private void drawPolygon(Canvas canvas) {
        Path path  = new Path();
        //计算层之间的间距
        float r = radius/(count);
        //最内部的层不用画
        for(int i = 1;i<=count;i++){
            //获取当前半径
            float curR = r*i;
            path.reset();
            for(int j = 0;j<count;j++){
                if(j==0){
                    path.moveTo(centerX+curR, centerY);
                }else{
                    //根据半径，计算蜘蛛网上的每个点的坐标
                    float x = (float)(centerX+curR*Math.cos(angle*j));
                    float y = (float)(centerY+curR*Math.sin(angle*j));
                    path.lineTo(x,y);
                }
            }
            path.close();
            canvas.drawPath(path, radarPaint);

        }
    }

    /**
     * 绘制拐角线
     * @param canvas
     */
    private void drawLines(Canvas canvas) {
        Path path = new Path();
        for(int i = 0;i<count;i++){
            path.reset();
            path.moveTo(centerX, centerY);
            float x = (float)(centerX+radius*Math.cos(angle*i));
            float y = (float)(centerY+radius*Math.sin(angle*i));
            path.lineTo(x,y);
            canvas.drawPath(path, radarPaint);
        }
    }

    /**
     * 绘制数据线
     * @param canvas
     */
    private void drawRegion(Canvas canvas) {
        Path path = new Path();
        valuePaint.setAlpha(127);
        for(int i = 0;i<count;i++){
            double percent = data[i]/maxValue;
            float x = (float)(centerX+radius*Math.cos(angle*i)*percent);
            float y = (float)(centerY+radius*Math.sin(angle*i)*percent);
            if(i==0){
                path.moveTo(x,centerY);
            }else{
                path.lineTo(x,y);
            }
            canvas.drawCircle(x, y,10, valuePaint);
        }
        valuePaint.setStyle(Paint.Style.FILL_AND_STROKE);
        canvas.drawPath(path, valuePaint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //绘制蜘蛛网格
        drawPolygon(canvas);
        //画网格中线
        drawLines(canvas);
        //画数据图
        drawRegion(canvas);
    }
}
