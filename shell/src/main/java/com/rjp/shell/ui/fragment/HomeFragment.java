package com.rjp.shell.ui.fragment;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.alibaba.fastjson.JSONArray;
import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseFragment;
import com.rjp.shell.model.HomeNewsModel;
import com.rjp.shell.network.NetSuccessCallback;
import com.rjp.shell.network.NetUtils;
import com.rjp.shell.ui.activity.BiFenRecordActivity;
import com.rjp.shell.ui.activity.ChampionActivity;
import com.rjp.shell.ui.activity.DailyRecommendActivity;
import com.rjp.shell.ui.activity.HeadNewsActivity;
import com.rjp.shell.ui.activity.LeagueListActivity;
import com.rjp.shell.utils.AppUtils;
import com.rjp.shell.utils.FileUtils;
import com.rjp.shell.utils.ImageUtils;
import com.rjp.shell.views.LooperLabelView;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import org.jsoup.Jsoup;
import org.jsoup.nodes.Document;
import org.jsoup.nodes.Element;
import org.jsoup.select.Elements;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;

import static android.view.View.GONE;
import static android.view.View.VISIBLE;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    @BindView(R2.id.banner_view)
    Banner banner;
    @BindView(R2.id.ll_news_container)
    LinearLayout newsContainer;
    @BindView(R2.id.loop_notice_view)
    LooperLabelView noticeView;
    @BindView(R2.id.ll_label1)
    LinearLayout llLabel1;
    @BindView(R2.id.ll_label2)
    LinearLayout llLabel2;
    @BindView(R2.id.ll_label3)
    LinearLayout llLabel3;
    @BindView(R2.id.ll_label4)
    LinearLayout llLabel4;

    public HomeFragment() {
        // Required empty public constructor
    }

    public static HomeFragment getInstance(){
        return new HomeFragment();
    }

    @Override
    public int getChildViewLayoutId() {
        return R.layout.fragment_home;
    }

    @Override
    public void initView() {
        ArrayList<Integer> urls = new ArrayList<>();
        urls.add(R.drawable.banner_1);
        urls.add(R.drawable.banner_4);
        banner.setImages(urls);
        banner.setImageLoader(new ImageLoader() {
            @Override
            public void displayImage(Context context, Object path, ImageView imageView) {
                imageView.setImageResource((Integer) path);
            }
        });
        banner.start();

        ViewGroup.LayoutParams layoutParams = banner.getLayoutParams();
        layoutParams.height = AppUtils.screenWidth(mContext) / 2;
        banner.setLayoutParams(layoutParams);

        getHomeNews();

        getNoticeList();

        llLabel1.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                BiFenRecordActivity.trendTo(mContext);
            }
        });
        llLabel2.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                LeagueListActivity.trendTo(mContext);
            }
        });
        llLabel3.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                ChampionActivity.trendTo(mContext);
            }
        });
        llLabel4.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                DailyRecommendActivity.trendTo(mContext);
            }
        });
    }

    private void getNoticeList() {
        String url = "http://zxwap.caipiao.163.com/zx/wap_list.html?cache=" + System.currentTimeMillis() + "&pageNo=1&tp=toutiao&ajax=1";
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
                    List<String> titles = new ArrayList<>();
                    for (HomeNewsModel model : models) {
                        titles.add(model.getTitle());
                    }
                    noticeView.setData(titles);
                } catch (Exception e) {
                    e.printStackTrace();
                }
            }
        });
    }

    private void getHomeNews() {
        String assets = FileUtils.getAssets(mContext, "home_all.json");
        List<HomeNewsModel> homeNewsModels = JSONArray.parseArray(assets, HomeNewsModel.class);
        LayoutInflater layoutInflater = LayoutInflater.from(mContext);
        for (int i = 0; i < 10; i++) {
            HomeNewsModel item = homeNewsModels.get(i);
            View view = layoutInflater.inflate(R.layout.item_byhome_news_list_view, null);
            ImageView ivBigPic = (ImageView) view.findViewById(R.id.iv_big_pic);
            ImageView ivSmallPic = (ImageView) view.findViewById(R.id.iv_small_pic);
            TextView tvTitle = (TextView) view.findViewById(R.id.tv_news_title);
            TextView tvTag = (TextView) view.findViewById(R.id.tv_news_tag);
            TextView tvTime = (TextView) view.findViewById(R.id.tv_news_time);
            View newsLine = view.findViewById(R.id.news_line);

            ViewGroup.LayoutParams layoutParams = newsLine.getLayoutParams();
            if (item.getTitle().length() >= 20) {
                ivBigPic.setVisibility(VISIBLE);
                ivSmallPic.setVisibility(GONE);
                ImageUtils.load(mContext, item.getImg(), ivBigPic);
                layoutParams.height = AppUtils.dp2px(mContext, 10);
            } else {
                ivBigPic.setVisibility(GONE);
                ivSmallPic.setVisibility(VISIBLE);
                ImageUtils.load(mContext, item.getImg(), ivSmallPic);
                layoutParams.height = 1;
            }
            newsLine.setLayoutParams(layoutParams);

            tvTitle.setText(item.getTitle());
            String tag = item.getTag();
            List<String> list = JSONArray.parseArray(tag, String.class);
            if (list != null && list.size() > 0) {
                tvTag.setVisibility(VISIBLE);
                tvTag.setText(list.get(0));
            } else {
                tvTag.setVisibility(GONE);
            }
            tvTime.setText(item.getNewsTime() + "");
            newsContainer.addView(view);
        }
    }

    @Override
    public void reload() {

    }
}
