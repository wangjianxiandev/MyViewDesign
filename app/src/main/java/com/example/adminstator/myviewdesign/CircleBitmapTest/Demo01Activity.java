package com.example.adminstator.myviewdesign.CircleBitmapTest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Color;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.PaintFlagsDrawFilter;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Rect;
import android.graphics.RectF;
import android.graphics.Shader;
import android.graphics.drawable.BitmapDrawable;
import android.media.Image;
import android.support.annotation.ColorLong;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.util.Log;
import android.widget.ImageView;

import com.example.adminstator.myviewdesign.R;

public class Demo01Activity extends AppCompatActivity {

    private ImageView demo01;
    private ImageView demo02;
    private ImageView demo03;
    private ImageView demo04;
    private ImageView demo05;
    private ImageView demo06;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo01);
        demo01 = findViewById(R.id.demo01);
        demo02 = findViewById(R.id.demo02);
        demo03 = findViewById(R.id.demo03);
        demo04 = findViewById(R.id.demo04);
        demo05 = findViewById(R.id.demo05);
        demo06 = findViewById(R.id.demo06);
        //由于用 BitmapFactory 解析出来的 bitmap 对象不能更改，下面的每一个方法都需要创建一个 bitmap 副本才能对其进行编辑
        Bitmap bitmapsrc = BitmapFactory.decodeResource(getResources(), R.drawable.niuniu);
        Bitmap bitmapres1 = createRoundPhoto1(bitmapsrc);
        demo01.setImageBitmap(bitmapres1);

        Bitmap bitmapres2 = createRoundPhoto2(bitmapsrc);
        demo02.setImageBitmap(bitmapres2);

        Bitmap bitmapres3 = createRoundPhoto3(bitmapsrc);
        demo03.setImageBitmap(bitmapres3);

        Bitmap bitmapres4 = createRoundPhoto4(bitmapsrc);
        demo04.setImageBitmap(bitmapres4);

        Bitmap bitmapres5 = createRoundPhoto5(bitmapsrc, 330);
        demo05.setImageBitmap(bitmapres5);

        Bitmap bitmapres6 = createRoundScalePhoto(bitmapsrc, 330);
        demo06.setImageBitmap(bitmapres6);
        
    }

    /**
     * 直接在画布上绘制圆形
     * 效果：边缘存在锯齿
     *
     * @param bitmap
     * @return
     */
    private Bitmap createRoundPhoto1(Bitmap bitmap){
        int width = bitmap.getWidth();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap circleBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(circleBitmap);
        canvas.drawCircle(width / 2, width / 2, width / 2, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return circleBitmap;
    }
    /**
     * 从绘制圆角矩形的方法演变而来，效果：边缘存在锯齿
     *
     * @param bitmap
     * @return
     */
    private Bitmap createRoundPhoto2(Bitmap bitmap){
        int size = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap circleBitmap = Bitmap.createBitmap(size, size, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(circleBitmap);
        canvas.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint();
        Rect rect = new Rect(0, 0, size, size);
        RectF rectF = new RectF(rect);
        paint.setColor(Color.RED);
        paint.setAntiAlias(true);
        canvas.drawCircle( size / 2, size / 2, size / 2, paint);
        Rect src = new Rect(0, 0, size, size);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(bitmap, src, rectF, paint);
        return circleBitmap;
    }

    /**
     * 上面说过的画圆形比较出来BitmapShader是比较好的实现方式，clipPath会存在锯齿， 效果：边缘存在锯齿
     *
     * @param bitmap
     * @return
     */
    private Bitmap createRoundPhoto3(Bitmap bitmap){
        int width = bitmap.getWidth();
        Paint paint = new Paint();
        PaintFlagsDrawFilter paintFlagsDrawFilter = new PaintFlagsDrawFilter(0, Paint.ANTI_ALIAS_FLAG | Paint.FILTER_BITMAP_FLAG);
        paint.setAntiAlias(true);
        paint.setFilterBitmap(true);
        Bitmap circleBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(circleBitmap);
        Path path = new Path();
        path.addCircle(width/2, width/2, width/2, Path.Direction.CW);
        canvas.clipPath(path);
        //对canvas设置抗锯齿的滤镜，防止变化canvas引起画质降低
        canvas.setDrawFilter(paintFlagsDrawFilter);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return circleBitmap;
    }

    /**
     * 使用BitmapShader---画圆形图像比较好的实现方式是用BitmapShader
     * 但是在实际项目中下面的方法实现的还会存在小部分的锯齿效果，判断出问题存在于画布的缩放
     * 效果：边缘存在锯齿
     *
     * @param bitmap
     * @return
     */
    private Bitmap createRoundPhoto4(Bitmap bitmap){
        int width = bitmap.getWidth();
        BitmapShader bitmapShader = new BitmapShader(bitmap, Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap circleBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(circleBitmap);
        paint.setShader(bitmapShader);
        canvas.drawCircle(width/2, width/2, width/2, paint);
        return circleBitmap;
    }



    /**
     * 上面分析出是画布的大小变化，那么实现画布的缩放，效果：边缘锯齿减少
     *
     * @param bitmap
     * @param imageViewSize
     * @return
     */
    private Bitmap createRoundPhoto5(Bitmap bitmap, int imageViewSize){
        if(bitmap == null){
            return null;
        }
        float scaleSize = ((float) imageViewSize) / bitmap.getWidth();
        Matrix matrix = new Matrix();
        matrix.setScale(scaleSize, scaleSize);
        Bitmap scaleRes = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, true);
        //直接在scaleRes上面进行裁剪会发生错误
        Bitmap output = Bitmap.createBitmap(scaleRes.getWidth(), scaleRes.getHeight(), Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(output);
        canvas.drawARGB(0, 0, 0, 0);
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        canvas.drawCircle(scaleRes.getWidth() / 2.0f, scaleRes.getWidth() / 2.0f, scaleRes.getWidth() / 2.0f, paint);
        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.SRC_IN));
        canvas.drawBitmap(scaleRes, 0, 0, paint);
        canvas.scale(1 / scaleSize, 1/ scaleSize, scaleRes.getWidth() / 2.0f, scaleRes.getWidth() / 2.0f);
        return output;
    }

    /**
     * 将画布的缩放和BitmapShader结合起来，效果：消除锯齿效果（实际场景：96x96的bitmap放大到原960x960的场景，边缘模糊度消除
     *
     * @param bitmap
     * @param imageViewSize
     * @return
     */
    private Bitmap createRoundScalePhoto(Bitmap bitmap, int imageViewSize){
        if(bitmap == null){
            return null;
        }
        int size = Math.min(bitmap.getWidth(), bitmap.getHeight());
        Bitmap output = Bitmap.createBitmap(imageViewSize, imageViewSize, Bitmap.Config.ARGB_8888);
        float scaleNum = 0;
        if(size != 0) {
            scaleNum = imageViewSize / size;
        }
        float scaleNumReciprocal = size / imageViewSize;
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        BitmapShader bitmapShader = new BitmapShader(bitmap , Shader.TileMode.CLAMP, Shader.TileMode.CLAMP);
        Matrix matrix = new Matrix();
        matrix.setScale(scaleNum, scaleNum);
        bitmapShader.setLocalMatrix(matrix);
        paint.setShader(bitmapShader);
        Canvas canvas = new Canvas(output);
        canvas.drawCircle(imageViewSize / 2.0f, imageViewSize / 2.0f, imageViewSize / 2.0f, paint);
        canvas.scale(scaleNumReciprocal, scaleNumReciprocal, imageViewSize / 2/0f, imageViewSize / 2.0f);
        bitmap.recycle();
        return output;
    }
}
