package com.rjp.shell.listviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.view.ViewGroup;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rjp.baselistview.pinned.PinnedHeaderExpandableAdapter;
import com.rjp.baselistview.simple.PinnedListView;
import com.rjp.shell.R;
import com.rjp.shell.base.DefaultHeader;
import com.rjp.shell.model.JCZQBiFenGroupModel;
import com.rjp.shell.model.JCZQBiFenModel;
import com.rjp.shell.network.NetSuccessCallback;
import com.rjp.shell.network.NetUtils;
import com.rjp.shell.utils.ImageUtils;
import com.scwang.smartrefresh.layout.api.RefreshFooter;
import com.scwang.smartrefresh.layout.api.RefreshHeader;

/**
 * author : Gimpo create on 2018/4/10 19:10
 * email  : jimbo922@163.com
 */

public class JCZQBiFenListView extends PinnedListView<JCZQBiFenGroupModel> {
    private String gameEn;

    public JCZQBiFenListView(Context context) {
        super(context);
    }

    public JCZQBiFenListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        setHeaderView(R.layout.item_jczq_bifen_list_view_group);
    }

    @Override
    protected RefreshFooter getRefreshFooter() {
        return null;
    }

    @Override
    protected RefreshHeader getRefreshHeader() {
        return new DefaultHeader(mContext);
    }

    @Override
    protected PinnedHeaderExpandableAdapter getPinnedListAdapter() {
        return new PinnedHeaderExpandableAdapter<JCZQBiFenGroupModel, JCZQBiFenModel>(mContext, mDatas, listView) {
            @Override
            protected View initGroupView(int groupPosition, boolean isExpanded, View convertView, ViewGroup parent) {
                if(convertView == null){
                    convertView = layoutInflater.inflate(R.layout.item_jczq_bifen_list_view_group, parent, false);
                    convertView.setTag(new GroupHolder(convertView));
                }
                GroupHolder holder = (GroupHolder) convertView.getTag();
                JCZQBiFenGroupModel model = mDatas.get(groupPosition);
                holder.tvTime.setText(model.getPeriod());
                holder.tvCount.setText("共" + model.getChildren().size() + "场");
                return convertView;
            }

            @Override
            public View initChildView(int type, int groupPosition, int childPosition, View convertView, ViewGroup parent) {
                if(convertView == null){
                    convertView = layoutInflater.inflate(R.layout.item_jczq_bifen_list_view_child, parent, false);
                    convertView.setTag(new ChildHolder(convertView));
                }
                ChildHolder holder = (ChildHolder) convertView.getTag();
                JCZQBiFenModel model = getChild(groupPosition, childPosition);
                holder.tvWeek.setText(model.getMatchOrder());
                holder.tvClub.setText(model.getLeagueName());
                holder.tvTime.setText(model.getMatchTime());
                holder.tvHome.setText(model.getTeamA());
                holder.tvStatus.setText(model.getStatusDesc());
                holder.tvAllScore.setText("全场 " + model.getTeamAGoal() + ":" + model.getTeamBGoal());
                holder.tvHalfScore.setText("半场 " + model.getTeamAHalfGoal() + ":" + model.getTeamBHalfGoal());
                holder.tvAway.setText(model.getTeamB());
                ImageUtils.load(mContext, model.getTeamALogo(), holder.ivHomeLogo);
                ImageUtils.load(mContext, model.getTeamBLogo(), holder.ivAwayLogo);
                return convertView;
            }

            @Override
            public void configureHeader(View header, int groupPosition, int childPosition, int alpha) {
                JCZQBiFenGroupModel model = mDatas.get(groupPosition);
                TextView tvTime = (TextView) header.findViewById(R.id.tv_time);
                TextView tvCount = (TextView) header.findViewById(R.id.tv_count);
                tvTime.setText(model.getPeriod());
                tvCount.setText("共" + model.getChildren().size() + "场");
            }
        };
    }

    public class GroupHolder{
        TextView tvTime;
        TextView tvCount;

        public GroupHolder(View view){
            tvTime = (TextView) view.findViewById(R.id.tv_time);
            tvCount = (TextView) view.findViewById(R.id.tv_count);
        }
    }

    public class ChildHolder{
        TextView tvWeek;
        TextView tvClub;
        TextView tvTime;
        TextView tvHome;
        TextView tvStatus;
        TextView tvAllScore;
        TextView tvHalfScore;
        TextView tvAway;

        ImageView ivHomeLogo;
        ImageView ivAwayLogo;

        public ChildHolder(View view){
            tvWeek = (TextView) view.findViewById(R.id.tv_week);
            tvClub = (TextView) view.findViewById(R.id.tv_club);
            tvTime = (TextView) view.findViewById(R.id.tv_time);
            tvHome = (TextView) view.findViewById(R.id.tv_home);
            tvStatus = (TextView) view.findViewById(R.id.tv_status);
            tvAllScore = (TextView) view.findViewById(R.id.tv_all_score);
            tvHalfScore = (TextView) view.findViewById(R.id.tv_half_score);
            tvAway = (TextView) view.findViewById(R.id.tv_away);
            ivHomeLogo = (ImageView) view.findViewById(R.id.tv_home_logo);
            ivAwayLogo = (ImageView) view.findViewById(R.id.tv_away_logo);
        }
    }

    @Override
    protected void resetFirstPage() {

    }

    @Override
    protected View getEmptyView() {
        return null;
    }

    public void requestData(String gameEn){
        this.gameEn = gameEn;
        requestData();
    }

    @Override
    protected void requestData() {
        String url = "http://api.caipiao.163.com/jjc_live.html?mobileType=android&channel=miui_cps&apiLevel=27&apiVer=1.1&ver=4.31";
        JSONObject jsonObject = new JSONObject();
        jsonObject.put("gameEn", gameEn);
        NetUtils.getInstance().post(mContext, url, jsonObject, new NetSuccessCallback() {
            @Override
            public void onSuccess(String result) {
                try {
                    JSONObject parseObject = JSONObject.parseObject(result);
                    JSONArray standings = parseObject.getJSONArray("data");
                    mDatas.clear();
                    mDatas.addAll(JSONArray.parseArray(standings.toString(), JCZQBiFenGroupModel.class));
                    notifyDataSetChanged();
                    refreshLayout.finishRefresh();
                    listView.expandAll();
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
