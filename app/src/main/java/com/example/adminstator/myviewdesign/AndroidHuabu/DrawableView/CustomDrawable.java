package com.example.adminstator.myviewdesign.AndroidHuabu.DrawableView;

import android.annotation.SuppressLint;
import android.graphics.Bitmap;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.ColorFilter;
import android.graphics.Paint;
import android.graphics.PixelFormat;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.Drawable;

import com.example.adminstator.myviewdesign.huiturumen.DrawTextTest;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/28
 * Time: 13:48
 */
public class CustomDrawable extends Drawable {
    private Paint paint;
    private Bitmap bitmap;
    private BitmapShader bitmapShader;
    private RectF bound;

    public CustomDrawable(Bitmap bitmap){
        this.bitmap = bitmap;
        paint = new Paint();
        paint.setAntiAlias(true);
    }
    /**
     * 与View类似，传入的参数是一个Canvas对象，我们只需要调用Canvas的一些方法，效果就会直接显示在Drawable上
     * @param canvas
     */
    @Override
    public void draw(Canvas canvas) {
        canvas.drawRoundRect(bound, 20, 20, paint);
    }

    /**
     * 当外层调用CustomDrawable的函数时，我们只需要将对应的参数传给CustomDrawable的paint即可
     * @param alpha
     */
    @Override
    public void setAlpha(int alpha) {
        paint.setAlpha(alpha);
    }

    @Override
    public void setColorFilter(ColorFilter colorFilter) {
        paint.setColorFilter(colorFilter);
    }

    /**
     * 当外部需要直到我们自定义的CustomDrawable的显示模式时会调用这个函数
     * 四个取值：
     * PixelFormat.UNKNOWN表示未知
     * PixelFormat.TRANSLUCENT（一般使用该方法）表示当前CustomDrawable的绘图是具有Alpha通道的,即你使用CustomDrawable后，其底部的图现象仍然有可能看到
     * PixelFormat.TRANSPARENT表示但概念CustomDrawable是完全透明的，其中什么都没有话，如果使用CustomDrawable，则是完全显示其底部图像
     * PixelFormat.OPAQUE表示当前的CustomDrawable是完全没有Alpha通道的，使用CustomDrawable后底层图像是完全被覆盖的，而只显示CustomDrawable本身的图像
     * @return
     */
    @SuppressLint("WrongConstant")
    @Override
    public int getOpacity() {
        return PixelFormat.TRANSLUCENT;
    }

    @Override
    public void setBounds(int left, int top, int right, int bottom) {
        //创建一个与Drawable相同大小的Bitmap作为Drawable的Shader
        super.setBounds(left, top, right, bottom);
        bitmapShader = new BitmapShader(Bitmap.createScaledBitmap(bitmap, right-left, bottom-top, true), Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        paint.setShader(bitmapShader);
        bound = new RectF(left, top, right, bottom);
    }

    /**
     * 设置默认的宽
     * @return
     */
    @Override
    public int getIntrinsicWidth() {
        return bitmap.getWidth();
    }

    /**
     * 设置默认的高
     * @return
     */
    @Override
    public int getIntrinsicHeight() {
        return bitmap.getHeight();
    }
}
