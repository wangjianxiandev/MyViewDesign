package com.example.adminstator.myviewdesign.AndroidHuabu.ShapeExample;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Shader;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.OvalShape;
import android.util.AttributeSet;
import android.view.MotionEvent;
import android.view.View;

import com.example.adminstator.myviewdesign.R;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/28
 * Time: 12:32
 */
public class TelescopeView extends View {
    private Bitmap bitmap;
    private ShapeDrawable drawable;
    //放大镜的半径
    private static final int RADIUS = 80;
    //放大倍数
    private static final int FACTOR = 3;
    private final Matrix matrix = new Matrix();
    public TelescopeView(Context context){
        super(context);
        init();
    }

    public TelescopeView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        init();
    }
    public TelescopeView(Context context,AttributeSet attrs, int defStyle) {
        super(context, attrs, defStyle);
        init();
    }
    private void init(){
        setLayerType( LAYER_TYPE_SOFTWARE , null);
    }

    @Override
    public boolean onTouchEvent(MotionEvent event) {
        final int x = (int)event.getX();
        final int y = (int)event.getY();
        //绘制Shader的起始位置
        matrix.setTranslate(RADIUS - x * FACTOR, RADIUS -  y * FACTOR);
        drawable.getPaint().getShader().setLocalMatrix(matrix);
        drawable.setBounds(x - RADIUS, y - RADIUS, x + RADIUS, y  + RADIUS);
        invalidate();
        return true;
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        if(bitmap == null){
            Bitmap bitmap1 = BitmapFactory.decodeResource(getResources(), R.drawable.niuniu);
            bitmap = Bitmap.createScaledBitmap(bitmap1, getWidth(), getHeight(), false);
            BitmapShader shader = new BitmapShader(
                    Bitmap.createScaledBitmap(
                            bitmap,
                            bitmap.getWidth()*FACTOR,
                            bitmap.getHeight()*FACTOR, true),
                    Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
            drawable = new ShapeDrawable(new OvalShape());
            drawable.getPaint().setShader(shader);
            drawable.setBounds(0, 0, RADIUS * 2, RADIUS * 2);
        }
        canvas.drawBitmap(bitmap,0, 0,null);
        drawable.draw(canvas);
    }
}
