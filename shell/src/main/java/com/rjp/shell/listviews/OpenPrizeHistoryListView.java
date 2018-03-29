package com.rjp.shell.listviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.rjp.shell.R;
import com.rjp.shell.base.LoadMoreListView;
import com.rjp.shell.model.OpenPrizeModel;
import com.rjp.shell.utils.FileUtils;
import com.rjp.shell.utils.ShowBallFactory;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.List;

public class OpenPrizeHistoryListView extends LoadMoreListView<OpenPrizeModel> {
    private String tag;
    private List<OpenPrizeModel> homeNewsModels;

    public OpenPrizeHistoryListView(Context context) {
        super(context);
    }

    public OpenPrizeHistoryListView(Context context, @Nullable AttributeSet attrs) {
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
        return new CommonAdapter<OpenPrizeModel>(mContext, R.layout.item_open_lottery_history_list_view, mDatas) {
            @Override
            protected void convert(ViewHolder holder, OpenPrizeModel item, int position) {
                TextView tvQi = holder.getView(R.id.tv_open_lottery_qi);
                TextView tvDate = holder.getView(R.id.tv_open_lottery_date);

                LinearLayout llBall = holder.getView(R.id.ll_ball_container);

                OpenPrizeModel model = mDatas.get(position);
                String type = model.getLotteryType();

                tvQi.setText("第" + model.getPhase() + "期");
                tvDate.setText(model.getDrawTime());

                llBall.setVisibility(View.VISIBLE);
                llBall.removeAllViews();
                llBall.addView(ShowBallFactory.getShowBallView(mContext, type, model.getWincode()));
            }
        };
    }

    @Override
    protected void requestData() {
        if (homeNewsModels == null || homeNewsModels.size() == 0) {
            String assets = FileUtils.getAssets(mContext, tag);
            homeNewsModels = JSONArray.parseArray(assets, OpenPrizeModel.class);
        }
        int toIndex = mPageSize + mPage;
        if (toIndex >= homeNewsModels.size()) {
            dealFailureData();
        } else {
            List<OpenPrizeModel> homeNewsModels = this.homeNewsModels.subList(mPage, toIndex);
            dealSuccessData(JSONArray.toJSONString(homeNewsModels));
        }
    }

    /**
     * 暴漏出去
     * @param tag
     */
    public void requestData(String tag){
        this.tag = tag;
        requestData();
    }

    @Override
    protected boolean isFirstPage() {
        return mPage == 0;
    }

    @Override
    protected List<OpenPrizeModel> parseData(Object data) {
        return JSONArray.parseArray(data.toString(), OpenPrizeModel.class);
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
