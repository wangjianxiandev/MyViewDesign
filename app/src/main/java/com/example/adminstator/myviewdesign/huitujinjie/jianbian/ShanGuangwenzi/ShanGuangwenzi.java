package com.example.adminstator.myviewdesign.huitujinjie.jianbian.ShanGuangwenzi;

import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Canvas;
import android.graphics.LinearGradient;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.View;
import android.widget.TextView;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/19
 * Time: 18:48
 */
@SuppressLint("AppCompatCustomView")
public class ShanGuangwenzi extends TextView {
    private Paint paint;
    private LinearGradient linearGradient;
    private int mDx;
    public ShanGuangwenzi(Context context, AttributeSet attrs) {
        super(context, attrs);
        //获取textView自带的画笔
        paint = getPaint();
        //计算文字的长度
        int length = (int) paint.measureText(getText().toString());
        createAnim(length);
        createLinearGradient(length);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        //我们使用getPaint()的原因是TextView会在OnDraw()函数中绘制文字，但是绘制文字之前我们需要在设置Shader效果
        //这个效果必须设置给文字的画笔才有效，所以使用getPaint()
        super.onDraw(canvas);
        Matrix matrix = new Matrix();
        matrix.setTranslate(mDx, 0);
        linearGradient.setLocalMatrix(matrix);
        paint.setShader(linearGradient);

    }

    /**
     * 动画的运动长度是文字长度的两倍
     * @param length
     */
    public void createAnim(int length){
        ValueAnimator valueAnimator = ValueAnimator.ofInt(0, 2*length);
        valueAnimator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                mDx = (int) animation.getAnimatedValue();
                postInvalidate();
            }
        });
        valueAnimator.setRepeatMode(ValueAnimator.REVERSE);
        valueAnimator.setRepeatCount(ValueAnimator.INFINITE);
        valueAnimator.setDuration(2000);
        valueAnimator.start();
    }

    public void createLinearGradient(int length){
        linearGradient = new LinearGradient(-length, 0, 0 , 0, new int[]{
                getCurrentTextColor(), 0xff00ff00, getCurrentTextColor()
        }, new float[]{0, 0.5f, 1}, Shader.TileMode.CLAMP);
    }
}
