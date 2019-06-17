package com.example.adminstator.myviewdesign.huitujinjie.ShadowLayerViewTest;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.graphics.Rect;
import android.util.AttributeSet;
import android.view.View;

import com.example.adminstator.myviewdesign.R;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/17
 * Time: 10:53
 */
public class ShadowLayerView extends View {
    private Bitmap bitmap;
    private Paint paint = new Paint();
    public ShadowLayerView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        paint.setColor(Color.BLACK);
        paint.setTextSize(25);
        paint.setShadowLayer(1, 10, 10, Color.GRAY);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.niuniu);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawColor(Color.WHITE);
        canvas.drawText("wjx", 100, 100, paint);
        canvas.drawCircle(300, 100, 50, paint);
        canvas.drawBitmap(bitmap, null, new Rect(500, 50, 500+bitmap.getWidth(), 50+bitmap.getHeight()), paint);
    }
}
