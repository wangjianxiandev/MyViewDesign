package com.example.adminstator.myviewdesign.huitujinjie.faguang;

import android.content.Context;
import android.graphics.BlurMaskFilter;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Paint;
import android.util.AttributeSet;
import android.view.View;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/18
 * Time: 17:28
 */
public class BlurMaskFliterView extends View {
    //内发光
    private Paint paintIn;
    //外发光
    private Paint paintSo;
    //内外发光
    private Paint paintNo;
    //仅显示发光效果
    private Paint paintOu;
    public BlurMaskFliterView(Context context, AttributeSet attrs) {
        super(context, attrs);

        setLayerType(LAYER_TYPE_SOFTWARE, null);
        paintIn = new Paint();
        paintIn.setColor(Color.BLACK);
        paintIn.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.INNER));

        paintSo = new Paint();
        paintSo.setColor(Color.BLACK);
        paintSo.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.SOLID));


        paintNo = new Paint();
        paintNo.setColor(Color.BLACK);
        paintNo.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.NORMAL));

        paintOu = new Paint();
        paintOu.setColor(Color.BLACK);
        paintOu.setMaskFilter(new BlurMaskFilter(50, BlurMaskFilter.Blur.OUTER));
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        canvas.drawCircle(200, 200, 100, paintIn);
        canvas.drawCircle(400, 200, 100, paintSo);
        canvas.drawCircle(200, 400, 100, paintNo);
        canvas.drawCircle(400, 400, 100, paintOu);

    }
}
