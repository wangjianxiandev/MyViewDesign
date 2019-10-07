package com.example.adminstator.myviewdesign.LionTest;

import android.graphics.Color;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentManager;
import android.support.v4.app.FragmentTransaction;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.adminstator.myviewdesign.R;

import org.w3c.dom.Text;

public class LionTestActivity extends AppCompatActivity implements View.OnClickListener {
    private RelativeLayout layout_one;
    private RelativeLayout layout_two;
    private RelativeLayout layout_three;
    private RelativeLayout layout_four;

    private ImageView ione;
    private ImageView itwo;
    private ImageView ithree;
    private ImageView ifour;

    private TextView tone;
    private TextView ttwo;
    private TextView tthree;
    private TextView tfour;


    private Fragment[] fragments;
    private Fragment OneFragment;
    private Fragment TwoFragment;
    private Fragment ThreeFragment;
    private Fragment FourFragment;
    private int currentIndex;
    private int index;

    private int selectColor;
    private int unSelelctColor;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_lion_test);
        getWindow().getDecorView().setPadding(24, 0, 24, 0);
        init();
    }

    private void init() {
        initView();
        initEvent();
        initData();
    }

    private void initView() {
        layout_one = findViewById(R.id.layout_home);
        layout_two = findViewById(R.id.layout_two);
        layout_three = findViewById(R.id.layout_three);
        layout_four = findViewById(R.id.layout_four);

        ione = findViewById(R.id.image_home);
        itwo = findViewById(R.id.image_two);
        ithree = findViewById(R.id.image_three);
        ifour = findViewById(R.id.image_four);


        tone = findViewById(R.id.tv_home);
        ttwo = findViewById(R.id.tv_two);
        tthree = findViewById(R.id.tv_three);
        tfour = findViewById(R.id.tv_four);

        OneFragment = new OneFragment();
        ThreeFragment = new TwoFragment();
        ThreeFragment = new ThreeFragment();
        FourFragment = new FourFragment();
    }

    private void initEvent() {
        layout_one.setOnClickListener(this);
        layout_two.setOnClickListener(this);
        layout_three.setOnClickListener(this);
        layout_four.setOnClickListener(this);
    }

    private void initData() {
        selectColor = Color.GRAY;
        unSelelctColor = Color.RED;
        fragments = new Fragment[4];
        fragments[0] = OneFragment;
        fragments[1] = TwoFragment;
        fragments[2] = ThreeFragment;
        fragments[3] = FourFragment;
        getSupportFragmentManager().beginTransaction().add(R.id.frame_container, fragments[0]).commit();
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.layout_home:
                index = 0;
                break;
            case R.id.layout_two:
                index = 1;
                break;
            case R.id.layout_three:
                index = 2;
                break;
            case R.id.layout_four:
                index = 3;
                break;
        }
        if(currentIndex != index){
            FragmentManager fragmentManager = getSupportFragmentManager();
            FragmentTransaction fragmentTransaction = fragmentManager.beginTransaction();
            fragmentTransaction.hide(fragments[currentIndex]);
            if(!fragments[index].isAdded()){
                fragmentTransaction.add(R.id.frame_container, fragments[index]);
            }
            fragmentTransaction.show(fragments[index]).commit();
        }
        currentIndex = index;
    }
}
