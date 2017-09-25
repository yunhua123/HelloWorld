package com.yunhua.helloworld.activity.adapter;

import android.content.Context;
import android.support.v7.widget.RecyclerView;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.TextView;

import com.yunhua.helloworld.R;
import com.yunhua.helloworld.activity.entity.PersonInfo;

import java.util.List;

/**
 * Created by yunhua on 2017/9/24.
 */

public class MyRecyclerViewAdapter extends RecyclerView.Adapter<RecyclerView.ViewHolder> {

    private Context mContext;
    private List<PersonInfo> mListPerson;
    private LayoutInflater mLayoutInflater;

    public MyRecyclerViewAdapter(Context mContext, List<PersonInfo> mListPerson) {
        this.mContext = mContext;
        this.mListPerson = mListPerson;
        mLayoutInflater = LayoutInflater.from(mContext);

    }

    /**
     * 重写onCreateViewHolder方法，返回一个自定义的ViewHolder
     */
    public MyRecyclerViewViewHolder onCreateViewHolder(ViewGroup parent, int viewType) {

        View view = mLayoutInflater.inflate(R.layout.adapter_recyclerview, parent, false);
        MyRecyclerViewViewHolder myRecyclerViewViewHolder = new MyRecyclerViewViewHolder(view);

        return myRecyclerViewViewHolder;
    }

    /**
     * 填充onCreateViewHolder方法返回的holder中的控件
     */
    @Override
    public void onBindViewHolder(RecyclerView.ViewHolder holder, int position) {
        if (holder instanceof MyRecyclerViewViewHolder) {
            ((MyRecyclerViewViewHolder)holder).mHeadPortraitImageView.setImageResource(R.mipmap.ic_launcher);
            ((MyRecyclerViewViewHolder)holder).mNameTextView.setText(mListPerson.get(position).getName());
            ((MyRecyclerViewViewHolder)holder).mAgeTextView.setText(String.valueOf(mListPerson.get(position).getAge()));
            ((MyRecyclerViewViewHolder)holder).mGenderTextView.setText(mListPerson.get(position).getGender());
        }

    }

    @Override
    public int getItemCount() {
        return mListPerson.size();
    }

    class MyRecyclerViewViewHolder extends RecyclerView.ViewHolder {
        TextView mNameTextView;
        TextView mGenderTextView;
        TextView mAgeTextView;
        ImageView mHeadPortraitImageView;

        public MyRecyclerViewViewHolder(View itemView) {
            super(itemView);
            mAgeTextView = itemView.findViewById(R.id.tv_age);
            mGenderTextView = itemView.findViewById(R.id.tv_gender);
            mNameTextView = itemView.findViewById(R.id.tv_name);
            mHeadPortraitImageView = itemView.findViewById(R.id.iv_headPortrait);
        }
    }
}
