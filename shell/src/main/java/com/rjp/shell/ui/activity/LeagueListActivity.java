package com.rjp.shell.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseActivity;
import com.rjp.shell.listviews.ChampionListView;
import com.rjp.shell.listviews.LeagueListView;

import butterknife.BindView;

public class LeagueListActivity extends BaseActivity {

    @BindView(R2.id.league_list_view)
    LeagueListView listView;

    public static void trendTo(Context context){
        context.startActivity(new Intent(context, LeagueListActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_list);
    }

    @Override
    protected void initView() {
        setCommonTitle("足球联赛");

        listView.requestData();
    }
}
