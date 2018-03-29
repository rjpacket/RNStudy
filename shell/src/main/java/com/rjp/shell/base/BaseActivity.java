package com.rjp.shell.base;

import android.app.ProgressDialog;
import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.annotation.LayoutRes;
import android.support.annotation.Nullable;
import android.support.v4.app.FragmentActivity;
import android.view.View;
import android.view.ViewGroup;
import android.view.WindowManager;
import android.widget.Toast;

import com.rjp.shell.R;
import com.rjp.shell.utils.AppUtils;
import com.rjp.shell.utils.StatusBarTools;
import com.rjp.shell.utils.SystemBarTintManager;
import com.rjp.shell.views.CommonTitleBar;

import butterknife.ButterKnife;

/**
 * 之后通用base
 * @author Gimpo create on 2017/8/16 11:09
 * @email : jimbo922@163.com
 */

public abstract class BaseActivity extends FragmentActivity implements CommonTitleBar.OnCommonTitleBarClickListener, CommonTitleBar.OnTabLayoutClickListener{
    protected Context mContext;
    private CommonTitleBar commonTitleBar;
    private ProgressDialog loadingDialog;

    @Override
    protected void onCreate(@Nullable Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        mContext = this;
    }

    @Override
    public void setContentView(@LayoutRes int layoutResID) {
        super.setContentView(layoutResID);
        ButterKnife.bind(this);
        if(shouldTransparentSystemBar()) {
            transparentSystemBar();
        }
        try {
            commonTitleBar = (CommonTitleBar) findViewById(R.id.common_title_bar);
        }catch (Exception e){
            commonTitleBar = new CommonTitleBar(mContext);
        }

        if(shouldAddSystemBar()){
            commonTitleBar.addSystemBar();
        }
        getCommonTitleBar().setOnCommonTitleBarClickListener(this);
        getCommonTitleBar().setTabLayoutClickListener(this);
        initView();
    }

    protected abstract void initView();

    protected boolean shouldTransparentSystemBar(){
        return true;
    }

    protected boolean shouldAddSystemBar(){
        return true;
    }

    @Override
    public void onTitleBarClick(View view) {
        int id = view.getId();
        if(id == R.id.iv_common_back){
            onBackClick();
        }else if(id == R.id.tv_right_function0){
            onFunction0Click();
        }else if(id == R.id.tv_common_title){
            onTitleClick();
        }else if(id == R.id.iv_image0){
            onImage0Click();
        }else if(id == R.id.iv_image1){
            onImage1Click();
        }
    }

    @Override
    public void onTabLayoutClick(int position) {

    }

    public CommonTitleBar getCommonTitleBar() {
        return commonTitleBar;
    }

    /**
     * 设置标题
     * @param title
     */
    public void setCommonTitle(String title) {
        getCommonTitleBar().setCommonTitle(title);
    }


    /**
     * 设置背景
     * @param resId
     */
    public void setBackgroundResource(int resId) {
        getCommonTitleBar().setBackgroundResource(resId);
    }

    /**
     * 设置操作
     * @param function
     */
    public void setRightFunction0(String function) {
        getCommonTitleBar().setRightFunction0(function);
    }

    /**
     * 设置图标
     * @param resId
     */
    public void setImage0(int resId) {
        getCommonTitleBar().setImage0(resId);
    }

    /**
     * 设置图标
     * @param resId
     */
    public void setImage1(int resId) {
        getCommonTitleBar().setImage1(resId);
    }

    /**
     * 操作带图标
     * @param resId
     */
    public void setRightFunction0DrawableLeft(int resId) {
        getCommonTitleBar().setRightFunction0DrawableLeft(resId);
    }

    /**
     * 设置标题栏 padding
     */
    public void setTitleBarPadding() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            ViewGroup.LayoutParams layoutParams = getCommonTitleBar().getLayoutParams();
            layoutParams.height = AppUtils.dp2px(mContext, 50) + StatusBarTools.getStatusBarHeight(mContext);
            getCommonTitleBar().setLayoutParams(layoutParams);
            getCommonTitleBar().setPadding(0, StatusBarTools.getStatusBarHeight(mContext), 0, 0);
        }
    }

    /**
     * 透明状态栏
     */
    public void transparentSystemBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(Color.TRANSPARENT);// SDK21
            }
            SystemBarTintManager tintManager = new SystemBarTintManager(this);
            tintManager.setStatusBarTintColor(Color.TRANSPARENT);
            tintManager.setStatusBarTintEnabled(true);
        }
    }

    /**
     * activity 右上角点击
     */
    protected void onFunction0Click() {

    }

    /**
     * activity 标题点击
     */
    protected void onTitleClick() {

    }

    /**
     * activity 右1图标点击
     */
    protected void onImage0Click() {

    }

    /**
     * activity 右2图标点击
     */
    protected void onImage1Click() {

    }

    /**
     * 页面左上角 点击
     */
    protected void onBackClick() {
        finish();
    }

    /**
     * toast 工具
     * @param toast
     */
    public void toast(String toast){
        Toast.makeText(mContext, toast, Toast.LENGTH_SHORT).show();
    }

    protected void showLoading(String msg) {
        loadingDialog = new ProgressDialog(mContext);
        loadingDialog.setMessage(msg);
        loadingDialog.setCanceledOnTouchOutside(true);
        loadingDialog.setCancelable(true);
        loadingDialog.show();
    }

    protected void hiddenLoading() {
        if (loadingDialog != null) {
            loadingDialog.dismiss();
        }
    }
}
