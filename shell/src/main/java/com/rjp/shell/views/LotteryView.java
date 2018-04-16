package com.rjp.shell.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rjp.shell.R;
import com.rjp.shell.model.LotteryBean;
import com.rjp.shell.utils.LotteryTypeUtils;

/**
 * author : Gimpo create on 2018/4/16 12:27
 * email  : jimbo922@163.com
 */

public class LotteryView extends LinearLayout {
    private LotteryBean model;
    private ImageView ivLogo;
    private TextView tvName;
    private TextView tvDesc;

    public LotteryView(Context context) {
        this(context, null);
    }

    public LotteryView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        setOrientation(VERTICAL);
        setGravity(Gravity.CENTER);
        LayoutInflater.from(context).inflate(R.layout.layout_lottery_view, this);

        ivLogo = (ImageView) findViewById(R.id.iv_lottery_logo);
        tvName = (TextView) findViewById(R.id.tv_lottery_name);
        tvDesc = (TextView) findViewById(R.id.tv_lottery_desc);
    }

    public void setModel(LotteryBean model){
        this.model = model;
        setTag(model);
        ivLogo.setImageResource(LotteryTypeUtils.getLotteryIcon(model.getId()));
        tvName.setText(model.getName());
        tvDesc.setText(model.getDesc());
    }
}
