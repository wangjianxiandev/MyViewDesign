package com.example.adminstator.myviewdesign.OwnExample;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Point;
import android.util.AttributeSet;
import android.widget.ImageView;


/**
 * Created with Android Studio.
 * Description:
 * User: wjx
 * Date: 2019-05-29
 * Time: 17:05
 */
@SuppressLint("AppCompatCustomView")
public class FallingBallImageView extends ImageView {
    public FallingBallImageView(Context context, AttributeSet attributeSet){
        super(context, attributeSet);
    }
    //第二个参数对应的fallingPos
    public void setFallingPos(Point pos){
        layout(pos.x, pos.y, pos.x+getWidth(), pos.y+getHeight());
    }
}
