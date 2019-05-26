package com.example.adminstator.myviewdesign.InterpolatorOwn;

import android.animation.TimeInterpolator;

/**
 * Created with Android Studio.
 * Description:
 * User: wjx
 * Date: 2019-05-25
 * Time: 14:24
 */
public class MyInterpolator implements TimeInterpolator {
    @Override
    public float getInterpolation(float input) {
        //反向插值器
        return 1-input;
    }
}
