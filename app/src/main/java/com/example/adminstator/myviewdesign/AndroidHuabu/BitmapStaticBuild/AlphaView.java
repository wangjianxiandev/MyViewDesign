package com.example.adminstator.myviewdesign.AndroidHuabu.BitmapStaticBuild;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;
import android.widget.ImageView;

import com.example.adminstator.myviewdesign.R;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/07/01
 * Time: 13:43
 */
public class AlphaView extends View {
    private Paint paint;
    private ImageView imageView;
    public AlphaView(Context context, AttributeSet attrs) {
        super(context, attrs);
        paint = new Paint();
        imageView = (ImageView)findViewById(R.id.alpha);
        Bitmap srcBmp = BitmapFactory.decodeResource(getResources(), R.drawable.cat_dog);
        Bitmap bitmap = Bitmap.createBitmap(srcBmp.getWidth(), srcBmp.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(bitmap);
        Paint paint = new Paint();
        paint.setColor(Color.GRAY);
        canvas.drawBitmap(srcBmp.extractAlpha(), 0, 0, paint);
        imageView.setImageBitmap(bitmap);
        srcBmp.recycle();
    }
}
