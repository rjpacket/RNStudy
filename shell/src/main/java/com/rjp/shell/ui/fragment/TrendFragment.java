package com.rjp.shell.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseFragment;
import com.rjp.shell.ui.activity.LocalStoreActivity;
import com.rjp.shell.utils.TrendUtils;
import com.rjp.shell.views.ChartView;
import com.rjp.shell.views.CommonTitleBar;

import butterknife.BindView;

/**
 * A simple {@link Fragment} subclass.
 */
public class TrendFragment extends BaseFragment {

    @BindView(R2.id.common_title_bar)
    CommonTitleBar commonTitleBar;
    @BindView(R2.id.chart_view)
    ChartView chartView;

    public TrendFragment() {
        // Required empty public constructor
    }

    public static TrendFragment getInstance() {
        return new TrendFragment();
    }

    public static TrendFragment getInstance(int lotteryType){
        TrendFragment homeNewsFragment = new TrendFragment();
        Bundle args = new Bundle();
        args.putInt("lotteryType", lotteryType);
        homeNewsFragment.setArguments(args);
        return homeNewsFragment;
    }

    @Override
    public int getChildViewLayoutId() {
        return R.layout.fragment_trend;
    }

    @Override
    public void initView() {
        commonTitleBar.setCommonTitle("时时彩走势图");
        commonTitleBar.setBackVisibility(View.GONE);
        commonTitleBar.setRightFunction0("查看更多");
        commonTitleBar.addSystemBar();
        commonTitleBar.setOnCommonTitleBarClickListener(new CommonTitleBar.OnCommonTitleBarClickListener() {
            @Override
            public void onTitleBarClick(View view) {
                int id = view.getId();
                if (id == R.id.tv_right_function0) {
                    LocalStoreActivity.trendTo(mContext);
                }
            }
        });

        Bundle bundle = getArguments();
        if(bundle != null && bundle.containsKey("lotteryType")) {
            int lotteryType = bundle.getInt("lotteryType");
            chartView.addChart(TrendUtils.ssqTopCells(getResources().getColor(R.color.number_red), getResources().getColor(R.color.number_blue)),
                    TrendUtils.ssqCellGroups(mContext));
        }
    }

    @Override
    public void reload() {

    }
}
