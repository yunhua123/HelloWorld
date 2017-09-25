package com.yunhua.helloworld.activity;

import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.support.v7.widget.DefaultItemAnimator;
import android.support.v7.widget.LinearLayoutManager;
import android.support.v7.widget.OrientationHelper;
import android.support.v7.widget.RecyclerView;

import com.yunhua.helloworld.R;
import com.yunhua.helloworld.activity.adapter.MyRecyclerViewAdapter;
import com.yunhua.helloworld.activity.entity.PersonInfo;

import java.util.ArrayList;
import java.util.List;

public class RecyclerViewActivity extends AppCompatActivity {

    RecyclerView mRecyclerView;
    List<PersonInfo> listPerson;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_recycler_view);
        initView();
        initData();
        MyRecyclerViewAdapter adapter=new MyRecyclerViewAdapter(this,listPerson);
        LinearLayoutManager layoutManager=new LinearLayoutManager(this);
        //设置为垂直布局，这也是默认的
        layoutManager.setOrientation(OrientationHelper.VERTICAL);
        //设置布局管理器
        mRecyclerView.setLayoutManager(layoutManager);
        //设置adapter
        mRecyclerView.setAdapter(adapter);
        //设置增加或删除条目的动画
        mRecyclerView.setItemAnimator(new DefaultItemAnimator());

    }

    private void initData() {
        listPerson=new ArrayList<>();
        for (int i=0; i < 10; i++){
            PersonInfo personInfo=new PersonInfo();
            personInfo.setAge(i);
            personInfo.setName("姓名" + i);
           if(i % 2 == 0){
               personInfo.setGender("性别：男");
           }else{
               personInfo.setGender("性别：女");
           }
            listPerson.add(personInfo);
        }
    }

    private void initView() {
        mRecyclerView= (RecyclerView) findViewById(R.id.rv_recyclerView);
    }
}
