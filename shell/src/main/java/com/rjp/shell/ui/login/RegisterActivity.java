package com.rjp.shell.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.rjp.shell.R;
import com.rjp.shell.base.BaseActivity;

public class RegisterActivity extends BaseActivity {

    public static void trendTo(Context context){
        context.startActivity(new Intent(context, RegisterActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @Override
    protected void initView() {
        setCommonTitle("注册");
    }

    @Override
    protected void onFunction0Click() {

    }
}
