package com.rjp.shell.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;
import android.widget.TextView;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailActivity extends BaseActivity {


    @BindView(R2.id.tv_news_title) TextView tvNewsTitle;
    @BindView(R2.id.tv_news_tag) TextView tvNewsTag;
    @BindView(R2.id.tv_news_time) TextView tvNewsTime;
    @BindView(R2.id.web_view) WebView webView;

    public static void trendTo(Context context, String title, String tag, String time, String content) {
        Intent intent = new Intent(context, NewsDetailActivity.class);
        intent.putExtra("title", title);
        intent.putExtra("tag", tag);
        intent.putExtra("time", time);
        intent.putExtra("content", content);
        context.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_news_detail);
        ButterKnife.bind(this);
    }

    @Override
    protected void initView() {
        setCommonTitle("新闻详情");

        Intent intent = getIntent();
        if(intent != null && intent.hasExtra("title")){
            setRightFunction0("收藏");
            tvNewsTitle.setText(intent.getStringExtra("title"));
            tvNewsTag.setText(intent.getStringExtra("tag"));
            tvNewsTime.setText(intent.getStringExtra("time"));
            webView.loadDataWithBaseURL(null, intent.getStringExtra("content"), "text/html", "utf-8", null);
        }
    }

    @Override
    protected void onFunction0Click() {

    }
}
