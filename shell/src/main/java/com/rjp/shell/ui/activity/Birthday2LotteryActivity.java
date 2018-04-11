package com.rjp.shell.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.rjp.shell.R;
import com.rjp.shell.base.BaseActivity;
import com.rjp.shell.model.LotteryModel;
import com.rjp.shell.utils.AutoSelectLotteryUtils;
import com.rjp.shell.utils.LotteryTypeUtils;
import com.rjp.shell.utils.ShowBallFactory;

import java.util.Date;

/**
 * 生日选号页面
 */
public class Birthday2LotteryActivity extends BaseActivity {
    private int lotteryType = 1;
    private LinearLayout llContainer;

    public static void trendTo(Context context, int type){
        Intent intent = new Intent(context, Birthday2LotteryActivity.class);
        intent.putExtra("lotteryType", type);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_2_lottery);
    }

    @Override
    protected void initView() {
        llContainer = (LinearLayout) findViewById(R.id.ll_auto_container);

        Intent intent = getIntent();
        if(intent != null && intent.hasExtra("lotteryType")){
            lotteryType = intent.getIntExtra("lotteryType", 1);
        }

        setCommonTitle(LotteryTypeUtils.getLotteryTag(lotteryType) + "生日选号");

        TimePickerView pvTime = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                Toast.makeText(mContext, date.toString(), Toast.LENGTH_SHORT).show();
            }
        })
                .setSubmitColor(Color.parseColor("#eb1c42"))
                .setCancelColor(Color.parseColor("#eb1c42"))
                .build();
        pvTime.show();

        findViewById(R.id.tv_auto_select1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LotteryModel lotteryModel = AutoSelectLotteryUtils.getInstance().roll1(lotteryType);
                addLotteryView(lotteryModel);
            }
        });
    }

    private void addLotteryView(LotteryModel lotteryModel) {
        llContainer.addView(ShowBallFactory.getShowBallView(mContext, LotteryTypeUtils.getLotteryType(lotteryType), lotteryModel.getBetCode()));
    }
}
