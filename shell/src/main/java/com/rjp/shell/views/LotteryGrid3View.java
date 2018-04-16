package com.rjp.shell.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.LinearLayout;

import com.alibaba.fastjson.JSONArray;
import com.rjp.shell.R;
import com.rjp.shell.model.LotteryBean;
import com.rjp.shell.utils.FileUtils;

import java.util.List;

/**
 * author : Gimpo create on 2018/4/16 12:39
 * email  : jimbo922@163.com
 */

public class LotteryGrid3View extends LinearLayout {

    private LotteryView lv0;
    private LotteryView lv1;
    private LotteryView lv2;
    private LotteryView lv3;
    private LotteryView lv4;
    private LotteryView lv5;
    private LotteryView lv6;
    private LotteryView lv7;
    private LotteryView lv8;

    public LotteryGrid3View(Context context) {
        this(context, null);
    }

    public LotteryGrid3View(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.layout_lottery_grid3_view, this);
        lv0 = (LotteryView) findViewById(R.id.lv_0);
        lv1 = (LotteryView) findViewById(R.id.lv_1);
        lv2 = (LotteryView) findViewById(R.id.lv_2);
        lv3 = (LotteryView) findViewById(R.id.lv_3);
        lv4 = (LotteryView) findViewById(R.id.lv_4);
        lv5 = (LotteryView) findViewById(R.id.lv_5);
        lv6 = (LotteryView) findViewById(R.id.lv_6);
        lv7 = (LotteryView) findViewById(R.id.lv_7);
        lv8 = (LotteryView) findViewById(R.id.lv_8);

        String assets = FileUtils.getAssets(context, "lottery.json");
        List<LotteryBean> lotteryModels = JSONArray.parseArray(assets, LotteryBean.class);
        lv0.setModel(lotteryModels.get(0));
        lv1.setModel(lotteryModels.get(1));
        lv2.setModel(lotteryModels.get(2));
        lv3.setModel(lotteryModels.get(3));
        lv4.setModel(lotteryModels.get(4));
        lv5.setModel(lotteryModels.get(5));
        lv6.setModel(lotteryModels.get(6));
        lv7.setModel(lotteryModels.get(7));
        lv8.setModel(lotteryModels.get(8));

        lv0.setOnClickListener(mListener);
    }

    private OnClickListener mListener = new OnClickListener() {
        @Override
        public void onClick(View v) {
            LotteryBean model = (LotteryBean) v.getTag();

        }
    };
}
