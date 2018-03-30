package com.rjp.shell.listviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.rjp.shell.R;
import com.rjp.shell.base.LoadMoreListView;
import com.rjp.shell.base.MySharedPreferences;
import com.rjp.shell.model.HomeNewsModel;
import com.rjp.shell.ui.activity.NewsDetailActivity;
import com.rjp.shell.utils.AppUtils;
import com.rjp.shell.utils.FileUtils;
import com.rjp.shell.utils.ImageUtils;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.List;

public class SaveNewsListView extends LoadMoreListView<HomeNewsModel> {
    private int type;
    private String tag;
    private List<HomeNewsModel> homeNewsModels;

    public SaveNewsListView(Context context) {
        super(context);
    }

    public SaveNewsListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected void resetFirstPage() {
        mPage = 0;
        mPageSize = 10;
    }

    @Override
    protected void pageNext() {
        mPage += mPageSize;
    }

    @Override
    protected BaseAdapter getListAdapter() {
        return new CommonAdapter<HomeNewsModel>(mContext, R.layout.item_byhome_news_list_view, mDatas) {
            @Override
            protected void convert(ViewHolder viewHolder, HomeNewsModel item, int position) {
                ImageView ivBigPic = viewHolder.getView(R.id.iv_big_pic);
                ImageView ivSmallPic = viewHolder.getView(R.id.iv_small_pic);
                TextView tvTitle = viewHolder.getView(R.id.tv_news_title);
                TextView tvTag = viewHolder.getView(R.id.tv_news_tag);
                TextView tvTime = viewHolder.getView(R.id.tv_news_time);
                View newsLine = viewHolder.getView(R.id.news_line);

                ViewGroup.LayoutParams layoutParams = newsLine.getLayoutParams();
                ivBigPic.setVisibility(GONE);
                ivSmallPic.setVisibility(VISIBLE);
                ImageUtils.load(mContext, item.getImg(), ivSmallPic);
                layoutParams.height = 1;
                newsLine.setLayoutParams(layoutParams);

                tvTitle.setText(item.getTitle());
                String tag = item.getTag();
                List<String> list = JSONArray.parseArray(tag, String.class);
                if (list != null && list.size() > 0) {
                    tvTag.setVisibility(VISIBLE);
                    tvTag.setText(list.get(0));
                } else {
                    tvTag.setVisibility(GONE);
                }
                tvTime.setText(item.getNewsTime() + "");
            }
        };
    }

    @Override
    public void requestData() {
        if (homeNewsModels == null || homeNewsModels.size() == 0) {
            String assets = MySharedPreferences.getInstance().getString(MySharedPreferences.SAVE_NEWS);
            homeNewsModels = JSONArray.parseArray(assets, HomeNewsModel.class);
        }
        dealSuccessData(JSONArray.toJSONString(homeNewsModels));
    }

    @Override
    protected boolean isFirstPage() {
        return mPage == 0;
    }

    @Override
    protected List<HomeNewsModel> parseData(Object data) {
        return JSONArray.parseArray(data.toString(), HomeNewsModel.class);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        HomeNewsModel newsModel = mDatas.get(position);
        NewsDetailActivity.trendTo(mContext, newsModel);
    }
}
