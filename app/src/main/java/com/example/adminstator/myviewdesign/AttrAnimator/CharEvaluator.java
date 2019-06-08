package com.example.adminstator.myviewdesign.AttrAnimator;

import android.animation.TypeEvaluator;

/**
 * Created with Android Studio.
 * Description:
 * User: wjx
 * Date: 2019-05-28
 * Time: 21:01
 */
public class CharEvaluator implements TypeEvaluator<Character> {


    @Override
    public Character evaluate(float fraction, Character startValue, Character endValue) {
        int startInt = (int)startValue;
        int endInt = (int)endValue;
        int curValue = (int) (startInt+fraction*(endInt-startInt));
        char result = (char)curValue;
        return result;
    }
}
