package com.rjp.shell.views;

import android.content.Context;
import android.graphics.drawable.Drawable;
import android.os.Build;
import android.util.AttributeSet;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.utils.AppUtils;
import com.rjp.shell.utils.StatusBarTools;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * @author Gimpo create on 2017/8/16 10:36
 * @email : jimbo922@163.com
 */

public class CommonTitleBar extends LinearLayout {
    @BindView(R2.id.system_bar)
    View systemBar;
    @BindView(R2.id.iv_common_back)
    ImageView ivBack;
    @BindView(R2.id.tv_common_title)
    TextView tvTitle;
    @BindView(R2.id.tv_right_function0)
    TextView tvFunction;
    @BindView(R2.id.iv_image0)
    ImageView ivImage0;
    @BindView(R2.id.iv_image1)
    ImageView ivImage1;

    private Context mContext;

    private OnCommonTitleBarClickListener listener;
    private OnTabLayoutClickListener tabLayoutClickListener;

    public CommonTitleBar(Context context) {
        super(context);
        initView(context);
    }

    public CommonTitleBar(Context context, AttributeSet attrs) {
        super(context, attrs);
        initView(context);
    }

    public CommonTitleBar(Context context, AttributeSet attrs, int defStyleAttr) {
        super(context, attrs, defStyleAttr);
        initView(context);
    }

    public void initView(Context mContext) {
        this.mContext = mContext;
        LayoutInflater.from(mContext).inflate(R.layout.layout_common_title_bar, this);
        ButterKnife.bind(this);
        setId(R.id.common_title_bar);
        setOrientation(VERTICAL);
        setBackgroundResource(R.drawable.shape_maincolor_maincolor_0);
    }

    /**
     * 添加状态栏
     */
    public void addSystemBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ViewGroup.LayoutParams layoutParams = systemBar.getLayoutParams();
            layoutParams.height = StatusBarTools.getStatusBarHeight(mContext);
            systemBar.setLayoutParams(layoutParams);
            systemBar.setBackgroundResource(R.drawable.shape_maincolor_maincolor_0);
//            ViewGroup.LayoutParams layoutParams1 = getLayoutParams();
//            layoutParams1.height += layoutParams.height;
//            setLayoutParams(layoutParams1);
        }
    }

    public void setCommonTitle(String title) {
        tvTitle.setVisibility(VISIBLE);
        tvTitle.setText(title);
    }

    public void setRightFunction0(String function0) {
        tvFunction.setText(function0);
        tvFunction.setVisibility(VISIBLE);
    }

    public void setRightFunction0DrawableLeft(int resId) {
        Drawable drawable = getResources().getDrawable(resId);
        drawable.setBounds(0, 0, drawable.getMinimumWidth(), drawable.getMinimumHeight());
        tvFunction.setCompoundDrawablePadding(AppUtils.dp2px(mContext, 10));
        tvFunction.setCompoundDrawables(drawable, null, null, null);
    }

    @OnClick({R2.id.iv_common_back, R2.id.tv_right_function0, R2.id.tv_common_title, R2.id.iv_image0, R2.id.iv_image1})
    public void onClick(View view) {
        if (listener != null) {
            listener.onTitleBarClick(view);
        }
    }

    public void setOnCommonTitleBarClickListener(OnCommonTitleBarClickListener listener) {
        this.listener = listener;
    }

    public View getRightFunction0() {
        return tvFunction;
    }

    public void setTabLayoutClickListener(OnTabLayoutClickListener tabLayoutClickListener) {
        this.tabLayoutClickListener = tabLayoutClickListener;
    }

    public void setImage0(int resId) {
        ivImage0.setImageResource(resId);
        ivImage0.setVisibility(VISIBLE);
    }

    public void setImage1(int resId) {
        ivImage1.setImageResource(resId);
        ivImage1.setVisibility(VISIBLE);
    }

    public interface OnCommonTitleBarClickListener {
        void onTitleBarClick(View view);
    }

    public interface OnTabLayoutClickListener {
        void onTabLayoutClick(int position);
    }
}
