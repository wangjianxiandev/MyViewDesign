package com.example.adminstator.myviewdesign.huitujinjie.ShaderTest.buguizetouxiang;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;

import com.example.adminstator.myviewdesign.R;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/19
 * Time: 16:36
 */
public class HeadImageView extends View {
    private Paint paint;
    private Bitmap bitmap;
    private BitmapShader bitmapShader;
    public HeadImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.niuniu);
        paint = new Paint();
        bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        Matrix matrix = new Matrix();
        float scale = (float) getWidth() / bitmap.getWidth();
        matrix.setScale(scale, scale);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        float half = getWidth() / 2;
        RectF rect = new RectF(0, 0, getWidth(), getHeight());
        canvas.drawRoundRect(rect, half,half , paint);
    }
}
