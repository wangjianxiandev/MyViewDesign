package com.example.adminstator.myviewdesign.RoundImage;

import android.app.Activity;
import android.os.Bundle;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.adminstator.myviewdesign.PaintDesign.PaintTest;
import com.example.adminstator.myviewdesign.R;
import com.example.adminstator.myviewdesign.RegionTest.RegionTest;

/**
 * Created with Android Studio.
 * Description:
 * User: wjx
 * Date: 2019-05-18
 * Time: 13:24
 */
public class CustomViewActivity extends Activity {
    @Override
    protected void onCreate(Bundle savedInstanceState){
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        RelativeLayout rootView = (RelativeLayout) findViewById(R.id.root);
        TextView textView = (TextView) findViewById(R.id.text);
        Button button = new Button(this);
//        LinearLayout.LayoutParams layoutParams = new LinearLayout.LayoutParams(LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.MATCH_PARENT);
        RelativeLayout.LayoutParams layoutParams = new RelativeLayout.LayoutParams(RelativeLayout.LayoutParams.WRAP_CONTENT, RelativeLayout.LayoutParams.WRAP_CONTENT);
        //相对位置属性,第一个参数为相对位置,第二个参数为控件
        layoutParams.addRule(RelativeLayout.BELOW, R.id.text);
        //将控件按照后面的参数放到布局中
        rootView.addView(button, layoutParams);
    }
}
