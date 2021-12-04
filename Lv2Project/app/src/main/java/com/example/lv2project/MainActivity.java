package com.example.lv2project;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.KeyEvent;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private ImageView mImgHead;
    private EditText mEtUsername;
    private EditText mEtPassword;
    private Button mBtnLogin;
    private TextView mTextForget;
    
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
        initLogin();
    }


    /**
     * 初始化View
     */
    private void initView() {
        mImgHead = findViewById(R.id.img_main_head);
        mEtUsername = findViewById(R.id.et_main_username);
        mEtPassword = findViewById(R.id.et_main_password);
        mBtnLogin = findViewById(R.id.btn_main_login);
        mTextForget = findViewById(R.id.tv_main_forget);
    }

    private void initLogin() {
        mBtnLogin.setOnClickListener(this);
        mTextForget.setOnClickListener(this);
    }

    @Override
    public void onClick(View v) {
        switch (v.getId()){
            case R.id.btn_main_login://登录
                login();
                break;
            case R.id.tv_main_forget://忘记账号或密码
                forgetInformation();
                break;

        }
    }

    /**
     * 忘记账号密码操作
     */
    private void forgetInformation(){
        startActivity(new Intent(this,ForgetActivity.class));
    }


    /**
     * 登录操作
     */
    private void login() {
        String username = mEtUsername.getText().toString();
        String password = mEtPassword.getText().toString();
        if (username.equals("admin") && password.equals("123456")){
            loginSuccess(username, password);//登陆成功
        }else{
            loginFailure();//登陆失败
        }
    }

    /**
     * 登陆成功
     */
    private void loginSuccess(String username, String password){
        Toast.makeText(this, "登陆成功", Toast.LENGTH_SHORT).show();
        Intent loginView = new Intent(this, ContentActivity.class);
        loginView.putExtra("username",username);
        loginView.putExtra("password",password);
        startActivity(loginView);
    }

    /**
     * 登录失败
     */
    private void loginFailure() {
        Toast.makeText(this,"账号或密码有误哦",Toast.LENGTH_SHORT).show();
    }

    private long mExitTime = 0L;

    @Override
    public boolean onKeyDown(int keyCode, KeyEvent event) {

        if (keyCode == KeyEvent.KEYCODE_BACK) {
            /*
            当当前时间大于上次按返回键2秒时
             */
            if (System.currentTimeMillis() - mExitTime > 2000){
                Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                mExitTime = System.currentTimeMillis();
                return false;
            }
        }

        return super.onKeyDown(keyCode, event);
    }
}