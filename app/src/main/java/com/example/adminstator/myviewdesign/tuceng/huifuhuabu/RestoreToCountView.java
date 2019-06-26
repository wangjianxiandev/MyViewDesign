package com.example.adminstator.myviewdesign.tuceng.huifuhuabu;

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
 * @date: 2019/06/26
 * Time: 12:50
 */
public class RestoreToCountView extends View {
    private Paint paint;
    public RestoreToCountView(Context context,  AttributeSet attrs) {
        super(context, attrs);
        paint =  new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int id1 = canvas.save();
        canvas.clipRect(0, 0, 800, 800);
        canvas.drawColor(Color.BLACK);
        System.out.println(id1);
        int id2 = canvas.saveLayer(0, 0, getWidth(), getHeight(), paint, Canvas.ALL_SAVE_FLAG);
        canvas.clipRect(100, 100, 700, 700);
        canvas.drawColor(Color.RED);
        System.out.println(id2);
        int id3 = canvas.saveLayerAlpha(0, 0, getWidth(),getHeight(), 0xf0, Canvas.ALL_SAVE_FLAG);
        canvas.clipRect(200, 200, 600, 600);
        canvas.drawColor(Color.YELLOW);
        System.out.println(id3);
        int id4 = canvas.save();
        canvas.clipRect(300, 300, 500, 500);
        canvas.drawColor(Color.BLUE);
        System.out.println(id4);
        //恢复到生成id3之前的画布状态
        canvas.restoreToCount(id3);
        canvas.drawColor(Color.GREEN);
    }
}
