package com.example.lv2project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.Toast;

public class ForgetActivity extends AppCompatActivity implements View.OnClickListener {

    private EditText mEtSchool;
    private Button mBtnConfirm;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_forget);
        initView();
        initListener();
    }

    /**
     * 初始化View
     */
    private void initView() {
         mEtSchool = findViewById(R.id.et_forget_information);
         mBtnConfirm = findViewById(R.id.btn_forget_confirm);
    }

    private void initListener(){
        mBtnConfirm.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_forget_confirm:
                confirm();
                break;
        }
    }

    private void confirm() {
        String mySchool = mEtSchool.getText().toString();
        if (mySchool.equals("重庆邮电大学")) {
            System.out.println("111");
            confirmSuccess();
        }else {
            System.out.println("2222");
            confirmFailure();
        }
    }

    /**
     * 验证成功
     */
    private void confirmSuccess(){
        Toast.makeText(this, "你的账号是admin,密码是123456", Toast.LENGTH_SHORT).show();
    }

    /**
     * 验证失败
     */
    private void confirmFailure() {
        Toast.makeText(this,"密保问题错误",Toast.LENGTH_SHORT).show();
    }

}