package com.rjp.shell.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.view.View;

import com.flyco.tablayout.CommonTabLayout;
import com.flyco.tablayout.listener.CustomTabEntity;
import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseActivity;
import com.rjp.shell.model.TabEntity;
import com.rjp.shell.ui.fragment.SingleTrendFragment;
import com.rjp.shell.utils.LotteryTypeUtils;

import java.util.ArrayList;

import butterknife.BindView;

import static com.rjp.shell.utils.LotteryTypeUtils.DLT;
import static com.rjp.shell.utils.LotteryTypeUtils.FC3D;
import static com.rjp.shell.utils.LotteryTypeUtils.K3;
import static com.rjp.shell.utils.LotteryTypeUtils.PL3;
import static com.rjp.shell.utils.LotteryTypeUtils.PL5;
import static com.rjp.shell.utils.LotteryTypeUtils.QLC;
import static com.rjp.shell.utils.LotteryTypeUtils.QXC;
import static com.rjp.shell.utils.LotteryTypeUtils.SSC;
import static com.rjp.shell.utils.LotteryTypeUtils.SSQ;
import static com.rjp.shell.utils.LotteryTypeUtils.X115;

public class TrendDetailActivity extends BaseActivity {

    @BindView(R2.id.tab_layout)
    CommonTabLayout tabLayout;

    private String[] mTitles;
    private ArrayList<CustomTabEntity> mTabEntities;
    private ArrayList<Fragment> fragments;

    public static void trendTo(Context context, int lotteryType) {
        Intent intent = new Intent(context, TrendDetailActivity.class);
        intent.putExtra("lotteryType", lotteryType);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_trend_detail);
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        if (intent != null && intent.hasExtra("lotteryType")) {
            int lotteryType = intent.getIntExtra("lotteryType", SSQ);
            setCommonTitle(LotteryTypeUtils.getLotteryTag(lotteryType) + "走势图");

            tabLayout.setVisibility(View.VISIBLE);
            fragments = new ArrayList<>();
            mTabEntities = new ArrayList<>();
            switch (lotteryType) {
                case SSQ:
                    mTitles = new String[]{""};
                    tabLayout.setVisibility(View.GONE);
                    fragments.add(SingleTrendFragment.getInstance(SSQ, 1));
                    break;
                case DLT:
                    mTitles = new String[]{""};
                    tabLayout.setVisibility(View.GONE);
                    fragments.add(SingleTrendFragment.getInstance(DLT, 1));
                    break;
                case K3:
                    mTitles = new String[]{"第一位", "第二位", "第三位"};
                    fragments.add(SingleTrendFragment.getInstance(K3, 1));
                    fragments.add(SingleTrendFragment.getInstance(K3, 2));
                    fragments.add(SingleTrendFragment.getInstance(K3, 3));
                    break;
                case FC3D:
                    mTitles = new String[]{"百位", "十位", "个位"};
                    fragments.add(SingleTrendFragment.getInstance(FC3D, 1));
                    fragments.add(SingleTrendFragment.getInstance(FC3D, 2));
                    fragments.add(SingleTrendFragment.getInstance(FC3D, 3));
                    break;
                case X115:
                    mTitles = new String[]{"万位", "千位", "百位", "十位", "个位"};
                    fragments.add(SingleTrendFragment.getInstance(X115, 1));
                    fragments.add(SingleTrendFragment.getInstance(X115, 2));
                    fragments.add(SingleTrendFragment.getInstance(X115, 3));
                    fragments.add(SingleTrendFragment.getInstance(X115, 4));
                    fragments.add(SingleTrendFragment.getInstance(X115, 5));
                    break;
                case PL3:
                    mTitles = new String[]{"百位", "十位", "个位"};
                    fragments.add(SingleTrendFragment.getInstance(PL3, 1));
                    fragments.add(SingleTrendFragment.getInstance(PL3, 2));
                    fragments.add(SingleTrendFragment.getInstance(PL3, 3));
                    break;
                case PL5:
                    mTitles = new String[]{"万位", "千位", "百位", "十位", "个位"};
                    fragments.add(SingleTrendFragment.getInstance(PL5, 1));
                    fragments.add(SingleTrendFragment.getInstance(PL5, 2));
                    fragments.add(SingleTrendFragment.getInstance(PL5, 3));
                    fragments.add(SingleTrendFragment.getInstance(PL5, 4));
                    fragments.add(SingleTrendFragment.getInstance(PL5, 5));
                    break;
                case QXC:
                    mTitles = new String[]{"第一位", "第二位", "第三位", "第四位", "第五位", "第六位", "第七位"};
                    fragments.add(SingleTrendFragment.getInstance(QXC, 1));
                    fragments.add(SingleTrendFragment.getInstance(QXC, 2));
                    fragments.add(SingleTrendFragment.getInstance(QXC, 3));
                    fragments.add(SingleTrendFragment.getInstance(QXC, 4));
                    fragments.add(SingleTrendFragment.getInstance(QXC, 5));
                    fragments.add(SingleTrendFragment.getInstance(QXC, 6));
                    fragments.add(SingleTrendFragment.getInstance(QXC, 7));
                    break;
                case QLC:
                    mTitles = new String[]{""};
                    tabLayout.setVisibility(View.GONE);
                    fragments.add(SingleTrendFragment.getInstance(QLC, 1));
                    break;
                case SSC:
                    mTitles = new String[]{"万位", "千位", "百位", "十位", "个位"};
                    fragments.add(SingleTrendFragment.getInstance(SSC, 1));
                    fragments.add(SingleTrendFragment.getInstance(SSC, 2));
                    fragments.add(SingleTrendFragment.getInstance(SSC, 3));
                    fragments.add(SingleTrendFragment.getInstance(SSC, 4));
                    fragments.add(SingleTrendFragment.getInstance(SSC, 5));
                    break;
            }

            for (int i = 0; i < mTitles.length; i++) {
                mTabEntities.add(new TabEntity(mTitles[i]));
            }
            tabLayout.setTabData(mTabEntities, this, R.id.trend_container, fragments);
        }

    }
}
