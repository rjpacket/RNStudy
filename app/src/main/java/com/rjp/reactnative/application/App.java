package com.rjp.reactnative.application;

import android.app.Application;

import com.alibaba.android.arouter.launcher.ARouter;
import com.rjp.shell.base.MySharedPreferences;

public class App extends Application{

    @Override
    public void onCreate() {
        super.onCreate();

        ARouter.init(this);
    }
}