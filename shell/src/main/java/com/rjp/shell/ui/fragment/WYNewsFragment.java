package com.rjp.shell.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseFragment;
import com.rjp.shell.listviews.WYNewsListView;
import com.rjp.shell.views.CommonTitleBar;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WYNewsFragment extends BaseFragment {

    @BindView(R2.id.wy_list_view)
    WYNewsListView wyListView;
    @BindView(R2.id.common_title_bar)
    CommonTitleBar commonTitleBar;

    public WYNewsFragment() {
        // Required empty public constructor
    }

    public static WYNewsFragment getInstance(){
        return new WYNewsFragment();
    }

    /**
     * 网易彩票的彩种简称 ssc
     * @param tag
     * @return
     */
    public static WYNewsFragment getInstance(String tag){
        WYNewsFragment homeNewsFragment = new WYNewsFragment();
        Bundle args = new Bundle();
        args.putString("tag", tag);
        homeNewsFragment.setArguments(args);
        return homeNewsFragment;
    }

    @Override
    public int getChildViewLayoutId() {
        return R.layout.fragment_wy_news;
    }

    @Override
    public void initView() {
        commonTitleBar.setCommonTitle("热门资讯");
        commonTitleBar.setBackVisibility(View.GONE);
        commonTitleBar.addSystemBar();

        Bundle arguments = getArguments();
        if(arguments.containsKey("tag")){
            String tag = arguments.getString("tag");
            wyListView.requestData(tag);
        }
    }

    @Override
    public void reload() {

    }
}