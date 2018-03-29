package com.rjp.shell.views;

import android.content.Context;
import android.content.res.TypedArray;
import android.graphics.Color;
import android.support.annotation.Nullable;
import android.text.TextUtils;
import android.util.AttributeSet;
import android.view.Gravity;
import android.view.LayoutInflater;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.rjp.shell.R;
import com.rjp.shell.R2;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * @author Gimpo create on 2017/9/13 11:58
 * @email : jimbo922@163.com
 */

public class SettingView extends LinearLayout {
    private Context mContext;
    @BindView(R2.id.iv_icon)
    ImageView ivIcon;
    @BindView(R2.id.tv_name)
    TextView tvName;
    @BindView(R2.id.tv_desc)
    TextView tvDesc;

    public SettingView(Context context) {
        this(context, null);
    }

    public SettingView(Context context, @Nullable AttributeSet attrs) {
        super(context, attrs);
        mContext = context;
        setOrientation(HORIZONTAL);
        setGravity(Gravity.CENTER_VERTICAL);
        LayoutInflater.from(mContext).inflate(R.layout.layout_setting_view, this);
        ButterKnife.bind(this);
        if(attrs != null){
            TypedArray a = mContext.obtainStyledAttributes(attrs, R.styleable.SettingView);
            int settingIcon = a.getResourceId(R.styleable.SettingView_setting_icon, R.drawable.default_pic);
            boolean settingIconVisible = a.getBoolean(R.styleable.SettingView_setting_icon_visible, false);
            String settingName = a.getString(R.styleable.SettingView_setting_name);
            int settingNameSize = a.getInt(R.styleable.SettingView_setting_name_size, 14);
            int settingNameColor = a.getColor(R.styleable.SettingView_setting_name_color, Color.parseColor("#333333"));

            String settingDesc = a.getString(R.styleable.SettingView_setting_desc);
            int settingDescSize = a.getInt(R.styleable.SettingView_setting_desc_size, 14);
            int settingDescColor = a.getColor(R.styleable.SettingView_setting_desc_color, Color.parseColor("#999999"));

            if(settingIconVisible) {
                ivIcon.setVisibility(VISIBLE);
                ivIcon.setImageResource(settingIcon);
            }
            tvName.setText(settingName);
            tvName.setTextSize(settingNameSize);
            tvName.setTextColor(settingNameColor);
            tvDesc.setText(TextUtils.isEmpty(settingDesc)?"":settingDesc);
            tvDesc.setTextSize(settingDescSize);
            tvDesc.setTextColor(settingDescColor);
        }
    }

    /**
     * 设置右边的显示
     * @param description 描述
     */
    public void setDescription(String description){
        tvDesc.setText(description);
    }
}
