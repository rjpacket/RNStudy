package com.rjp.shell.listviews;

import android.content.Context;
import android.support.annotation.Nullable;
import android.util.AttributeSet;
import android.view.View;
import android.widget.AdapterView;
import android.widget.BaseAdapter;
import android.widget.ImageView;

import com.alibaba.fastjson.JSONArray;
import com.rjp.shell.R;
import com.rjp.shell.base.LoadMoreListView;
import com.rjp.shell.model.HomeNewsModel;
import com.rjp.shell.network.NetSuccessCallback;
import com.rjp.shell.network.NetUtils;
import com.rjp.shell.ui.activity.NewsDetailActivity;
import com.rjp.shell.utils.ImageUtils;
import com.zhy.adapter.abslistview.CommonAdapter;
import com.zhy.adapter.abslistview.ViewHolder;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

/**
 * 通用的网易资讯请求入口
 * author : Gimpo create on 2018/4/10 15:18
 * email  : jimbo922@163.com
 */

public class WYNewsListView extends LoadMoreListView<HomeNewsModel> {
    private String type = "ssq";

    public WYNewsListView(Context context) {
        super(context);
    }

    public WYNewsListView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
    }

    @Override
    protected BaseAdapter getListAdapter() {
        return new CommonAdapter<HomeNewsModel>(mContext, R.layout.item_wy_news_list_view, mDatas) {
            @Override
            protected void convert(ViewHolder viewHolder, HomeNewsModel item, int position) {
                String title = item.getTitle();
                viewHolder.setText(R.id.tv_news_title, title);
                viewHolder.setText(R.id.tv_news_desc, item.getDesc());
                viewHolder.setText(R.id.tv_news_time, item.getTime());
                ImageView ivBigPic = viewHolder.getView(R.id.iv_big_pic);
                ImageView ivSmallPic = viewHolder.getView(R.id.iv_small_pic);
                if(title.length() > 15){
                    ivBigPic.setVisibility(VISIBLE);
                    ivSmallPic.setVisibility(GONE);
                    ImageUtils.load(mContext, item.getImg(), ivBigPic);
                }else{
                    ivBigPic.setVisibility(GONE);
                    ivSmallPic.setVisibility(VISIBLE);
                    ImageUtils.load(mContext, item.getImg(), ivSmallPic);
                }
            }
        };
    }

    @Override
    protected boolean isFirstPage() {
        return mPage == 1;
    }

    @Override
    protected List<HomeNewsModel> parseData(Object data) {
        return JSONArray.parseArray(data.toString(), HomeNewsModel.class);
    }

    @Override
    protected void resetFirstPage() {
        mPage = 1;
        mPageSize = 30;
    }

    public void requestData(String type) {
        this.type = type;
        requestData();
    }

    @Override
    public void requestData() {
        String url = "http://zxwap.caipiao.163.com/zx/wap_list.html?cache=" + System.currentTimeMillis() + "&pageNo=" + mPage + "&tp=" + type + "&ajax=1";
        NetUtils.getInstance().get(mContext, url, new NetSuccessCallback() {
            @Override
            public void onSuccess(String result) {
                List<HomeNewsModel> models = new ArrayList<>();
                try {
                    Document document = Jsoup.parse(result);
                    Elements elements = document.select("li.newsItem");
                    for (Element element : elements) {
                        HomeNewsModel model = new HomeNewsModel();
                        Element a = element.select("a.newsLink").first();
                        model.setUrl(a.attr("href"));
                        Element img = element.select("img").first();
                        model.setImg(img.attr("src"));
                        Element h2 = element.select("h2").first();
                        model.setTitle(h2.text());
                        Element p = element.select("p").first();
                        model.setDesc(p.text());
                        Element i = element.select("i").first();
                        model.setTime(i.text());
                        models.add(model);
                    }
                    dealSuccessData(JSONArray.toJSONString(models));
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
        NewsDetailActivity.trendTo(mContext, mDatas.get(position));
    }
}
