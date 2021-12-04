package com.example.lv2project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.widget.TextView;

public class ContentActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_content);
        init();
    }

    public void init(){
        Intent intent = this.getIntent();
        String name = intent.getStringExtra("username");
        //String password = intent.getStringExtra("password");//这个该作业不需要
        TextView textView = (TextView) findViewById(R.id.tv_content_hello);
        textView.setText("你好！"+name);//欢迎登录用户
    }
}