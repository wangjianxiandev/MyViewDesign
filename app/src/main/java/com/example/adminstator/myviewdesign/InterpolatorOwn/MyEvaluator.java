package com.example.adminstator.myviewdesign.InterpolatorOwn;

import android.animation.TypeEvaluator;

/**
 * Created with Android Studio.
 * Description:
 * User: wjx
 * Date: 2019-05-25
 * Time: 14:45
 */
public class MyEvaluator implements TypeEvaluator<Integer> {
    @Override
    public Integer evaluate(float fraction, Integer startValue, Integer endValue) {
        int startInt = startValue;
        //在实际的基础上加200
        return (int)(200  + startInt + fraction*(endValue-startInt));
    }
}
