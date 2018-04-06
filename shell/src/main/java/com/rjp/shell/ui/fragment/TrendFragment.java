package com.rjp.shell.ui.fragment;


import android.content.res.Resources;
import android.location.Location;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;

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
import com.rjp.shell.ui.activity.LocalStoreActivity;
import com.rjp.shell.views.CommonTitleBar;

import java.util.ArrayList;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class TrendFragment extends BaseFragment {

    @BindView(R2.id.map_view)
    MapView mapView;
    @BindView(R2.id.common_title_bar)
    CommonTitleBar commonTitleBar;
    private AMap aMap;

    public TrendFragment() {
        // Required empty public constructor
    }

    public static TrendFragment getInstance(){
        return new TrendFragment();
    }

    public static TrendFragment getInstance(String tag){
        TrendFragment homeNewsFragment = new TrendFragment();
        Bundle args = new Bundle();
        args.putString("tag", tag);
        homeNewsFragment.setArguments(args);
        return homeNewsFragment;
    }

    @Override
    public int getChildViewLayoutId() {
        return R.layout.fragment_map;
    }

    @Override
    public void initView() {
        commonTitleBar.setCommonTitle("附近彩票店");
        commonTitleBar.setBackVisibility(View.GONE);
        commonTitleBar.setRightFunction0("查看");
        commonTitleBar.addSystemBar();
        commonTitleBar.setOnCommonTitleBarClickListener(new CommonTitleBar.OnCommonTitleBarClickListener() {
            @Override
            public void onTitleBarClick(View view) {
                int id = view.getId();
                if(id == R.id.tv_right_function0){
                    LocalStoreActivity.trendTo(mContext);
                }
            }
        });

    }

    @Override
    public void reload() {

    }
}
