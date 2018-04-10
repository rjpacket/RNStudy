package com.rjp.shell.listviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.widget.BaseAdapter;

import com.alibaba.fastjson.JSONArray;
import com.rjp.shell.R;
import com.rjp.shell.base.CustomListView;
import com.rjp.shell.model.LotteryBean;
import com.rjp.shell.utils.FileUtils;
import com.rjp.shell.utils.LotteryTypeUtils;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.List;

/**
 *
 * Created by Administrator on 2018/4/6.
 */

public class RecommendLotteryListView extends CustomListView<LotteryBean> {

    private List<LotteryBean> lotteryModels;

    public RecommendLotteryListView(Context context) {
        super(context);
    }

    public RecommendLotteryListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected BaseAdapter getListAdapter() {
        return new CommonAdapter<LotteryBean>(mContext, R.layout.item_recommend_lottery_list_view, mDatas) {
            @Override
            protected void convert(ViewHolder viewHolder, LotteryBean item, int position) {
                viewHolder.setImageResource(R.id.iv_lottery_icon, LotteryTypeUtils.getLotteryIcon(item.getId()));
                viewHolder.setText(R.id.tv_lottery_name, item.getName());
                viewHolder.setText(R.id.tv_lottery_desc, item.getDesc());
            }
        };
    }

    @Override
    protected boolean isFirstPage() {
        return true;
    }

    @Override
    protected List<LotteryBean> parseData(Object data) {
        return JSONArray.parseArray(data.toString(), LotteryBean.class);
    }

    @Override
    protected void resetFirstPage() {
        mPage = 0;
        mPageSize = 20;
    }

    @Override
    public void requestData() {
        if (lotteryModels == null || lotteryModels.size() == 0) {
            String assets = FileUtils.getAssets(mContext, "lottery.json");
            lotteryModels = JSONArray.parseArray(assets, LotteryBean.class);
        }
        dealSuccessData(JSONArray.toJSONString(lotteryModels));
    }
}
