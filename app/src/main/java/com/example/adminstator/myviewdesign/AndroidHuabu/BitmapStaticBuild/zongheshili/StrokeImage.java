package com.example.adminstator.myviewdesign.AndroidHuabu.BitmapStaticBuild.zongheshili;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.drawable.BitmapDrawable;
import android.graphics.drawable.StateListDrawable;
import android.util.AttributeSet;
import android.widget.ImageView;

import com.example.adminstator.myviewdesign.R;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/07/01
 * Time: 14:40
 */
@SuppressLint("AppCompatCustomView")
public class StrokeImage extends ImageView {
    public StrokeImage(Context context) {
        super(context);
    }

    public StrokeImage(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    public StrokeImage(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
    }

    /**
     * 该函数是系统将XML解析出来对应的控件，控件已经生成，但是还没有被使用，可以对控件进行一些基础设置
     */
    @Override
    protected void onFinishInflate() {
        super.onFinishInflate();
        Paint paint = new Paint();
        paint.setColor(Color.CYAN);
        //向ImageView中添加背景
        setStateDrawable(this, paint);
    }

    private void setStateDrawable(ImageView imageView, Paint paint) {
        BitmapDrawable bitmapDrawable = (BitmapDrawable)imageView.getDrawable();
        Bitmap srcBmp = bitmapDrawable.getBitmap();
        Bitmap bitmap = Bitmap.createBitmap(srcBmp.getWidth(), srcBmp.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        canvas.drawBitmap(srcBmp.extractAlpha(), 0, 0, paint);

        //添加状态
        StateListDrawable stateListDrawable = new StateListDrawable();
        stateListDrawable.addState(new int[]{
                android.R.attr.state_pressed
        },new BitmapDrawable(bitmap));
        imageView.setBackgroundDrawable(stateListDrawable);
    }
}
