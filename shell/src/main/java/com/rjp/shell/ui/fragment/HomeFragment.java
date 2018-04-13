package com.rjp.shell.ui.fragment;


import android.content.Context;
import android.support.v4.app.Fragment;
import android.view.ViewGroup;
import android.widget.ImageView;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseFragment;
import com.rjp.shell.utils.AppUtils;
import com.youth.banner.Banner;
import com.youth.banner.loader.ImageLoader;

import java.util.ArrayList;

import butterknife.BindView;


/**
 * A simple {@link Fragment} subclass.
 */
public class HomeFragment extends BaseFragment {

    @BindView(R2.id.banner_view)
    Banner banner;

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
    }

    @Override
    public void reload() {

    }
}
