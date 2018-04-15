package com.rjp.shell.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseActivity;
import com.rjp.shell.listviews.JCZQBiFenListView;
import com.rjp.shell.listviews.WYNewsListView;

import butterknife.BindView;

public class BiFenRecordActivity extends BaseActivity {

    @BindView(R2.id.bifen_list_view)
    JCZQBiFenListView listView;

    public static void trendTo(Context context){
        context.startActivity(new Intent(context, BiFenRecordActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_bifen_record);
    }

    @Override
    protected void initView() {
        setCommonTitle("足彩比分");

        listView.requestData("jczq");
    }
}
