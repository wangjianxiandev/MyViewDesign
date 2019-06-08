package com.example.adminstator.myviewdesign.PropertyValuesHolderTest;

import android.annotation.SuppressLint;
import android.content.Context;
import android.util.AttributeSet;
import android.widget.TextView;


/**
 * Created with Android Studio.
 * Description:
 * User: wjx
 * Date: 2019-06-08
 * Time: 18:50
 */
@SuppressLint("AppCompatCustomView")
public class MyTextView extends TextView {
    public MyTextView(Context context, AttributeSet attributeSet) {
        super(context,attributeSet);
    }

    public void setCharText(Character charText){
        setText(String.valueOf(charText));
    }
}
