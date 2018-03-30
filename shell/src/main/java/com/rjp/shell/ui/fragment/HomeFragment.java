package com.rjp.shell.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseFragment;
import com.rjp.shell.listviews.OpenPrizeListView;
import com.rjp.shell.views.CommonTitleBar;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    @BindView(R2.id.open_prize_list_view)
    OpenPrizeListView listView;
    @BindView(R2.id.common_title_bar)
    CommonTitleBar commonTitleBar;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment getInstance(){
        return new HomeFragment();
    }

    public static HomeFragment getInstance(String tag){
        HomeFragment homeNewsFragment = new HomeFragment();
        Bundle args = new Bundle();
        args.putString("tag", tag);
        homeNewsFragment.setArguments(args);
        return homeNewsFragment;
    }

    @Override
    public int getChildViewLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        commonTitleBar.setCommonTitle("近期开奖");
        commonTitleBar.setBackVisibility(View.GONE);
        commonTitleBar.addSystemBar();

        listView.requestData();
    }

    @Override
    public void reload() {

    }
}
