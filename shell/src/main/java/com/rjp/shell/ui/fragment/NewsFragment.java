package com.rjp.shell.ui.fragment;


import android.os.Build;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.text.TextUtils;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;

import com.flyco.tablayout.SlidingTabLayout;
import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseFragment;
import com.rjp.shell.ui.adapter.HomeNewsFragmentAdapter;
import com.rjp.shell.utils.StatusBarTools;

import java.util.ArrayList;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class NewsFragment extends BaseFragment {
    @BindView(R2.id.sliding_tab_layout)
    SlidingTabLayout slidingTabLayout;
    @BindView(R2.id.home_news_viewpager)
    ViewPager viewPager;
    @BindView(R2.id.ll_home_root)
    LinearLayout llRoot;
    private String defaultTitles = "热点,世界杯,NBA,梅西,科比";
    private ArrayList<Fragment> fragments;

    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public int getChildViewLayoutId() {
        return R.layout.fragment_news;
    }

    @Override
    public void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            View view = new View(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, StatusBarTools.getStatusBarHeight(mContext));
            view.setLayoutParams(params);
            view.setBackgroundResource(R.drawable.shape_maincolor_maincolor_0);
            llRoot.addView(view, 0);
        }

        fragments = new ArrayList<>();
        changeHomeNewsData(defaultTitles);
    }

    /**
     * 根据保存的数据进行首页的初始化
     * @param titleStr
     */
    private void changeHomeNewsData(String titleStr) {
        if (!TextUtils.isEmpty(titleStr)) {
            String[] titles = titleStr.split(",");
            fragments.clear();
            for (int i = 0; i < titles.length; i++) {
                String mtitle = titles[i];
                switch (mtitle) {
                    case "热点":
                        fragments.add(HomeNewsFragment.getInstance("home_all.json"));
                        break;
                    case "世界杯":
                        fragments.add(HomeNewsFragment.getInstance("home_shijiebei.json"));
                        break;
                    case "NBA":
                        fragments.add(HomeNewsFragment.getInstance("home_NBA.json"));
                        break;
                    case "梅西":
                        fragments.add(HomeNewsFragment.getInstance("home_meixi.json"));
                        break;
                    case "科比":
                        fragments.add(HomeNewsFragment.getInstance("home_kobe.json"));
                        break;
                }
            }
            viewPager.setAdapter(new HomeNewsFragmentAdapter(getChildFragmentManager(), fragments));
            viewPager.setOffscreenPageLimit(titles.length);
            slidingTabLayout.setViewPager(viewPager, titles);
        }
    }

    @Override
    public void reload() {

    }
}
