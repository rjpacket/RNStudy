package com.rjp.shell.ui.activity;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseActivity;
import com.rjp.shell.listviews.SaveNewsListView;

import butterknife.BindView;

public class SaveNewsActivity extends BaseActivity {

    @BindView(R2.id.save_list_view)
    SaveNewsListView listView;

    public static void trendTo(Context context){
        context.startActivity(new Intent(context, SaveNewsActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_save_news);
    }

    @Override
    protected void initView() {
        setCommonTitle("收藏新闻");
        listView.requestData();
    }
}
