package com.rjp.shell.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseFragment;
import com.rjp.shell.listviews.OpenPrizeListView;
import com.rjp.shell.listviews.RecommendLotteryListView;
import com.rjp.shell.views.CommonTitleBar;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RecommendFragment extends BaseFragment {

    @BindView(R2.id.common_title_bar)
    CommonTitleBar commonTitleBar;
    @BindView(R2.id.recommend_list_view)
    RecommendLotteryListView listView;

    public RecommendFragment() {
        // Required empty public constructor
    }

    public static RecommendFragment getInstance(){
        return new RecommendFragment();
    }

    @Override
    public int getChildViewLayoutId() {
        return R.layout.fragment_recommend;
    }

    @Override
    public void initView() {
        commonTitleBar.setCommonTitle("每日推荐");
        commonTitleBar.setBackVisibility(View.GONE);
        commonTitleBar.addSystemBar();

        listView.requestData();
    }

    @Override
    public void onFirstUserVisible() {

    }

    @Override
    public void reload() {

    }
}
