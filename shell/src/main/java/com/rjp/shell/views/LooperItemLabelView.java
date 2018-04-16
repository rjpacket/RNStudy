package com.rjp.shell.views;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rjp.shell.R;

import static android.graphics.Color.WHITE;

/**
 * author : Gimpo create on 2018/4/13 19:39
 * email  : jimbo922@163.com
 */

public class LooperItemLabelView extends LinearLayout {

    private Context mContext;
    private TextView tv_1;
    private TextView tv_2;

    public LooperItemLabelView(Context context) {
        this(context, null);
    }

    public LooperItemLabelView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        mContext = context;
        setOrientation(VERTICAL);
        setBackgroundColor(WHITE);
        LayoutInflater.from(mContext).inflate(R.layout.item_looper_label_view, this);
        tv_1 = (TextView) findViewById(R.id.tv_1);
        tv_2 = (TextView) findViewById(R.id.tv_2);
    }

    public void setData(String title1, String title2){
        tv_1.setText(title1);
        tv_2.setText(title2);
    }
}
