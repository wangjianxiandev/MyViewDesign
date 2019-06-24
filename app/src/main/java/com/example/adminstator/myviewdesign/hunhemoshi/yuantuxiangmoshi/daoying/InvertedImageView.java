package com.example.adminstator.myviewdesign.hunhemoshi.yuantuxiangmoshi.daoying;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.RectF;
import android.util.AttributeSet;
import android.view.View;

import com.example.adminstator.myviewdesign.R;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/21
 * Time: 16:58
 */
public class InvertedImageView extends View {
    private Paint paint;
    private Bitmap BmpDST, BmpSRC, BmpRevert;
    public InvertedImageView(Context context, AttributeSet attrs) {
        super(context, attrs);
        setLayerType(LAYER_TYPE_SOFTWARE, null);
        paint = new Paint();
        BmpDST = BitmapFactory.decodeResource(getResources(), R.drawable.dog_invert_shade, null);
        BmpSRC = BitmapFactory.decodeResource(getResources(), R.drawable.dog,null);
        Matrix matrix = new Matrix();
        matrix.setScale(1F, -1F);
        //翻转小狗图像
        BmpRevert = Bitmap.createBitmap(BmpSRC, 0, 0, BmpSRC.getWidth(),
                BmpSRC.getHeight(), matrix,  true);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        int width = getWidth() / 2;
        int height = width * BmpDST.getHeight()/BmpDST.getWidth();
        //画出小狗图像
        canvas.drawBitmap(BmpSRC, null, new RectF(0, 0, width, height), paint);

        //将画布下移，画出倒影
        int layerId = canvas.saveLayer(0, 0, getWidth(), getHeight(), null, Canvas.ALL_SAVE_FLAG);
        canvas.translate(0, height);
        //将小狗图的翻转和背景图结合
        canvas.drawBitmap(BmpDST, null, new RectF(0, 0, width, height), paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(BmpRevert, null, new RectF(0, 0, width, height), paint);
        paint.setXfermode(null);
        canvas.restoreToCount(layerId);
    }
}
