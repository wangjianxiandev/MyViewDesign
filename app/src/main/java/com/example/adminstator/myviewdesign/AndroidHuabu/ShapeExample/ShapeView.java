package com.example.adminstator.myviewdesign.AndroidHuabu.ShapeExample;

import android.content.Context;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Path;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Region;
import android.graphics.drawable.ShapeDrawable;
import android.graphics.drawable.shapes.ArcShape;
import android.graphics.drawable.shapes.OvalShape;
import android.graphics.drawable.shapes.PathShape;
import android.graphics.drawable.shapes.RectShape;
import android.graphics.drawable.shapes.RoundRectShape;
import android.util.AttributeSet;
import android.view.View;

import org.w3c.dom.Attr;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/06/27
 * Time: 19:30
 */
public class ShapeView extends View {
    private ShapeDrawable shapeDrawable;

    public ShapeView(Context context) {
        super(context);
        init();
    }
    public ShapeView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
        init();
    }

    public ShapeView(Context context, AttributeSet attributeSet, int defStyle){
        super(context, attributeSet, defStyle);
        init();
    }

    private void init() {
        setLayerType(LAYER_TYPE_SOFTWARE,null);
//        //生成一个ShapeDrawable，并将这个形状的定义为矩形
//        shapeDrawable = new ShapeDrawable(new ArcShape(0, 300));
//        //设置shapeDrawable在空间中的显示位置（在当前控件中的位置）
//        shapeDrawable.setBounds(new Rect(50, 50, 200, 100));
//        //获取画笔，并将整个Drawable填充为黄色

//        float[] outerRadii = new float[]{12, 12, 12, 12, 0, 0, 0, 0};
//        RectF inset = new RectF(6,  6, 6, 6);
//        float[] innerRadii = new float[]{50, 12, 0, 0, 12, 50, 0, 0};
//        shapeDrawable = new ShapeDrawable(new RoundRectShape(outerRadii, inset, innerRadii));
//        Path path = new Path();
//        //注意这里此时的单位是份
//        path.moveTo(0, 0);
//        path.lineTo(100, 0);
//        path.lineTo(100, 100);
//        path.lineTo(0, 100);
//        path.close();
//        //首先我们要知道这里的单位是份的概念而不是px，所以为了对比，我们将shapeDrawable和画布大小设为一致
//        // 开始将shape 100， 100 可以发现它填满了控件如果使用的是px当然是不可能将其填满的，
//        // 将ShapeDrawable的高设置成200，则原来的只能占1/2，所以只能展示为控件的一半
//        shapeDrawable = new ShapeDrawable(new PathShape(path, 100, 200));
//        shapeDrawable.setBounds(new Rect(0, 0, 250, 150));
//        shapeDrawable.getPaint().setColor(Color.BLUE);
        Rect rect1 = new Rect(50, 0, 90, 150);
        Rect rect2 = new Rect(0, 50, 250, 100);
        Region region1 = new Region(rect1);
        Region region2 = new Region(rect2);

        region1.op(region2, Region.Op.XOR);
        shapeDrawable = new ShapeDrawable(new OwnShapeView(region1));
        shapeDrawable.setBounds(new Rect(0, 0, 250, 150));
        shapeDrawable.getPaint().setColor(Color.GRAY);
    }

    @Override
    protected void onDraw(Canvas canvas) {
        super.onDraw(canvas);
        //将shape实例画在画布上
        shapeDrawable.draw(canvas);
    }
}
