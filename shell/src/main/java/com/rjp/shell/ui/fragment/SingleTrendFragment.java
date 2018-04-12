package com.rjp.shell.ui.fragment;


import android.os.Bundle;
import android.support.v4.app.Fragment;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseFragment;
import com.rjp.shell.utils.TrendUtils;
import com.rjp.shell.views.ChartView;

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
public class SingleTrendFragment extends BaseFragment {

    @BindView(R2.id.single_chart_view)
    ChartView chartView;

    public SingleTrendFragment() {
        // Required empty public constructor
    }

    public static SingleTrendFragment getInstance() {
        return new SingleTrendFragment();
    }

    public static SingleTrendFragment getInstance(int lotteryType, int index) {
        SingleTrendFragment homeNewsFragment = new SingleTrendFragment();
        Bundle args = new Bundle();
        args.putInt("lotteryType", lotteryType);
        args.putInt("index", index);
        homeNewsFragment.setArguments(args);
        return homeNewsFragment;
    }

    @Override
    public int getChildViewLayoutId() {
        return R.layout.fragment_single_trend;
    }

    @Override
    public void initView() {

        Bundle bundle = getArguments();
        if (bundle != null && bundle.containsKey("lotteryType")) {
            int lotteryType = bundle.getInt("lotteryType");
            int index = bundle.getInt("index");

            int redColor = getResources().getColor(R.color.number_red);
            int blueColor = getResources().getColor(R.color.number_blue);
            switch (lotteryType) {
                case SSQ:
                    chartView.addChart(TrendUtils.ssqTopCells(redColor, blueColor), TrendUtils.ssqCellGroups(mContext));
                    break;
                case DLT:
                    chartView.addChart(TrendUtils.dltTopCells(redColor, blueColor), TrendUtils.dltCellGroups(mContext));
                    break;
                case K3:
                    if(index == 1){
                        chartView.addChart(TrendUtils.k3TopCells(redColor), TrendUtils.k31CellGroups(mContext, redColor));
                    }else if(index == 2){
                        chartView.addChart(TrendUtils.k3TopCells(redColor), TrendUtils.k32CellGroups(mContext, redColor));
                    }else if(index == 3){
                        chartView.addChart(TrendUtils.k3TopCells(redColor), TrendUtils.k33CellGroups(mContext, redColor));
                    }
                    break;
                case FC3D:
                    if(index == 1){
                        chartView.addChart(TrendUtils.fc3dTopCells(redColor), TrendUtils.fc3dBaiCellGroups(mContext, redColor));
                    }else if(index == 2){
                        chartView.addChart(TrendUtils.fc3dTopCells(redColor), TrendUtils.fc3dShiCellGroups(mContext, redColor));
                    }else if(index == 3){
                        chartView.addChart(TrendUtils.fc3dTopCells(redColor), TrendUtils.fc3dGeCellGroups(mContext, redColor));
                    }
                    break;
                case X115:
                    if(index == 1){
                        chartView.addChart(TrendUtils.x115TopCells(redColor), TrendUtils.x115WanCellGroups(mContext, redColor));
                    }else if(index == 2){
                        chartView.addChart(TrendUtils.x115TopCells(redColor), TrendUtils.x115QianCellGroups(mContext, redColor));
                    }else if(index == 3){
                        chartView.addChart(TrendUtils.x115TopCells(redColor), TrendUtils.x115BaiCellGroups(mContext, redColor));
                    }else if(index == 4){
                        chartView.addChart(TrendUtils.x115TopCells(redColor), TrendUtils.x115ShiCellGroups(mContext, redColor));
                    }else if(index == 5){
                        chartView.addChart(TrendUtils.x115TopCells(redColor), TrendUtils.x115GeCellGroups(mContext, redColor));
                    }
                    break;
                case PL3:
                    if(index == 1){
                        chartView.addChart(TrendUtils.pl3TopCells(redColor), TrendUtils.pl3BaiCellGroups(mContext, redColor));
                    }else if(index == 2){
                        chartView.addChart(TrendUtils.pl3TopCells(redColor), TrendUtils.pl3ShiCellGroups(mContext, redColor));
                    }else if(index == 3){
                        chartView.addChart(TrendUtils.pl3TopCells(redColor), TrendUtils.pl3GeCellGroups(mContext, redColor));
                    }
                    break;
                case PL5:
                    if(index == 1){
                        chartView.addChart(TrendUtils.pl5TopCells(redColor), TrendUtils.pl5WanCellGroups(mContext, redColor));
                    }else if(index == 2){
                        chartView.addChart(TrendUtils.pl5TopCells(redColor), TrendUtils.pl5QianCellGroups(mContext, redColor));
                    }else if(index == 3){
                        chartView.addChart(TrendUtils.pl5TopCells(redColor), TrendUtils.pl5BaiCellGroups(mContext, redColor));
                    }else if(index == 4){
                        chartView.addChart(TrendUtils.pl5TopCells(redColor), TrendUtils.pl5ShiCellGroups(mContext, redColor));
                    }else if(index == 5){
                        chartView.addChart(TrendUtils.pl5TopCells(redColor), TrendUtils.pl5GeCellGroups(mContext, redColor));
                    }
                    break;
                case QXC:
                    if(index == 1){
                        chartView.addChart(TrendUtils.qxcTopCells(redColor), TrendUtils.qxc1CellGroups(mContext, redColor));
                    }else if(index == 2){
                        chartView.addChart(TrendUtils.qxcTopCells(redColor), TrendUtils.qxc2CellGroups(mContext, redColor));
                    }else if(index == 3){
                        chartView.addChart(TrendUtils.qxcTopCells(redColor), TrendUtils.qxc3CellGroups(mContext, redColor));
                    }else if(index == 4){
                        chartView.addChart(TrendUtils.qxcTopCells(redColor), TrendUtils.qxc4CellGroups(mContext, redColor));
                    }else if(index == 5){
                        chartView.addChart(TrendUtils.qxcTopCells(redColor), TrendUtils.qxc5CellGroups(mContext, redColor));
                    }else if(index == 6){
                        chartView.addChart(TrendUtils.qxcTopCells(redColor), TrendUtils.qxc6CellGroups(mContext, redColor));
                    }else if(index == 7){
                        chartView.addChart(TrendUtils.qxcTopCells(redColor), TrendUtils.qxc7CellGroups(mContext, redColor));
                    }
                    break;
                case QLC:
                    chartView.addChart(TrendUtils.qlcTopCells(redColor), TrendUtils.qlcCellGroups(mContext));
                    break;
                case SSC:
                    if(index == 1){
                        chartView.addChart(TrendUtils.sscTopCells(redColor), TrendUtils.sscWanCellGroups(mContext, redColor));
                    }else if(index == 2){
                        chartView.addChart(TrendUtils.sscTopCells(redColor), TrendUtils.sscQianCellGroups(mContext, redColor));
                    }else if(index == 3){
                        chartView.addChart(TrendUtils.sscTopCells(redColor), TrendUtils.sscBaiCellGroups(mContext, redColor));
                    }else if(index == 4){
                        chartView.addChart(TrendUtils.sscTopCells(redColor), TrendUtils.sscShiCellGroups(mContext, redColor));
                    }else if(index == 5){
                        chartView.addChart(TrendUtils.sscTopCells(redColor), TrendUtils.sscGeCellGroups(mContext, redColor));
                    }
                    break;
            }
        }
    }

    @Override
    public void reload() {

    }
}
