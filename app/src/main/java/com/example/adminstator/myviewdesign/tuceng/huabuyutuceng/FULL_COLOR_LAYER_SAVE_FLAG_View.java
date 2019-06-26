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
 * Time: 12:01
 */
public class FULL_COLOR_LAYER_SAVE_FLAG_View extends View {
    private Paint paint;
    public FULL_COLOR_LAYER_SAVE_FLAG_View(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE ,null);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.RED);
        canvas.saveLayer(0, 0, 300, 300, paint,Canvas.ALL_SAVE_FLAG);
    }
}
