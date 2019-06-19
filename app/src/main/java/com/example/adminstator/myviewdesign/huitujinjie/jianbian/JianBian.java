package com.example.adminstator.myviewdesign.huitujinjie.jianbian;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/19
 * Time: 18:00
 */
public class JianBian extends View {
    private Paint paint;
    public JianBian(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        setLayerType(LAYER_TYPE_SOFTWARE ,null);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int[] colors = {0xffff0000, 0xff00ff00, 0xff0000ff,0xffffff00, 0xff00ffff};
        float[] pos = {0f, 0.2f, 0.4f, 0.6f, 1.0f};

        paint.setShader(new LinearGradient(0, getHeight()/2, getWidth()/2, getHeight()/2, colors,  pos, Shader.TileMode.CLAMP));
        canvas.drawRect(0, 0, getWidth(), getHeight(), paint);
    }
}
