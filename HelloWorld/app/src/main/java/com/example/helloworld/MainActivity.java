package com.example.helloworld;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;
import android.widget.Toast;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        //为按钮添加监听器
        Button button = (Button) findViewById(R.id.my_button);

        TextView textView = (TextView) findViewById(R.id.my_text);
        //匿名类方式来注册监听器
        button.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                switch (v.getId()){
                    case R.id.my_button:
                        textView.setText("龚峰是9班大卷王");
                        Toast.makeText(MainActivity.this,"你已经获得本班最高机密",Toast.LENGTH_SHORT).show();
                        break;
                    default:
                        break;
                }
            }
        });
    }
}