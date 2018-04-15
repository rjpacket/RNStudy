package com.rjp.shell.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rjp.shell.R;
import com.rjp.shell.ui.activity.HeadNewsActivity;

import java.util.ArrayList;
import java.util.List;

/**
 * author : Gimpo create on 2018/4/13 19:39
 * email  : jimbo922@163.com
 */

public class LooperLabelView extends LinearLayout {

    private Context mContext;
    private List<String> titles;
    private FrameLayout container;
    private int index = 0;
    private List<View> viewCache = new ArrayList<>();
    private View topView;
    private View bottomView;

    public LooperLabelView(Context context) {
        this(context, null);
    }

    public LooperLabelView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        mContext = context;
        LayoutInflater.from(mContext).inflate(R.layout.layout_looper_label_view, this);
        container = (FrameLayout) findViewById(R.id.label_container);
    }

    private void startAnim() {
        topView = container.getChildAt(1);
        topView.measure(0, 0);
        int topHeight = topView.getMeasuredHeight();
        ObjectAnimator anim1 = ObjectAnimator.ofFloat(topView, "translationY", 0, -topHeight);
        Log.d("----->", topHeight + "");
        anim1.setDuration(1000);
        anim1.setStartDelay(2000);
        anim1.start();

        bottomView = container.getChildAt(0);
        bottomView.measure(0, 0);
        int bottomHeight = bottomView.getMeasuredHeight();
        ObjectAnimator anim2 = ObjectAnimator.ofFloat(bottomView, "translationY", bottomHeight, 0);
        Log.d("----->", bottomHeight + "");
        anim2.setDuration(1000);
        anim2.setStartDelay(2000);
        anim2.start();
        anim2.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                container.removeView(topView);
                viewCache.add(topView);
                addLabel();
                startAnim();
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });

        setOnClickListener(new OnClickListener() {
            @Override
            public void onClick(View v) {
                HeadNewsActivity.trendTo(mContext);
            }
        });
    }

    private void addLabel() {
        LooperItemLabelView itemLabelView;
        if (viewCache.size() > 0) {
            itemLabelView = (LooperItemLabelView) viewCache.remove(0);
        } else {
            itemLabelView = new LooperItemLabelView(mContext);
        }
        itemLabelView.setData(titles.get(index), titles.get(index + 1));
        container.addView(itemLabelView, 0);
        index += 2;
        if (index >= titles.size() - 1) {
            index = 0;
        }
    }

    public void setData(List<String> models){
        if(models.size() % 2 != 0){
            models.remove(0);
        }
        titles = models;
        addLabel();
        addLabel();
        startAnim();
    }
}
