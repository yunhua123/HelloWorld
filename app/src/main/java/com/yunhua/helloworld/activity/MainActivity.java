package com.yunhua.helloworld.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;

import com.yunhua.helloworld.R;

public class MainActivity extends AppCompatActivity implements View.OnClickListener{

    private Button mRecyclerViewDemo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
        initView();
    }

    /**
     * 初始化组件
     * */
    private void initView() {
        mRecyclerViewDemo= (Button) findViewById(R.id.btn_recyclerView_demo);
    }

    @Override
    public void onClick(View view) {
        switch (view.getId()){
            case R.id.btn_recyclerView_demo:
                jumpIntent(RecyclerViewActivity.class);
                break;
        }
    }

    private void jumpIntent(Class className){
        Intent intent=new Intent(MainActivity.this,className);
        startActivity(intent);
    }
//    HAHHASHDLJASHDLSA
}
