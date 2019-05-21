package com.example.adminstator.myviewdesign.RoundImage;

import android.content.Context;
import android.graphics.Bitmap;
import android.graphics.BitmapFactory;
import android.graphics.Canvas;
import android.graphics.Rect;
import android.graphics.Region;
import android.util.AttributeSet;
import android.view.View;

import com.example.adminstator.myviewdesign.R;

/**
 * Created with Android Studio.
 * Description:
 * User: wjx
 * Date: 2019-05-18
 * Time: 12:46
 */
public class ClipRView extends View {
    private Bitmap bitmap;
    private int clipWidth =  0;
    private int width;
    private int height;
    private static final int CLIP_HEIGHT = 30;
    private Region region;
    public ClipRView(Context context, AttributeSet attrs) {
        super(context, attrs);
        init();
    }

    private void init(){
        setLayerType(LAYER_TYPE_SOFTWARE ,null);
        bitmap = BitmapFactory.decodeResource(getResources(), R.drawable.niuniu);
        width = bitmap.getWidth();
        height = bitmap.getHeight();
        region = new Region();
    }
    @Override
    protected void onDraw(Canvas canvas){
        //由于对Region反复使用,所以在每次使用前都需要清空
        region.setEmpty();

        int i = 0;
        while(i *CLIP_HEIGHT <= height){
            if(i%2==0){
                region.union(new Rect(0, i*CLIP_HEIGHT, clipWidth, (i+1)*CLIP_HEIGHT));
            }else{
                region.union(new Rect(width-clipWidth, i*CLIP_HEIGHT, width, (i+1)*CLIP_HEIGHT));
            }
            i++;
        }




    }
}
