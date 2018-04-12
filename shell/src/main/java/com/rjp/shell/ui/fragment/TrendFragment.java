package com.rjp.shell.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseFragment;
import com.rjp.shell.ui.activity.TrendListActivity;
import com.rjp.shell.utils.LotteryTypeUtils;
import com.rjp.shell.utils.TrendUtils;
import com.rjp.shell.views.ChartView;
import com.rjp.shell.views.CommonTitleBar;

import butterknife.BindView;

import static com.rjp.shell.utils.LotteryTypeUtils.DLT;
import static com.rjp.shell.utils.LotteryTypeUtils.FC3D;
import static com.rjp.shell.utils.LotteryTypeUtils.K3;
import static com.rjp.shell.utils.LotteryTypeUtils.PL3;
import static com.rjp.shell.utils.LotteryTypeUtils.PL5;
import static com.rjp.shell.utils.LotteryTypeUtils.QLC;
import static com.rjp.shell.utils.LotteryTypeUtils.QXC;
import static com.rjp.shell.utils.LotteryTypeUtils.SSC;
import static com.rjp.shell.utils.LotteryTypeUtils.SSQ;
import static com.rjp.shell.utils.LotteryTypeUtils.X115;

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

    public static TrendFragment getInstance(int lotteryType) {
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
        commonTitleBar.setBackVisibility(View.GONE);
        commonTitleBar.setRightFunction0("查看更多");
        commonTitleBar.addSystemBar();
        commonTitleBar.setOnCommonTitleBarClickListener(new CommonTitleBar.OnCommonTitleBarClickListener() {
            @Override
            public void onTitleBarClick(View view) {
                int id = view.getId();
                if (id == R.id.tv_right_function0) {
                    TrendListActivity.trendTo(mContext);
                }
            }
        });

        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey("lotteryType")) {
            int lotteryType = bundle.getInt("lotteryType");
            commonTitleBar.setCommonTitle(LotteryTypeUtils.getLotteryTag(lotteryType) + "走势图");

            int redColor = getResources().getColor(R.color.number_red);
            int blueColor = getResources().getColor(R.color.number_blue);
            switch (lotteryType) {
                case SSQ:
                    chartView.addChart(TrendUtils.ssqTopCells(redColor, blueColor),
                            TrendUtils.ssqCellGroups(mContext));
                    break;
                case DLT:
                    chartView.addChart(TrendUtils.dltTopCells(redColor, blueColor),
                            TrendUtils.dltCellGroups(mContext));
                    break;
                case K3:
                    chartView.addChart(TrendUtils.k3TopCells(redColor), TrendUtils.k31CellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.k3TopCells(redColor), TrendUtils.k32CellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.k3TopCells(redColor), TrendUtils.k33CellGroups(mContext, redColor));
                    break;
                case FC3D:
                    chartView.addChart(TrendUtils.fc3dTopCells(redColor), TrendUtils.fc3dBaiCellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.fc3dTopCells(redColor), TrendUtils.fc3dShiCellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.fc3dTopCells(redColor), TrendUtils.fc3dGeCellGroups(mContext, redColor));
                    break;
                case X115:
                    chartView.addChart(TrendUtils.x115TopCells(redColor), TrendUtils.x115WanCellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.x115TopCells(redColor), TrendUtils.x115QianCellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.x115TopCells(redColor), TrendUtils.x115BaiCellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.x115TopCells(redColor), TrendUtils.x115ShiCellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.x115TopCells(redColor), TrendUtils.x115GeCellGroups(mContext, redColor));
                    break;
                case PL3:
                    chartView.addChart(TrendUtils.pl3TopCells(redColor), TrendUtils.pl3BaiCellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.pl3TopCells(redColor), TrendUtils.pl3ShiCellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.pl3TopCells(redColor), TrendUtils.pl3GeCellGroups(mContext, redColor));
                    break;
                case PL5:
                    chartView.addChart(TrendUtils.pl5TopCells(redColor), TrendUtils.pl5WanCellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.pl5TopCells(redColor), TrendUtils.pl5QianCellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.pl5TopCells(redColor), TrendUtils.pl5BaiCellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.pl5TopCells(redColor), TrendUtils.pl5ShiCellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.pl5TopCells(redColor), TrendUtils.pl5GeCellGroups(mContext, redColor));
                    break;
                case QXC:
                    chartView.addChart(TrendUtils.qxcTopCells(redColor), TrendUtils.qxc1CellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.qxcTopCells(redColor), TrendUtils.qxc2CellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.qxcTopCells(redColor), TrendUtils.qxc3CellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.qxcTopCells(redColor), TrendUtils.qxc4CellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.qxcTopCells(redColor), TrendUtils.qxc5CellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.qxcTopCells(redColor), TrendUtils.qxc6CellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.qxcTopCells(redColor), TrendUtils.qxc7CellGroups(mContext, redColor));
                    break;
                case QLC:
                    chartView.addChart(TrendUtils.qlcTopCells(redColor), TrendUtils.qlcCellGroups(mContext));
                    break;
                case SSC:
                    chartView.addChart(TrendUtils.sscTopCells(redColor), TrendUtils.sscWanCellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.sscTopCells(redColor), TrendUtils.sscQianCellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.sscTopCells(redColor), TrendUtils.sscBaiCellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.sscTopCells(redColor), TrendUtils.sscShiCellGroups(mContext, redColor));
                    chartView.addAnotherChart(TrendUtils.sscTopCells(redColor), TrendUtils.sscGeCellGroups(mContext, redColor));
                    break;
            }
        }
    }

    @Override
    public void reload() {

    }
}
