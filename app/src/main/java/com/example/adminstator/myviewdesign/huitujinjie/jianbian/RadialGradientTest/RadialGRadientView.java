package com.example.adminstator.myviewdesign.huitujinjie.jianbian.RadialGradientTest;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.RadialGradient;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/19
 * Time: 19:15
 */
public class RadialGRadientView extends View {
    private Paint paint;
    private RadialGradient radialGradient;
    private int radius;
    public RadialGRadientView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        paint = new Paint();
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(radialGradient == null){
            radius = getWidth() / 2;
            int[] colors = {0xffff0000, 0xff00ff00, 0xff0000ff,0xffffff00, 0xff00ffff};
            float[] stops = {0f, 0.2f, 0.4f, 0.6f, 1.0f};
            radialGradient = new RadialGradient(getWidth()/ 2, getHeight()/ 2, radius, colors, stops, Shader.TileMode.REPEAT);
            paint.setShader(radialGradient);
        }
        canvas.drawCircle(getWidth()/2, getHeight()/2, radius, paint);
    }
}
