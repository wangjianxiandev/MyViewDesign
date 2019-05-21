package com.example.adminstator.myviewdesign.RoundImage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Paint;
import android.graphics.Path;
import android.util.AttributeSet;
import android.view.View;

import com.example.adminstator.myviewdesign.PaintDesign.PaintTest;
import com.example.adminstator.myviewdesign.R;

/**
 * Created with Android Studio.
 * Description:
 * User: wjx
 * Date: 2019-05-18
 * Time: 12:10
 */
public class CustomCircleView extends View {
    private Bitmap bitmap;
    private Paint paint;
    private Path path;

    public CustomCircleView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        //禁用硬件加速
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.niuniu);
        paint = new Paint();
        path  = new Path();
        int width = bitmap.getWidth();
        int height = bitmap.getHeight();
        path.addCircle(width/2,  height/2, width/2, Path.Direction.CCW);
    }
    @Override
    protected void onDraw(Canvas canvas){
        super.onDraw(canvas);
        canvas.save();
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap,0, 0, paint);
        canvas.restore();
    }


}
