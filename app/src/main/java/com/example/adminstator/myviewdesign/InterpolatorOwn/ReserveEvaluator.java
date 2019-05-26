package com.example.adminstator.myviewdesign.InterpolatorOwn;

import android.animation.TypeEvaluator;

/**
 * Created with Android Studio.
 * Description:
 * User: wjx
 * Date: 2019-05-25
 * Time: 14:51
 */
public class ReserveEvaluator implements TypeEvaluator<Integer> {
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int startInt = startValue;
        //实现反向动画
        return (int)(endValue - fraction * (endValue-startInt));
    }
}
