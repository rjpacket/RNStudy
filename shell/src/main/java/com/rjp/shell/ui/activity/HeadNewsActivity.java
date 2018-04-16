package com.rjp.shell.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseActivity;
import com.rjp.shell.listviews.SaveNewsListView;
import com.rjp.shell.listviews.WYNewsListView;

import butterknife.BindView;

public class HeadNewsActivity extends BaseActivity {

    @BindView(R2.id.wynews_list_view)
    WYNewsListView listView;

    public static void trendTo(Context context){
        context.startActivity(new Intent(context, HeadNewsActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_head_news);
    }

    @Override
    protected void initView() {
        setCommonTitle("头条快报");

        listView.requestData("toutiao");
    }
}
