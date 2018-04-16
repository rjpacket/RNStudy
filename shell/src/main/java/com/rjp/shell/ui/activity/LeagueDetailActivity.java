package com.rjp.shell.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.flyco.tablayout.listener.OnTabSelectListener;
import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseActivity;
import com.rjp.shell.listviews.ChampionListView;
import com.rjp.shell.model.TabEntity;
import com.rjp.shell.ui.fragment.PlayerFragment;
import com.rjp.shell.ui.fragment.RankFragment;
import com.rjp.shell.ui.fragment.SingleTrendFragment;

import java.util.ArrayList;

import butterknife.BindView;

import static com.rjp.shell.utils.LotteryTypeUtils.K3;

public class LeagueDetailActivity extends BaseActivity {

    @BindView(R2.id.tab_layout)
    CommonTabLayout tabLayout;

    private String[] mTitles = new String[]{"联赛积分", "射手排行"};
    private ArrayList<CustomTabEntity> mTabEntities;
    private ArrayList<Fragment> fragments;

    public static void trendTo(Context context, int leagueId, String title){
        Intent intent = new Intent(context, LeagueDetailActivity.class);
        intent.putExtra("leagueId", leagueId);
        intent.putExtra("title", title);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_league_detail);
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("leagueId")) {
            int leagueId = intent.getIntExtra("leagueId", 8);
            String title = intent.getStringExtra("title");
            setCommonTitle(title);
            fragments = new ArrayList<>();
            fragments.add(RankFragment.getInstance(String.valueOf(leagueId)));
            fragments.add(PlayerFragment.getInstance(String.valueOf(leagueId)));
            mTabEntities = new ArrayList<>();
            for (int i = 0; i < mTitles.length; i++) {
                mTabEntities.add(new TabEntity(mTitles[i]));
            }
            tabLayout.setTabData(mTabEntities, this, R.id.league_container, fragments);
        }
    }
}
