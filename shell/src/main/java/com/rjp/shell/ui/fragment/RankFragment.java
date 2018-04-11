package com.rjp.shell.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseFragment;
import com.rjp.shell.listviews.RankListView;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class RankFragment extends BaseFragment {

    @BindView(R2.id.rank_list_view)
    RankListView rankListView;

    public RankFragment() {
        // Required empty public constructor
    }

    public static RankFragment getInstance(){
        return new RankFragment();
    }

    public static RankFragment getInstance(String tag){
        RankFragment homeNewsFragment = new RankFragment();
        Bundle args = new Bundle();
        args.putString("tag", tag);
        homeNewsFragment.setArguments(args);
        return homeNewsFragment;
    }

    @Override
    public int getChildViewLayoutId() {
        return R.layout.fragment_rank;
    }

    @Override
    public void initView() {
        Bundle arguments = getArguments();
        if(arguments.containsKey("tag")){
            String tag = arguments.getString("tag");
            rankListView.requestData(tag);
        }
    }

    @Override
    public void reload() {

    }
}
