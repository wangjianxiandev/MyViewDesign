package com.example.adminstator.myviewdesign.PathCartoon;

import android.animation.AnimatorSet;
import android.animation.ObjectAnimator;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.Toast;

import com.example.adminstator.myviewdesign.AttrAnimator.AnimatorTestActivity;
import com.example.adminstator.myviewdesign.R;

public class PathDongHuaActivity extends AppCompatActivity {

    //声明开关状态
    private boolean mIsMenuOpen = false;
    private Button menu;
    private Button item1;
    private Button item2;
    private Button item3;
    private Button item4;
    private Button item5;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_path_dong_hua);
        menu = (Button)findViewById(R.id.menu);
        item1 = (Button)findViewById(R.id.item1);
        item2 = (Button)findViewById(R.id.item2);
        item3 = (Button)findViewById(R.id.item3);
        item4 = (Button)findViewById(R.id.item4);
        item5 = (Button)findViewById(R.id.item5);


        //设置各个按钮的响应事件，点击进行动画打开和关闭
        menu.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mIsMenuOpen){
                    mIsMenuOpen = true;
                    openMenu();
                }else{
                    Toast.makeText(PathDongHuaActivity.this, "点了"+v, Toast.LENGTH_SHORT).show();
                    mIsMenuOpen = false;
                    closeMenu();
                }
            }
        });
        item1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mIsMenuOpen){
                    mIsMenuOpen = true;
                    openMenu();
                }else{
                    Toast.makeText(PathDongHuaActivity.this, "点了"+v, Toast.LENGTH_SHORT).show();
                    mIsMenuOpen = false;
                    closeMenu();
                }
            }
        });
        item2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mIsMenuOpen){
                    mIsMenuOpen = true;
                    openMenu();
                }else{
                    Toast.makeText(PathDongHuaActivity.this, "点了"+v, Toast.LENGTH_SHORT).show();
                    mIsMenuOpen = false;
                    closeMenu();
                }
            }
        });
        item3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mIsMenuOpen){
                    mIsMenuOpen = true;
                    openMenu();
                }else{
                    Toast.makeText(PathDongHuaActivity.this, "点了"+v, Toast.LENGTH_SHORT).show();
                    mIsMenuOpen = false;
                    closeMenu();
                }
            }
        });
        item4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mIsMenuOpen){
                    mIsMenuOpen = true;
                    openMenu();
                }else{
                    Toast.makeText(PathDongHuaActivity.this, "点了"+v, Toast.LENGTH_SHORT).show();
                    mIsMenuOpen = false;
                    closeMenu();
                }
            }
        });

        item5.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!mIsMenuOpen){
                    mIsMenuOpen = true;
                    openMenu();
                }else{
                    Toast.makeText(PathDongHuaActivity.this, "点了"+v, Toast.LENGTH_SHORT).show();
                    mIsMenuOpen = false;
                    closeMenu();
                }
            }
        });
    }


    /**
     * 打开菜单项
     */
    private void openMenu() {
        doAnimation(item1, 0, 5, 300);
        doAnimation(item2, 1, 5, 300);
        doAnimation(item3, 2, 5, 300);
        doAnimation(item4, 3, 5, 300);
        doAnimation(item5, 4, 5, 300);
    }
    /**
     * 打开菜单项
     * @param view 传入的动画控件
     * @param index 当前应该计算的角度 90/4 * index
     * @param total 一共需要展现多少个动画
     * @param radius 半径大小
     */
    private void doAnimation(View view, int index, int total, int radius) {
        //如果是不展示状态就展现出来
        if(view.getVisibility() != View.VISIBLE){
            view.setVisibility(View.VISIBLE);
        }

        double degree = Math.toRadians((90*index)/(total - 1));
        int translationX = -(int)(radius * Math.sin(degree));
        int translationY = -(int)(radius * Math.cos(degree));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", 0, translationX),
                ObjectAnimator.ofFloat(view, "translationY", 0, translationY),
                ObjectAnimator.ofFloat(view, "scaleX", 0f, 1f),
                ObjectAnimator.ofFloat(view, "scaleY", 0f, 1f),
                ObjectAnimator.ofFloat(view ,"alpha", 0f, 1f));
        animatorSet.setDuration(500).start();
    }


    /**
     * 关闭菜单项
     */
    private void closeMenu() {
        closeAnimator(item1, 0, 5, 300);
        closeAnimator(item2, 1, 5, 300);
        closeAnimator(item3, 2, 5, 300);
        closeAnimator(item4, 3, 5, 300);
        closeAnimator(item5, 4, 5, 300);
    }

    private void closeAnimator(View view, int index, int total, int radius) {
        //如果是开着的状态就将其关闭
        if(view.getVisibility() == View.VISIBLE){
            view.setVisibility(View.GONE);
        }
        double degree = Math.toRadians((90*index)/total - 1);
//        double degree = Math.PI * index / ((total - 1) * 2);
        int translationX = -(int)(radius * Math.sin(degree));
        int translationY = -(int)(radius * Math.cos(degree));
        AnimatorSet animatorSet = new AnimatorSet();
        animatorSet.playTogether(
                ObjectAnimator.ofFloat(view, "translationX", translationX, 0),
                ObjectAnimator.ofFloat(view, "translationY", translationY, 0),
                ObjectAnimator.ofFloat(view, "scaleX", 1f, 0f),
                ObjectAnimator.ofFloat(view, "scaleY", 1f, 0f),
                ObjectAnimator.ofFloat(view, "alpha", 1f, 0f)
        );
        animatorSet.setDuration(500).start();
    }
}
