package com.rjp.shell.listviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.BaseAdapter;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rjp.shell.R;
import com.rjp.shell.base.CustomListView;
import com.rjp.shell.model.PlayerModel;
import com.rjp.shell.network.NetSuccessCallback;
import com.rjp.shell.network.NetUtils;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.List;

/**
 * author : Gimpo create on 2018/4/10 19:10
 * email  : jimbo922@163.com
 */

public class PlayerListView extends CustomListView<PlayerModel> {
    private String leagueId;

    public PlayerListView(Context context) {
        super(context);
    }

    public PlayerListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected BaseAdapter getListAdapter() {
        return new CommonAdapter<PlayerModel>(mContext, R.layout.item_player_list_view, mDatas) {
            @Override
            protected void convert(ViewHolder viewHolder, PlayerModel item, int position) {
                viewHolder.setText(R.id.tv_number, String.valueOf(position + 1));
                viewHolder.setText(R.id.tv_name, item.getScorer());
                viewHolder.setText(R.id.tv_team, item.getTeamName());
                viewHolder.setText(R.id.tv_count, item.getPlayingCount());
                viewHolder.setText(R.id.tv_score, item.getGoalsScored());
            }
        };
    }

    @Override
    protected boolean isFirstPage() {
        return true;
    }

    @Override
    protected List<PlayerModel> parseData(Object data) {
        return JSONArray.parseArray(data.toString(), PlayerModel.class);
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
                    String topGoalsScorers = parseObject.getString("topGoalsScorers");
                    dealSuccessData(topGoalsScorers);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
