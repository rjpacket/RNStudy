package com.rjp.shell.ui.main_page;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseActivity;
import com.rjp.shell.listviews.OpenPrizeHistoryListView;
import com.rjp.shell.utils.LotteryTypeUtils;

import butterknife.BindView;

public class OpenPrizeHistoryActivity extends BaseActivity {
    @BindView(R2.id.open_prize_history_list_view)
    OpenPrizeHistoryListView listView;

    public static void trendTo(Context context, String lotteryType){
        Intent intent = new Intent(context, OpenPrizeHistoryActivity.class);
        intent.putExtra("lotteryType", lotteryType);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_open_prize_history);
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        if(intent != null && intent.hasExtra("lotteryType")){
            String lotteryType = intent.getStringExtra("lotteryType");
            setCommonTitle(LotteryTypeUtils.getLotteryName(lotteryType) + "开奖历史");
            listView.requestData(LotteryTypeUtils.getFileName(lotteryType));
        }
    }
}
