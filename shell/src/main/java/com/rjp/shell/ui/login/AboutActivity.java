package com.rjp.shell.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.rjp.shell.R;
import com.rjp.shell.base.BaseActivity;

public class AboutActivity extends BaseActivity {

    public static void trendTo(Context context){
        context.startActivity(new Intent(context, AboutActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about);
    }

    @Override
    protected void initView() {
        setCommonTitle("关于我们");
    }
}
