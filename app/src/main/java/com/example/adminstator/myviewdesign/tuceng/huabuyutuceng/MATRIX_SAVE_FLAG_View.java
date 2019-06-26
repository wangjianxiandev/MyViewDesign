package com.example.adminstator.myviewdesign.tuceng.huabuyutuceng;

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
 * Time: 9:56
 */
public class MATRIX_SAVE_FLAG_View extends View {
    private Paint paint;
    public MATRIX_SAVE_FLAG_View(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        //bao保存画布的位置信息
        canvas.save();
        //将画布旋转40度
        canvas.rotate(40);
        //画一个矩形
        canvas.drawRect(100, 0, 200, 100, paint);
        //恢复画布
        canvas.restore();
        paint.setColor(Color.BLACK);
        canvas.drawRect(100, 0, 200, 100, paint);
    }
}
