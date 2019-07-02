package com.example.adminstator.myviewdesign.AndroidHuabu.BitmapStaticBuild;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.LinearGradient;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/07/01
 * Time: 11:39
 */
public class LinearGradientView extends View {
    private Bitmap bitmap;
    private Paint paint;
    public LinearGradientView(Context context){

        super(context);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        init();
    }

    public LinearGradientView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        init();
    }
    public LinearGradientView(Context context,AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        init();
    }

    private void init() {
        paint = new Paint();
        int width = 500;
        int height = 300;
        bitmap = Bitmap.createBitmap(width, height, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        LinearGradient linearGradient = new LinearGradient(width/2, 0, width/2, height, 0xffffffff, 0x00ffffff, Shader.TileMode.CLAMP);
        paint.setShader(linearGradient);
        canvas.drawRect(0, 0, width, height, paint);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(5);
        canvas.drawRect(0, 0,bitmap.getWidth(), bitmap.getHeight(), paint);

    }
}
