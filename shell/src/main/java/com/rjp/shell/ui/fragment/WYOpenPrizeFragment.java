package com.rjp.shell.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseFragment;
import com.rjp.shell.listviews.WYOpenPrizeListView;
import com.rjp.shell.views.CommonTitleBar;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class WYOpenPrizeFragment extends BaseFragment {

    @BindView(R2.id.open_prize_list_view)
    WYOpenPrizeListView listView;
    @BindView(R2.id.common_title_bar)
    CommonTitleBar commonTitleBar;

    public WYOpenPrizeFragment() {
        // Required empty public constructor
    }

    public static WYOpenPrizeFragment getInstance(){
        return new WYOpenPrizeFragment();
    }

    @Override
    public int getChildViewLayoutId() {
        return R.layout.fragment_wy_open_prize;
    }

    @Override
    public void initView() {
        commonTitleBar.setCommonTitle("开奖列表");
        commonTitleBar.setBackVisibility(View.GONE);
        commonTitleBar.addSystemBar();

        listView.requestData();
    }

    @Override
    public void reload() {

    }
}
