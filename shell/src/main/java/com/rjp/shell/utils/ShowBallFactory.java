package com.rjp.shell.utils;

import android.content.Context;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rjp.shell.R;

public class ShowBallFactory {

    public static View getShowBallView(Context mContext , String type , String wincode){
        LinearLayout llBall = new LinearLayout(mContext);
        llBall.setOrientation(LinearLayout.HORIZONTAL);
        if ("4001".equals(type) || "4002".equals(type) || "4003".equals(type) || "4004".equals(type)) {
            llBall.setVisibility(View.VISIBLE);
            llBall.removeAllViews();
            String[] split = wincode.split(",");
            for (String str : split) {
                TextView tv = createText(mContext , str);
                llBall.addView(tv);
            }
        } else if("1013".equals(type)
                || "1014".equals(type)
                || "1010".equals(type)){
            llBall.setVisibility(View.VISIBLE);
            llBall.removeAllViews();
            String[] split = wincode.split(",");
            for (String str : split) {
                ImageView tv = createK3Text(mContext , str);
                llBall.addView(tv);
            }
        } else if (!TextUtils.isEmpty(wincode)) {
            llBall.setVisibility(View.VISIBLE);
            llBall.removeAllViews();
            String[] split = wincode.split("\\|");
            if (split.length == 2) {
                String[] leftRed = split[0].split(",");
                for (String str1 : leftRed) {
                    TextView tv = createBall(mContext , str1, 1);
                    llBall.addView(tv);
                }

                String[] rightBlue = split[1].split(",");
                for (String str2 : rightBlue) {
                    TextView tv = createBall(mContext , str2, 2);
                    llBall.addView(tv);
                }
            } else {
                String[] allRed = wincode.split(",");
                for (String str : allRed) {
                    TextView tv = createBall(mContext , str, 1);
                    llBall.addView(tv);
                }
            }
        }

        return llBall;
    }

    /**
     * 获取直径小一些的球
     * @param mContext
     * @param type
     * @param wincode
     * @return
     */
    public static View getShowSmallBallView(Context mContext , String type , String wincode){
        LinearLayout llBall = new LinearLayout(mContext);
        llBall.setOrientation(LinearLayout.HORIZONTAL);
        if (!TextUtils.isEmpty(wincode)) {
            llBall.setVisibility(View.VISIBLE);
            llBall.removeAllViews();
            String[] split = wincode.split("\\|");
            if (split.length == 2) {
                String[] leftRed = split[0].split(",");
                for (String str1 : leftRed) {
                    TextView tv = createBall(mContext , str1, 1, AppUtils.dp2px(mContext, 25), AppUtils.dp2px(mContext, 25));
                    llBall.addView(tv);
                }

                String[] rightBlue = split[1].split(",");
                for (String str2 : rightBlue) {
                    TextView tv = createBall(mContext , str2, 2, AppUtils.dp2px(mContext, 25), AppUtils.dp2px(mContext, 25));
                    llBall.addView(tv);
                }
            } else {
                String[] allRed = wincode.split(",");
                for (String str : allRed) {
                    TextView tv = createBall(mContext , str, 1, AppUtils.dp2px(mContext, 25), AppUtils.dp2px(mContext, 25));
                    llBall.addView(tv);
                }
            }
        }

        return llBall;
    }

    private static TextView createBall(Context mContext , String str2, int type) {
        return createBall(mContext, str2, type, AppUtils.dp2px(mContext, 30), AppUtils.dp2px(mContext, 30));
    }

    private static TextView createBall(Context mContext , String str2, int type , int width , int height) {
        TextView tv = new TextView(mContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(width, height);
        params.setMargins(0, 0, AppUtils.dp2px(mContext, 5), 0);
        tv.setLayoutParams(params);
        tv.setText(str2);
        tv.setTextColor(0xffffffff);
        tv.setTextSize(16);
        tv.setGravity(Gravity.CENTER);
        switch (type) {
            case 1:
                tv.setBackgroundResource(R.drawable.bg_open_red_ball);
                break;
            case 2:
                tv.setBackgroundResource(R.drawable.bg_open_blue_ball);
                break;
            case 3://足球分过长
                tv.setTextColor(mContext.getResources().getColor(R.color.main_color));
                break;
        }
        return tv;
    }

    private static TextView createText(Context mContext , String str2) {
        TextView tv = new TextView(mContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(AppUtils.dp2px(mContext, 16), AppUtils.dp2px(mContext, 30));
        params.setMargins(0, 0, AppUtils.dp2px(mContext, 5), 0);
        tv.setLayoutParams(params);
        tv.setText(str2);
        tv.setTextColor(0xffffffff);
        tv.setTextSize(16);
        tv.setGravity(Gravity.CENTER);
        tv.setBackgroundResource(R.drawable.bg_open_red_rectangle);
        return tv;
    }

    private static ImageView createK3Text(Context mContext , String str) {
        ImageView tv = new ImageView(mContext);
        LinearLayout.LayoutParams params = new LinearLayout.LayoutParams(AppUtils.dp2px(mContext, 30), AppUtils.dp2px(mContext, 30));
        params.setMargins(0, 0, AppUtils.dp2px(mContext, 5), 0);
        tv.setLayoutParams(params);
        switch (str){
            case "1":
                tv.setBackgroundResource(R.drawable.bg_open_one);
                break;
            case "2":
                tv.setBackgroundResource(R.drawable.bg_open_two);
                break;
            case "3":
                tv.setBackgroundResource(R.drawable.bg_open_three);
                break;
            case "4":
                tv.setBackgroundResource(R.drawable.bg_open_four);
                break;
            case "5":
                tv.setBackgroundResource(R.drawable.bg_open_five);
                break;
            case "6":
                tv.setBackgroundResource(R.drawable.bg_open_six);
                break;
        }
        return tv;
    }
}
