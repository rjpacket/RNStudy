package com.rjp.shell.listviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rjp.shell.R;
import com.rjp.shell.base.CustomListView;
import com.rjp.shell.model.ChampionModel;
import com.rjp.shell.model.PlayerModel;
import com.rjp.shell.network.NetSuccessCallback;
import com.rjp.shell.network.NetUtils;
import com.rjp.shell.utils.ImageUtils;
import com.scwang.smartrefresh.layout.api.RefreshHeader;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.List;

/**
 * author : Gimpo create on 2018/4/10 19:10
 * email  : jimbo922@163.com
 */

public class ChampionListView extends CustomListView<ChampionModel> {
    private String leagueId;

    public ChampionListView(Context context) {
        super(context);
    }

    public ChampionListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected RefreshHeader getRefreshHeader() {
        return null;
    }

    @Override
    protected BaseAdapter getListAdapter() {
        return new CommonAdapter<ChampionModel>(mContext, R.layout.item_champion_list_view, mDatas) {
            @Override
            protected void convert(ViewHolder viewHolder, ChampionModel item, int position) {
                viewHolder.setText(R.id.tv_team_name, item.getTeamName());
                viewHolder.setText(R.id.tv_team_peilv, "赔率：" + item.getSp() + "  " + "热度：" + item.getHot());
                viewHolder.setText(R.id.tv_team_tip, "投入可得" + item.getSp() + "倍回报");
                ImageView ivLogo = viewHolder.getView(R.id.iv_team_logo);
                ImageUtils.load(mContext, item.getLogoA(), ivLogo);
            }
        };
    }

    @Override
    protected boolean isFirstPage() {
        return true;
    }

    @Override
    protected List<ChampionModel> parseData(Object data) {
        return JSONArray.parseArray(data.toString(), ChampionModel.class);
    }

    @Override
    protected void resetFirstPage() {

    }

    @Override
    public void requestData() {
        String url = "http://wap.ttacp8.com/championTeamList.html?notAutoLogFlag=true&gameEn=jcgj&cache=1523768686531";
        NetUtils.getInstance().get(mContext, url, new NetSuccessCallback() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject parseObject = JSONObject.parseObject(result);
                    JSONObject data = parseObject.getJSONObject("data");
                    dealSuccessData(data.get("matchInfo"));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }
}
