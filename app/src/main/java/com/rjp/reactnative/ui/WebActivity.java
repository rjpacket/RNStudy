package com.rjp.reactnative.ui;

import android.app.Activity;
import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.webkit.WebView;

import com.rjp.reactnative.R;

public class WebActivity extends Activity {

    public static void trendTo(Context mContext, String url){
        Intent intent = new Intent(mContext, WebActivity.class);
        intent.putExtra("url", url);
        mContext.startActivity(intent);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_web);

        WebView webView = (WebView) findViewById(R.id.web_view);

        Intent intent = getIntent();
        if(intent != null && intent.hasExtra("url")){
            String url = intent.getStringExtra("url");
            SetWebViewTools.setWebView(url, webView, this);
        }
    }
}
