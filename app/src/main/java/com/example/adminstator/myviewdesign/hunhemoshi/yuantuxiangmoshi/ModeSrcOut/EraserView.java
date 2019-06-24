package com.example.adminstator.myviewdesign.hunhemoshi.yuantuxiangmoshi.ModeSrcOut;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.adminstator.myviewdesign.R;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/21
 * Time: 17:18
 */
public class EraserView extends View {
    private Paint paint;
    private Bitmap BmpDST, BmpSRC, BmpText;
    private Path path;
    private float mPreX, mPreY;
    public EraserView(Context context,AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        paint = new Paint();
        paint.setColor(Color.RED);
        paint.setStyle(Paint.Style.STROKE);
        paint.setStrokeWidth(45);
        BitmapFactory.Options options = new BitmapFactory.Options();
        //设置采样率为2,将图片设置为原来的1/2
        options.inSampleSize = 2;
        BmpSRC = BitmapFactory.decodeResource(getResources(), R.drawable.guaguaka_text,options);
        BmpDST = Bitmap.createBitmap(BmpSRC.getWidth(), BmpSRC.getHeight(), Bitmap.Config.ARGB_8888);
        BmpText = BitmapFactory.decodeResource(getResources(), R.drawable.dog, null);

        path = new Path();
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        switch (event.getAction()){
            case MotionEvent.ACTION_DOWN:
                path.moveTo(event.getX(), event.getY());
                mPreX = event.getX();
                mPreY = event.getY();
                return true;
            case MotionEvent.ACTION_MOVE:
                float endX = (mPreX+event.getX())/2;
                float endY = (mPreY+event.getY())/2;
                path.quadTo(mPreX, mPreY, endX, endY);
                mPreX = event.getX();
                mPreY = event.getY();
                break;
            case MotionEvent.ACTION_UP:
                break;
        }
        postInvalidate();
        return super.onTouchEvent(event);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);

        canvas.drawBitmap(BmpText, null, new RectF(0, 0, BmpDST.getWidth(), BmpDST.getHeight()), paint);
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        //先把手势轨迹画到目标图像上
        Canvas c = new Canvas(BmpDST);
        c.drawPath(path, paint);
        //然后把目标图像画到画布上
        canvas.drawBitmap(BmpDST,0, 0, paint);
        //计算源图像区域
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
        canvas.drawBitmap(BmpSRC, 0, 0, paint);
        paint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }
}
