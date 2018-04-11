package com.rjp.shell.listviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.BaseAdapter;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rjp.shell.R;
import com.rjp.shell.base.CustomListView;
import com.rjp.shell.model.RankModel;
import com.rjp.shell.network.NetSuccessCallback;
import com.rjp.shell.network.NetUtils;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.List;

/**
 * author : Gimpo create on 2018/4/10 19:10
 * email  : jimbo922@163.com
 */

public class RankListView extends CustomListView<RankModel> {
    private String leagueId;

    public RankListView(Context context) {
        super(context);
    }

    public RankListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected BaseAdapter getListAdapter() {
        return new CommonAdapter<RankModel>(mContext, R.layout.item_rank_list_view, mDatas) {
            @Override
            protected void convert(ViewHolder viewHolder, RankModel item, int position) {
                viewHolder.setText(R.id.tv_number, item.getRank());
                viewHolder.setText(R.id.tv_name, item.getTeam());
                viewHolder.setText(R.id.tv_over, item.getMatchesPlayed());
                viewHolder.setText(R.id.tv_win, item.getWins());
                viewHolder.setText(R.id.tv_draw, item.getDraws());
                viewHolder.setText(R.id.tv_fail, item.getLosses());
                viewHolder.setText(R.id.tv_score, item.getPoints());
            }
        };
    }

    @Override
    protected boolean isFirstPage() {
        return true;
    }

    @Override
    protected List<RankModel> parseData(Object data) {
        return JSONArray.parseArray(data.toString(), RankModel.class);
    }

    @Override
    protected void resetFirstPage() {

    }

    public void requestData(String leagueId){
        this.leagueId = leagueId;
        requestData();
    }

    @Override
    protected void requestData() {
        String url = "http://zxwap.caipiao.163.com/libraryapi/league_matchRank.html?mobileType=android&channel=miui_cps&apiLevel=27&apiVer=1.1&ver=4.31";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("leagueId", leagueId);
        NetUtils.getInstance().post(mContext, url, jsonObject, new NetSuccessCallback() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject parseObject = JSONObject.parseObject(result);
                    JSONArray standings = parseObject.getJSONArray("standings");
                    for (Object standing : standings) {
                        JSONObject jsonObject1 = JSONObject.parseObject(standing.toString());
                        String teamInfo = jsonObject1.getString("teamInfo");
                        dealSuccessData(teamInfo);
                    }
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
