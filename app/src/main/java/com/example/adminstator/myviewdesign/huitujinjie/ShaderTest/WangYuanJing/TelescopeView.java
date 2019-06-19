package com.example.adminstator.myviewdesign.huitujinjie.ShaderTest.WangYuanJing;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Rect;
import android.graphics.Shader;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.adminstator.myviewdesign.R;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/19
 * Time: 15:50
 */
public class TelescopeView extends View {
    private Paint paint;
    private Bitmap bitmap, bitmapBg;
    private int mDx;
    private int mDy;
    public TelescopeView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        //将背景图拉伸，画在这个画布上
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.android);

    }
    @Override
    public boolean onTouchEvent(MotionEvent event){
        switch(event.getAction()){
            case MotionEvent.ACTION_DOWN:
                mDx = (int)event.getX();
                mDy = (int)event.getY();
                postInvalidate();
                return true;

            case MotionEvent.ACTION_MOVE:
                mDx = (int) event.getX();
                mDy = (int) event.getY();
                break;
            case MotionEvent.ACTION_UP:
            case MotionEvent.ACTION_CANCEL:
                mDx = -1;
                mDy = -1;
                break;
        }
        postInvalidate();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(bitmapBg == null){
            //创建一张空白的位图
            bitmapBg = Bitmap.createBitmap(getWidth(), getHeight(), Bitmap.Config.ARGB_8888);
            //创建一个新的画布将背景图覆盖，可通过在画布上作图来操作bitmapBg
            Canvas canvasBg = new Canvas(bitmapBg);
            //画出透明的bitmapBg,左上角空处
            canvasBg.drawBitmap(bitmap, null, new Rect(0, 0 ,getWidth(), getHeight()),paint);
        }
        if(mDx != -1 && mDy!=-1){

            paint.setShader(new BitmapShader(bitmapBg, Shader.TileMode.REPEAT, Shader.TileMode.REPEAT));
            //将BitmapBg进行移动
            canvas.drawCircle(mDx, mDy, 150, paint);
        }
    }
}
