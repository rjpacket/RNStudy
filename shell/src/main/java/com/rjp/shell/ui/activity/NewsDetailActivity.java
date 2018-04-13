package com.rjp.shell.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.webkit.WebView;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseActivity;
import com.rjp.shell.base.MySharedPreferences;
import com.rjp.shell.model.HomeNewsModel;
import com.rjp.shell.network.NetSuccessCallback;
import com.rjp.shell.network.NetUtils;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;

public class NewsDetailActivity extends BaseActivity {


    @BindView(R2.id.tv_news_title) TextView tvNewsTitle;
    @BindView(R2.id.tv_news_tag) TextView tvNewsTag;
    @BindView(R2.id.tv_news_time) TextView tvNewsTime;
    @BindView(R2.id.web_view) WebView webView;
    private HomeNewsModel model;

    public static void trendTo(Context context, HomeNewsModel homeNewsModel) {
        Intent intent = new Intent(context, NewsDetailActivity.class);
        intent.putExtra("model", homeNewsModel);
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
        if(intent != null && intent.hasExtra("model")){
            setRightFunction0("收藏");

            model = (HomeNewsModel) intent.getSerializableExtra("model");
            String content = model.getContent();
            if(!TextUtils.isEmpty(content)) {
                setData(model);
            }else{
                getNewsContent(model.getUrl());
            }
        }
    }

    /**
     * 获取新闻数据
     * @param url
     */
    private void getNewsContent(String url) {
        NetUtils.getInstance().get(mContext, url, new NetSuccessCallback() {
            @Override
            public void onSuccess(String result) {
                try {
                    Document document = Jsoup.parse(result);
                    Element element = document.select("div.articleCon").first();
                    model.setContent(element.html());
                    setData(model);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void setData(HomeNewsModel model) {
        tvNewsTitle.setText(model.getTitle());
        String tag = model.getTag();
        if(!TextUtils.isEmpty(tag)) {
            List<String> strings = JSONArray.parseArray(tag, String.class);
            tvNewsTag.setText(strings.get(0));
            tvNewsTag.setVisibility(View.VISIBLE);
        }else{
            tvNewsTag.setVisibility(View.GONE);
        }
        tvNewsTime.setText(model.getNewsTime());
        webView.loadDataWithBaseURL(null, model.getContent(), "text/html", "utf-8", null);
    }

    @Override
    protected void onFunction0Click() {
        MySharedPreferences instance = MySharedPreferences.getInstance(mContext);
        String string = instance.getString(MySharedPreferences.SAVE_NEWS);
        if(TextUtils.isEmpty(string)){
            List<HomeNewsModel> models = new ArrayList<>();
            models.add(model);
            instance.putString(MySharedPreferences.SAVE_NEWS, JSONArray.toJSONString(models));
            toast("收藏成功");
        }else{
            List<HomeNewsModel> models = JSONArray.parseArray(string, HomeNewsModel.class);
            boolean isFind = false;
            for (HomeNewsModel homeNewsModel : models) {
                if(homeNewsModel.getId() == model.getId()){
                    toast("这篇新闻已经收藏过了");
                    isFind = true;
                    break;
                }
            }
            if(!isFind){
                models.add(model);
                instance.putString(MySharedPreferences.SAVE_NEWS, JSONArray.toJSONString(models));
                toast("收藏成功");
            }
        }
    }
}
