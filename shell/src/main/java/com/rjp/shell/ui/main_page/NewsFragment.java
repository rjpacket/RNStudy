package com.rjp.shell.ui.main_page;


import android.graphics.Color;
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
    private String defaultTitles = "最新,足球,篮球,比赛推荐,比赛花絮";
    private ArrayList<Fragment> fragments;

    public NewsFragment() {
        // Required empty public constructor
    }

    @Override
    public int getChildViewLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            View view = new View(mContext);
            LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(ViewGroup.LayoutParams.MATCH_PARENT, StatusBarTools.getStatusBarHeight(mContext));
            view.setLayoutParams(params);
            view.setBackgroundColor(Color.WHITE);
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
                    case "最新":
                        fragments.add(HomeNewsFragment.getInstance("home_all.json"));
                        break;
                    case "足球":
                        fragments.add(HomeNewsFragment.getInstance("home_basketball.json"));
                        break;
                    case "篮球":
                        fragments.add(HomeNewsFragment.getInstance("home_football.json"));
                        break;
                    case "比赛推荐":
                        fragments.add(HomeNewsFragment.getInstance("home_tuijian.json"));
                        break;
                    case "比赛花絮":
                        fragments.add(HomeNewsFragment.getInstance("home_huaxu.json"));
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
