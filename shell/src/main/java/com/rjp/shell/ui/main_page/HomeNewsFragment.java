package com.rjp.shell.ui.main_page;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseFragment;
import com.rjp.shell.listviews.HomeNewsListView;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeNewsFragment extends BaseFragment {

    @BindView(R2.id.home_news_list_view)
    HomeNewsListView listView;

    public HomeNewsFragment() {
        // Required empty public constructor
    }

    public static HomeNewsFragment getInstance(){
        return new HomeNewsFragment();
    }

    public static HomeNewsFragment getInstance(int type){
        HomeNewsFragment homeNewsFragment = new HomeNewsFragment();
        Bundle args = new Bundle();
        args.putInt("type", type);
        homeNewsFragment.setArguments(args);
        return homeNewsFragment;
    }

    public static HomeNewsFragment getInstance(String tag){
        HomeNewsFragment homeNewsFragment = new HomeNewsFragment();
        Bundle args = new Bundle();
        args.putString("tag", tag);
        homeNewsFragment.setArguments(args);
        return homeNewsFragment;
    }

    @Override
    public int getChildViewLayoutId() {
        return R.layout.fragment_home_news;
    }

    @Override
    public void initView() {
        Bundle arguments = getArguments();
        if(arguments.containsKey("type")){
            int type = arguments.getInt("type");
            listView.requestData(type);
        }else if(arguments.containsKey("tag")){
            String tag = arguments.getString("tag");
            listView.requestData(tag);
        }
    }

    @Override
    public void reload() {

    }
}
