package com.example.adminstator.myviewdesign.AndroidHuabu.fengzhuangkongjian;

import android.annotation.SuppressLint;
import android.content.Context;
import android.content.res.TypedArray;
import android.util.AttributeSet;
import android.widget.TextView;

import com.example.adminstator.myviewdesign.R;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/07/05
 * Time: 19:48
 */
public class MyTextView extends android.support.v7.widget.AppCompatTextView {
    public MyTextView(Context context, AttributeSet attributeSet) {
        super(context, attributeSet);
        TypedArray typedArray = context.obtainStyledAttributes(attributeSet, R.styleable.MyTextView);
        float headerHeight = typedArray.getDimension(R.styleable.MyTextView_headerHeight, -1);
        int age = typedArray.getInt(R.styleable.MyTextView_age, -1);
        typedArray.recycle();
        this.setText("headerHeight:"+headerHeight + "age:"+age);
    }
}
