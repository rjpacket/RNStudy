package com.rjp.shell.ui.login;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.rjp.shell.R;
import com.rjp.shell.base.BaseActivity;

public class EmptyActivity extends BaseActivity {

    public static void trendTo(Context context, String title){
        Intent intent = new Intent(context, EmptyActivity.class);
        intent.putExtra("title", title);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_empty);
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        if(intent != null && intent.hasExtra("title")){
            setCommonTitle(intent.getStringExtra("title"));
        }
    }
}
