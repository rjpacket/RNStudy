package com.rjp.shell.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseActivity;
import com.rjp.shell.listviews.TrendLotteryListView;

import butterknife.BindView;

public class TrendListActivity extends BaseActivity {

    @BindView(R2.id.trend_list_view)
    TrendLotteryListView trendListView;

    public static void trendTo(Context context){
        Intent intent = new Intent(context, TrendListActivity.class);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trend_list);
    }

    @Override
    protected void initView() {
        setCommonTitle("更多走势图");

        trendListView.requestData();
    }
}
