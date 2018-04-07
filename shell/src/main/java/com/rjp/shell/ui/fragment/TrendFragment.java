package com.rjp.shell.ui.fragment;


import android.content.res.Resources;
import android.graphics.Color;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

import com.alibaba.fastjson.JSONArray;
import com.amap.api.maps.AMap;
import com.amap.api.maps.CameraUpdate;
import com.amap.api.maps.CameraUpdateFactory;
import com.amap.api.maps.MapView;
import com.amap.api.maps.model.LatLng;
import com.amap.api.maps.model.Marker;
import com.amap.api.maps.model.MarkerOptions;
import com.amap.api.maps.model.MyLocationStyle;
import com.amap.api.services.core.LatLonPoint;
import com.amap.api.services.core.PoiItem;
import com.amap.api.services.poisearch.PoiResult;
import com.amap.api.services.poisearch.PoiSearch;
import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseFragment;
import com.rjp.shell.model.Cell;
import com.rjp.shell.model.CellGroup;
import com.rjp.shell.model.OpenPrizeModel;
import com.rjp.shell.ui.activity.LocalStoreActivity;
import com.rjp.shell.utils.FileUtils;
import com.rjp.shell.views.ChartView;
import com.rjp.shell.views.CommonTitleBar;

import java.util.ArrayList;
import java.util.List;

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

    @Override
    public int getChildViewLayoutId() {
        return R.layout.fragment_trend;
    }

    @Override
    public void initView() {
        commonTitleBar.setCommonTitle("双色球走势图");
        commonTitleBar.setBackVisibility(View.GONE);
        commonTitleBar.setRightFunction0("查看");
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

        String assets = FileUtils.getAssets(mContext, "open_ssq.json");
        List<OpenPrizeModel> models = JSONArray.parseArray(assets, OpenPrizeModel.class);
        List<Cell> topCells = new ArrayList<>();
        for (int i = 0; i < 33; i++) {
            Cell cell = new Cell();
            cell.setNumber(String.format("%2d", (i + 1)));
            cell.setColor(getResources().getColor(R.color.number_red));
            topCells.add(cell);
        }
        topCells.add(new Cell());
        for (int i = 0; i < 16; i++) {
            Cell cell = new Cell();
            cell.setNumber(String.format("%2d", (i + 1)));
            cell.setColor(getResources().getColor(R.color.number_blue));
            topCells.add(cell);
        }

        List<CellGroup> cellGroups = new ArrayList<>();
        Cell preCell = null;
        for (OpenPrizeModel model : models) {
            List<Cell> cells = new ArrayList<>();
            CellGroup group = new CellGroup();
            group.setTitle("第" + model.getPhase() + "期");
            String wincode = model.getWincode();
            String[] split = wincode.split("|");
            String[] redNum = split[0].split(",");

            for (int i = 0; i < 33; i++) {
                Cell cell = new Cell();
                String format = String.format("%2d", (i + 1));
                cell.setNumber(format);
                cell.setColor(getResources().getColor(R.color.number_red));
                for (String zhong : redNum) {
                    if(format.equals(zhong)){
                        cell.setSelected(true);
                        break;
                    }
                }
                cells.add(cell);
            }
            topCells.add(new Cell());
            for (int i = 0; i < 16; i++) {
                Cell cell = new Cell();
                String format = String.format("%2d", (i + 1));
                cell.setNumber(format);
                cell.setColor(getResources().getColor(R.color.number_blue));
                cell.setSelected(format.equals(split[1]));
                if(preCell != null){
                    if(cell.isSelected()){
                        cell.setNextCell(preCell);
                        preCell = cell;
                    }
                }
                cells.add(cell);
            }
            group.setCells(cells);
            cellGroups.add(group);
        }
        chartView.addChart(topCells, cellGroups);
    }

    @Override
    public void reload() {

    }
}
