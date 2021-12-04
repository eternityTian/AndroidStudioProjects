package com.example.lv1project;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.util.DisplayMetrics;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;

import java.util.Random;

public class MainActivity extends AppCompatActivity {

    private Button mBtnNot;
    private int mWinWidth;//屏幕宽度
    private int mWinHeight;//屏幕高度

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initEvent();
        //获取屏幕宽度和高度
        DisplayMetrics displayMetrics = getResources().getDisplayMetrics();
        mWinWidth = displayMetrics.widthPixels;
        mWinHeight = displayMetrics.heightPixels;
    }

    private void initView(){//初始控件
        mBtnNot = findViewById(R.id.btn_main_not);
    }

    private void initEvent(){//初始监听事件
        mBtnNot.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                float x = new Random().nextInt(mWinWidth-v.getWidth());
                float y = new Random().nextInt(mWinHeight-v.getHeight());

                v.setX(x);
                v.setY(y);
            }
        });
    }

    /**
     * 拦截返回键
     */
    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK){
            return false;
        }
        return super.onKeyDown(keyCode,event);
    }
}