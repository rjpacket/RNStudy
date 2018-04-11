package com.rjp.shell.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.os.Handler;
import android.test.InstrumentationTestRunner;
import android.text.TextUtils;
import android.view.MotionEvent;
import android.view.View;
import android.widget.LinearLayout;
import android.widget.TextView;
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

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

/**
 * 生日选号页面
 */
public class Birthday2LotteryActivity extends BaseActivity {
    private int lotteryType = 1;
    private LinearLayout llContainer;
    private TextView tvYear;
    private TextView tvMonth;
    private TextView tvDay;
    private TextView tvTip;
    private String currentDate;

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
        tvYear = (TextView) findViewById(R.id.tv_year);
        tvMonth = (TextView) findViewById(R.id.tv_month);
        tvDay = (TextView) findViewById(R.id.tv_day);
        tvTip = (TextView) findViewById(R.id.tv_tip);

        Intent intent = getIntent();
        if(intent != null && intent.hasExtra("lotteryType")){
            lotteryType = intent.getIntExtra("lotteryType", 1);
        }

        setCommonTitle(LotteryTypeUtils.getLotteryTag(lotteryType) + "生日选号");

        findViewById(R.id.tv_auto_select1).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(currentDate)){
                    showLoading("正在用力生成...");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            hiddenLoading();
                            LotteryModel lotteryModel = AutoSelectLotteryUtils.getInstance().roll1(lotteryType);
                            addLotteryView(lotteryModel);
                        }
                    }, 2000);
                }else{
                    toast("请先选择日期");
                }
            }
        });

        findViewById(R.id.tv_auto_select5).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                if(!TextUtils.isEmpty(currentDate)){
                    showLoading("正在用力生成...");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            hiddenLoading();
                            List<LotteryModel> lotteryModels = AutoSelectLotteryUtils.getInstance().roll5(lotteryType);
                            for (LotteryModel lotteryModel : lotteryModels) {
                                addLotteryView(lotteryModel);
                            }
                        }
                    }, 2000);
                }else{
                    toast("请先选择日期");
                }
            }
        });


        tvYear.setOnClickListener(clickListener);
        tvMonth.setOnClickListener(clickListener);
        tvDay.setOnClickListener(clickListener);
    }

    private View.OnClickListener clickListener = new View.OnClickListener() {
        @Override
        public void onClick(View v) {
            showDialog();
        }
    };

    private void showDialog() {
        TimePickerView pvTime = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
                currentDate = sdf.format(date);
                String[] split = currentDate.split("-");
                tvYear.setText(split[0] + "年");
                tvMonth.setText(split[1] + "月");
                tvDay.setText(split[2] + "日");
            }
        })
                .setSubmitColor(getResources().getColor(R.color.main_color))
                .setCancelColor(getResources().getColor(R.color.main_color))
                .build();
        pvTime.show();
    }

    private void addLotteryView(LotteryModel lotteryModel) {
        llContainer.setVisibility(View.VISIBLE);
        tvTip.setVisibility(View.VISIBLE);
        llContainer.addView(ShowBallFactory.getShowBallView(mContext, LotteryTypeUtils.getLotteryType(lotteryType), lotteryModel.getBetCode()));
    }
}
