package com.rjp.shell.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.rjp.shell.R;
import com.rjp.shell.base.BaseActivity;

public class LoginActivity extends BaseActivity {

    public static void trendTo(Context context){
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void initView() {
        setCommonTitle("登录");
        setRightFunction0("注册");
    }

    @Override
    protected void onFunction0Click() {
        RegisterActivity.trendTo(mContext);
    }
}
