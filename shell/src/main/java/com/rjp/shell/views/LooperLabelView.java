package com.rjp.shell.views;

import android.animation.Animator;
import android.animation.ObjectAnimator;
import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.widget.LinearLayout;

import com.rjp.shell.R;

/**
 * author : Gimpo create on 2018/4/13 19:39
 * email  : jimbo922@163.com
 */

public class LooperLabelView extends LinearLayout {

    private LinearLayout llLabel1;
    private LinearLayout llLabel2;

    public LooperLabelView(Context context) {
        this(context, null);
    }

    public LooperLabelView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        initView(context, attrs);
    }

    private void initView(Context context, AttributeSet attrs) {
        LayoutInflater.from(context).inflate(R.layout.layout_looper_label_view, this);
        llLabel1 = (LinearLayout) findViewById(R.id.ll_label_1);
        llLabel2 = (LinearLayout) findViewById(R.id.ll_label_2);

        translationX(llLabel1);
        translationX(llLabel2);
    }

    private void translationX(final LinearLayout llLabel1) {
        final ObjectAnimator translationX = new ObjectAnimator().ofFloat(llLabel1,"translationY",llLabel1.getTop(),llLabel1.getTop() - llLabel1.getMeasuredHeight());
        translationX.setDuration(1000);
        translationX.setStartDelay(2000);
        translationX.start();
        translationX.addListener(new Animator.AnimatorListener() {
            @Override
            public void onAnimationStart(Animator animation) {

            }

            @Override
            public void onAnimationEnd(Animator animation) {
                llLabel1.setTranslationX(llLabel1.getTop() + llLabel1.getMeasuredHeight());
                translationX(llLabel1);
            }

            @Override
            public void onAnimationCancel(Animator animation) {

            }

            @Override
            public void onAnimationRepeat(Animator animation) {

            }
        });
    }
}
