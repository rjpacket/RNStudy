package com.rjp.shell.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseActivity;
import com.rjp.shell.listviews.ChampionListView;
import com.rjp.shell.listviews.RecommendLotteryListView;

import butterknife.BindView;

public class ChampionActivity extends BaseActivity {

    @BindView(R2.id.champion_list_view)
    ChampionListView listView;

    public static void trendTo(Context context){
        context.startActivity(new Intent(context, ChampionActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_champion);
    }

    @Override
    protected void initView() {
        setCommonTitle("世界杯队伍");

        listView.requestData();
    }
}
