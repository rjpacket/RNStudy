package com.rjp.shell.listviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.rjp.shell.R;
import com.rjp.shell.base.CustomListView;
import com.rjp.shell.model.WYOpenPrizeModel;
import com.rjp.shell.network.NetSuccessCallback;
import com.rjp.shell.network.NetUtils;
import com.rjp.shell.views.OpenPrizeView;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import java.util.List;

/**
 * 通用的网易资讯请求入口
 * author : Gimpo create on 2018/4/10 15:18
 * email  : jimbo922@163.com
 */

public class WYOpenPrizeListView extends CustomListView<WYOpenPrizeModel> {

    public WYOpenPrizeListView(Context context) {
        super(context);
    }

    public WYOpenPrizeListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected BaseAdapter getListAdapter() {
        return new CommonAdapter<WYOpenPrizeModel>(mContext, R.layout.item_wy_open_prize_list_view, mDatas) {
            @Override
            protected void convert(ViewHolder viewHolder, WYOpenPrizeModel item, int position) {
                OpenPrizeView openPrizeView = viewHolder.getView(R.id.open_prize_view);
                openPrizeView.setPrizeModel(item);
            }
        };
    }

    @Override
    protected boolean isFirstPage() {
        return mPage == 1;
    }

    @Override
    protected List<WYOpenPrizeModel> parseData(Object data) {
        return JSONArray.parseArray(data.toString(), WYOpenPrizeModel.class);
    }

    @Override
    protected void resetFirstPage() {
        mPage = 1;
        mPageSize = 30;
    }

    @Override
    public void requestData() {
        String url = "http://api.ttacp8.com/award_home.html?mobileType=android&ver=1.5.1&channel=tgwdaoliu&apiVer=1.1&apiLevel=4&deviceId=866146031016284&product=ttacp8_client";
        NetUtils.getInstance().get(mContext, url, new NetSuccessCallback() {
            @Override
            public void onSuccess(String result) {
                JSONObject jsonObject = JSONObject.parseObject(result);
                dealSuccessData(jsonObject.get("data"));
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {

    }
}
