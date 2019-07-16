package com.example.adminstator.myviewdesign.fengzhuangkongjian.ViewHuiZhi;

import android.content.Context;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;

/**
 * Created with Android Studio.
 * Description:
 *
 * @author: 王拣贤
 * @date: 2019/07/08
 * Time: 15:09
 */

public class MyLinLayout extends ViewGroup {

    public MyLinLayout(Context context, AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void onMeasure(int widthMeasureSpec, int heightMeasureSpec) {
        super.onMeasure(widthMeasureSpec, heightMeasureSpec);
        //获取父类传过来的建议的宽度和高度值
        int measureWidth = MeasureSpec.getSize(widthMeasureSpec);
        int measureHeight = MeasureSpec.getSize(heightMeasureSpec);
        int measureWidthMode = MeasureSpec.getMode(widthMeasureSpec);
        int measureHeightMode = MeasureSpec.getMode(heightMeasureSpec);

        //记录每一行的高度
        int lineheight = 0;
        //记录每一行的宽度
        int linewidth = 0;
        //记录整个FlowLayout所占的宽度
        int width = 0;
        //记录整个FlowLayout所占的高度
        int height = 0;

        int count = getChildCount();
        //通过测量所有的子控件来决定他所占位置的大小
        for(int i = 0;i<count;i++){
            View child = getChildAt(i);
            measureChild(child, widthMeasureSpec, heightMeasureSpec);

            //考虑子控件的上下左右的边距问题
            MarginLayoutParams marginLayoutParams = (MarginLayoutParams)child.getLayoutParams();
            int childWidth = child.getMeasuredWidth() + marginLayoutParams.topMargin+marginLayoutParams.bottomMargin;
            int childHeight = child.getMeasuredHeight() + marginLayoutParams.leftMargin+marginLayoutParams.rightMargin;

            if(linewidth + childWidth > measureWidth){
                //换行
                width = Math.max(linewidth, childWidth);
                //向下加一行
                height += lineheight;
                //换行高度
                lineheight = childHeight;
                //目前只有一个子控件，所以可以直接赋值
                linewidth = childWidth;
            }else {
                lineheight = Math.max(lineheight, childHeight);
                linewidth += childWidth;
            }
            if(i == count-1){
                height += lineheight;
                width = Math.max(width, childWidth);
            }
        }
        setMeasuredDimension((measureWidthMode == MeasureSpec.EXACTLY)?measureWidth:width, (measureHeightMode== MeasureSpec.EXACTLY?measureHeight:height));

    }

    @Override
    protected void onLayout(boolean changed, int l, int t, int r, int b) {
        int count = getChildCount();
        //累加当前行的行高
        int lineHeight = 0;
        //累加当前行的行宽
        int lineWidth = 0;
        //当前控件的left和top坐标
        int top = 0, left = 0;
        for(int i = 0;i<count;i++){
            View child = getChildAt(i);

            MarginLayoutParams marginLayoutParams = (MarginLayoutParams)child.getLayoutParams();

            int childHeight = child.getMeasuredHeight()+marginLayoutParams.topMargin+marginLayoutParams.bottomMargin;
            int childWidth = child.getMeasuredWidth()+marginLayoutParams.leftMargin+marginLayoutParams.rightMargin;
            if(childWidth + lineWidth > getMeasuredWidth()){
                //如果换行
                top += lineHeight;
                left = 0;
                lineHeight = childHeight;
                lineWidth = childWidth;
            }else{
                lineHeight = Math.max(lineHeight,childHeight);
                lineWidth += childWidth;
            }
            int lc = left + marginLayoutParams.leftMargin;
            int tc = top + marginLayoutParams.topMargin;
            int rc = lc + child.getMeasuredWidth();
            int bc = tc + child.getMeasuredHeight();

            child.layout(lc, tc, rc, bc);
            left+=childWidth;
        }
    }


    /**
     * 在container()初始化子空间时，会调用generateLayoutParams(LayoutParams p)来为子控件生成对应的布局属性，
     * 但是只是默认生成layout_width, layout_height所对应的布局参数，
     * 即在正常情况下调用generateLayoutParams()函数生成的，
     * 所以说正常情况下调用该函数生成的LayoutParams实例是不可以获取到margin的值的
     * @param p
     * @return
     */
    @Override
    protected LayoutParams generateLayoutParams(LayoutParams p) {
        return new MarginLayoutParams(p);
    }

    /**
     * 从指定的xml中获取对应的layout_width和layout_height值
     * @param attrs
     * @return
     */
    @Override
    public LayoutParams generateLayoutParams(AttributeSet attrs) {
        return new MarginLayoutParams(getContext(), attrs);
    }

    /**
     *如果使用默认的构造函数，就生成layout_width="wrap_content"和layout_height="wrap_content"对应的参数
     * @return
     */
    @Override
    protected LayoutParams generateDefaultLayoutParams() {
        return new MarginLayoutParams(LayoutParams.MATCH_PARENT,  LayoutParams.MATCH_PARENT);
    }
}
