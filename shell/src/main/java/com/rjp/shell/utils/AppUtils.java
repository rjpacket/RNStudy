package com.rjp.shell.utils;

import android.content.Context;

public class AppUtils {

    /**
     * dp 转 px
     * @param context
     * @param dpValue
     * @return
     */
    public static int dp2px(Context context, float dpValue) {
        final float scale = context.getResources().getDisplayMetrics().density;
        return (int) (dpValue * scale + 0.5f);
    }

    public static String ten(int number) {
        return String.format("%02d", number);
    }
}
