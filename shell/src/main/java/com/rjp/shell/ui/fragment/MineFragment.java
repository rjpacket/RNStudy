package com.rjp.shell.ui.fragment;


import android.app.ProgressDialog;
import android.os.Handler;
import android.os.Message;
import android.support.v4.app.Fragment;
import android.view.View;
import android.widget.TextView;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseFragment;
import com.rjp.shell.ui.activity.AboutActivity;
import com.rjp.shell.ui.activity.EmptyActivity;
import com.rjp.shell.ui.activity.LoginActivity;
import com.rjp.shell.ui.activity.SaveNewsActivity;

import java.util.Random;

import butterknife.BindView;
import butterknife.OnClick;


/**
 * A simple {@link Fragment} subclass.
 */
public class MineFragment extends BaseFragment {
    @BindView(R2.id.tv_user_name)
    TextView tvUserName;
    private ProgressDialog loadingDialog;

    private boolean isClear = false;

    public MineFragment() {
        // Required empty public constructor
    }

    public static MineFragment getInstance(){
        return new MineFragment();
    }

    public static MineFragment getInstance(String tag){
        MineFragment homeNewsFragment = new MineFragment();
        return homeNewsFragment;
    }

    @Override
    public int getChildViewLayoutId() {
        return R.layout.fragment_mine;
    }

    @Override
    public void initView() {

    }

    @Override
    public void reload() {

    }

    @OnClick({R2.id.tv_user_name, R2.id.setting_update, R2.id.setting_about,R2.id.setting_my_save_order,
            R2.id.setting_clear, R2.id.setting_my_notice, R2.id.setting_system_message})
    @Override
    public void onClick(View v) {
        int id = v.getId();
        if(id == R.id.tv_user_name){
            LoginActivity.trendTo(mContext);
        }else if(id == R.id.setting_update){
            toast("已经是最新版本了");
        }else if(id == R.id.setting_about){
            AboutActivity.trendTo(mContext);
        }else if(id == R.id.setting_clear){
            showDialog();
        }else if(id == R.id.setting_my_notice){
            EmptyActivity.trendTo(mContext, "我的通知");
        }else if(id == R.id.setting_system_message){
            EmptyActivity.trendTo(mContext, "系统信息");
        }else if(id == R.id.setting_my_save_order){
            SaveNewsActivity.trendTo(mContext);
        }
    }

    private Handler handler = new Handler(){
            @Override
            public void handleMessage(Message msg) {
                switch (msg.what){
                    case 0:
                        if(isClear) {
                            toast("没有缓存可以清除呢~");
                        }else{
                            double size = (new Random().nextDouble() * 20);
                            toast("清除了" + size + "M 缓存");
                            isClear = true;
                        }
                        loadingDialog.dismiss();
                        break;
                }
            }
        };

    private void showDialog() {
        loadingDialog = new ProgressDialog(mContext);
        loadingDialog.setMessage("正在清除缓存...");
        loadingDialog.setCanceledOnTouchOutside(false);
        loadingDialog.setCancelable(false);
        loadingDialog.show();
        handler.sendEmptyMessageDelayed(0, 2000);
    }
}
