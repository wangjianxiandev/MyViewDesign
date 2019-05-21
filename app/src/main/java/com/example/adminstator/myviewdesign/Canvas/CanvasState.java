package com.example.adminstator.myviewdesign.Canvas;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.example.adminstator.myviewdesign.PaintDesign.PaintTest;

/**
 * Created with Android Studio.
 * Description:
 * User: wjx
 * Date: 2019-05-18
 * Time: 10:29
 */

//保存与恢复
public class CanvasState extends View {

    public CanvasState(Context context) {
        super(context);
    }

    public CanvasState(Context context,  AttributeSet attrs) {
        super(context, attrs);
    }

    public CanvasState(Context context,  AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.drawColor(Color.RED);
        //保存整屏画布会将当前的画布状态保存到栈中
        int canvas1 = canvas.save();
        //裁剪画布
        canvas.clipRect(new Rect(100, 100, 800, 800));
        canvas.drawColor(Color.GREEN);
        int canvas2 = canvas.save();

        canvas.clipRect(new Rect(200, 200,700, 700));
        canvas.drawColor(Color.BLUE);
        int canvas3 = canvas.save();

        canvas.clipRect(new Rect(300, 300, 600, 600));
        canvas.drawColor(Color.BLACK);
        int canvas4 = canvas.save();

        canvas.clipRect(new Rect(400,400,500,500));
        canvas.drawColor(Color.YELLOW);
//        canvas.save();
//        //恢复画布
//        canvas.restore();
//        canvas.drawColor(Color.BLUE);
        //恢复画布按栈的方式取出,并可以重画去除的画布
        canvas.restore();
        canvas.restore();
        canvas.restore();
        //因为会需要处理某一个画布,所以需要操作具体栈中某一个画布,restoreToCount(int saveCount),但是saveCount哪里来呢,save函数调用后 会返回一个整形值(画布所在栈的索引)
        //restoreCount()方法时类似于启动模式中的singleTask,会将指定画布上面的画布全部弹出, 知道索引的画布出栈为止,所以在刚才的代码中将save方法的返回值保存起来即可
        canvas.restoreToCount(canvas2);
        canvas.drawColor(Color.WHITE);


    }
}
