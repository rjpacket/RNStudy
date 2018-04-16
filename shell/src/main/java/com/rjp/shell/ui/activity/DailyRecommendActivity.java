package com.rjp.shell.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseActivity;
import com.rjp.shell.listviews.JCZQBiFenListView;
import com.rjp.shell.listviews.RecommendLotteryListView;

import butterknife.BindView;

public class DailyRecommendActivity extends BaseActivity {

    @BindView(R2.id.recommend_list_view)
    RecommendLotteryListView listView;

    public static void trendTo(Context context){
        context.startActivity(new Intent(context, DailyRecommendActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_daily_recommend);
    }

    @Override
    protected void initView() {
        setCommonTitle("每日推荐");

        listView.requestData();
    }
}
