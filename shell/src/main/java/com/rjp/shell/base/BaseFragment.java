package com.rjp.shell.base;


import android.content.Context;
import android.os.Bundle;
import android.support.annotation.Nullable;
import android.support.v4.app.Fragment;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.Toast;

import com.rjp.shell.R;

import butterknife.ButterKnife;

/**
 * A simple {@link Fragment} subclass.
 */
public abstract class BaseFragment extends Fragment implements View.OnClickListener{
    protected final String TAG = this.getClass().toString();

    protected Context mContext;
    RelativeLayout baseContent;
    LinearLayout baseNoNet;
    private boolean isPrepared;
    protected LayoutInflater mInflater;
    private View view;

    public BaseFragment() {
        // Required empty public constructor
    }

    @Override
    public void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = getContext();
        mInflater = LayoutInflater.from(mContext);
    }

    @Override
    public View onCreateView(LayoutInflater inflater, ViewGroup container, Bundle savedInstanceState) {
        view = inflater.inflate(R.layout.fragment_base, container, false);
        baseContent = (RelativeLayout) view.findViewById(R.id.base_content);
        baseNoNet = (LinearLayout) view.findViewById(R.id.base_no_net);
        baseNoNet.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                reload();
            }
        });

        View childView = inflater.inflate(getChildViewLayoutId(), container, false);
        baseContent.addView(childView);

        ButterKnife.bind(this, view);
        initView();
        return view;
    }

    @Override
    public void onClick(View v) {

    }

    public View getRootView(){
        return view;
    }

    /**
     * 刷新页面布局
     *
     * @param isReloadSuccess 是否重新加载成功
     */
    public void reloading(boolean isReloadSuccess) {
        if (!isReloadSuccess) {
            baseContent.setVisibility(View.INVISIBLE);
            baseNoNet.setVisibility(View.VISIBLE);
        } else {
            baseContent.setVisibility(View.VISIBLE);
            baseNoNet.setVisibility(View.INVISIBLE);
        }
    }

    /**
     * 显示覆盖布局
     *
     * @param view
     */
    public void showCoverView(View view) {
        baseNoNet.addView(view);
        baseNoNet.setVisibility(View.VISIBLE);
        baseContent.setVisibility(View.GONE);
    }

    public void hiddenCoverView() {
        baseNoNet.setVisibility(View.GONE);
        baseContent.setVisibility(View.VISIBLE);
    }

    protected void toast(String msg) {
        Toast.makeText(mContext, msg, Toast.LENGTH_SHORT).show();
    }

    //创建子布局
    public abstract int getChildViewLayoutId();

    //初始化子界面
    public abstract void initView();

    //点击 网络错误按钮 重新加载页面
    public abstract void reload();
}
