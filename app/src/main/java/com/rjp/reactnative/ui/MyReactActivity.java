package com.rjp.reactnative.ui;

import android.support.annotation.Nullable;

import com.facebook.react.ReactActivity;

/**
 * author : Gimpo create on 2018/3/23 12:00
 * email  : jimbo922@163.com
 */

public class MyReactActivity extends ReactActivity {

    @Nullable
    @Override
    protected String getMainComponentName() {
        return "HelloWorld";//这个在Registry.registerComponent注册
    }
}
