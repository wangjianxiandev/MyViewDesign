package com.example.adminstator.myviewdesign.CircleBitmapTest;

import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.BitmapShader;
import android.graphics.Canvas;
import android.graphics.Matrix;
import android.graphics.Paint;
import android.graphics.Path;
import android.graphics.PorterDuff;
import android.graphics.PorterDuffXfermode;
import android.graphics.Shader;
import android.media.Image;
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
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_demo01);
        demo01 = (ImageView)findViewById(R.id.demo01);
        demo02 = (ImageView)findViewById(R.id.demo02);
        demo03 = (ImageView)findViewById(R.id.demo03);
        demo04 = (ImageView)findViewById(R.id.demo04);
        demo05 = (ImageView) findViewById(R.id.demo05);
        Bitmap bitmapsrc = BitmapFactory.decodeResource(getResources(), R.drawable.niuniu);
        Bitmap bitmapres1 = createRoundPhoto1(bitmapsrc);
        demo01.setImageBitmap(bitmapres1);

        Bitmap bitmapres2 = createRoundPhoto2(bitmapsrc);
        demo02.setImageBitmap(bitmapres2);

        Bitmap bitmapres3 = createRoundPhoto3(bitmapsrc);
        demo03.setImageBitmap(bitmapres3);

        Bitmap bitmapres4 = createRoundScalePhoto(bitmapsrc, 330);
        demo04.setImageBitmap(bitmapres4);
//
//        Bitmap bitmapres5 = createRoundPhoto4(bitmapsrc, 330);
//        demo05.setImageBitmap(bitmapres5);





    }
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

    private Bitmap createRoundPhoto2(Bitmap bitmap){
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

    private Bitmap createRoundPhoto3(Bitmap bitmap){
        int width = bitmap.getWidth();
        Paint paint = new Paint();
        paint.setAntiAlias(true);
        Bitmap circleBitmap = Bitmap.createBitmap(width, width, Bitmap.Config.ARGB_8888);
        Canvas canvas = new Canvas(circleBitmap);
        Path path = new Path();
        path.addCircle(width/2, width/2, width/2, Path.Direction.CW);
        canvas.clipPath(path);
        canvas.drawBitmap(bitmap, 0, 0, paint);
        return circleBitmap;
    }

//    private Bitmap createRoundPhoto4(Bitmap bitmap, int imageViewSize){
//        if(bitmap == null){
//            return null;
//        }
//        float scaleSize = ((float) imageViewSize) / bitmap.getWidth();
//        Matrix matrix = new Matrix();
//        matrix.setScale(scaleSize, scaleSize);
//        Bitmap output = Bitmap.createBitmap(bitmap, 0, 0, bitmap.getWidth(), bitmap.getHeight(), matrix, false);
//        Canvas canvas = new Canvas(output);
//        Paint paint = new Paint();
//        paint.setAntiAlias(true);
//        paint.setXfermode(new PorterDuffXfermode(PorterDuff.Mode.DST_OUT));
//        canvas.drawCircle(imageViewSize / 2.0f, imageViewSize / 2.0f, imageViewSize / 2.0f, paint);
//        canvas.scale(1 / scaleSize, 1/ scaleSize, imageViewSize / 2/0f, imageViewSize / 2.0f);
//        bitmap.recycle();
//        return output;
//    }

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
