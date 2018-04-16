package com.rjp.shell.listviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rjp.shell.R;
import com.rjp.shell.base.CustomListView;
import com.rjp.shell.model.ChampionModel;
import com.rjp.shell.model.LeagueModel;
import com.rjp.shell.model.LotteryBean;
import com.rjp.shell.network.NetSuccessCallback;
import com.rjp.shell.network.NetUtils;
import com.rjp.shell.ui.activity.LeagueDetailActivity;
import com.rjp.shell.utils.FileUtils;
import com.rjp.shell.utils.ImageUtils;
import com.rjp.shell.utils.LotteryTypeUtils;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.List;

/**
 * author : Gimpo create on 2018/4/10 19:10
 * email  : jimbo922@163.com
 */

public class LeagueListView extends CustomListView<LeagueModel> {
    private String leagueId;
    private List<LeagueModel> leagueModels;

    public LeagueListView(Context context) {
        super(context);
    }

    public LeagueListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected RefreshHeader getRefreshHeader() {
        return null;
    }

    @Override
    protected BaseAdapter getListAdapter() {
        return new CommonAdapter<LeagueModel>(mContext, R.layout.item_league_list_view, mDatas) {
            @Override
            protected void convert(ViewHolder viewHolder, LeagueModel item, int position) {
                viewHolder.setText(R.id.tv_league_name, item.getName());
                viewHolder.setText(R.id.tv_league_desc, item.getDesc());
                ImageView ivLogo = viewHolder.getView(R.id.iv_league_logo);
                ivLogo.setImageResource(LotteryTypeUtils.getLeagueLogo(item.getId()));
            }
        };
    }

    @Override
    protected boolean isFirstPage() {
        return true;
    }

    @Override
    protected List<LeagueModel> parseData(Object data) {
        return JSONArray.parseArray(data.toString(), LeagueModel.class);
    }

    @Override
    protected void resetFirstPage() {

    }

    @Override
    public void requestData() {
        if (leagueModels == null || leagueModels.size() == 0) {
            String assets = FileUtils.getAssets(mContext, "league.json");
            leagueModels = JSONArray.parseArray(assets, LeagueModel.class);
        }
        dealSuccessData(JSONArray.toJSONString(leagueModels));
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        LeagueModel leagueModel = mDatas.get(position);
        LeagueDetailActivity.trendTo(mContext, leagueModel.getId(), leagueModel.getName());
    }
}
