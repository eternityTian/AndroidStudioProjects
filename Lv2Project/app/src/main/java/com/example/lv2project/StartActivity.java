package com.example.lv2project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;

public class StartActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_start);
        Intent intent = new Intent(this,MainActivity.class);
        new Thread(){
            @Override
            public void run() {
                super.run();
                try {
                    Thread.sleep(2000);
                    startActivity(intent);
                    finish();//结束StartActivity
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }.start();

    }
}