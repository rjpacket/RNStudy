package com.rjp.shell.ui;

import android.content.Context;
import android.graphics.Color;
import android.os.Build;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.app.FragmentActivity;
import android.view.WindowManager;
import android.widget.FrameLayout;

import com.alibaba.android.arouter.facade.annotation.Route;
import com.rjp.navigationview.NavigationView;
import com.rjp.navigationview.TabModel;
import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.dialog.NoticeDialog;
import com.rjp.shell.dialog.NoticeDialogUtils;
import com.rjp.shell.ui.fragment.MineFragment;
import com.rjp.shell.ui.fragment.OpenPrizeFragment;
import com.rjp.shell.ui.fragment.RecommendFragment;
import com.rjp.shell.ui.fragment.TrendFragment;
import com.rjp.shell.ui.fragment.WYNewsFragment;
import com.rjp.shell.utils.SystemBarTintManager;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

@Route(path = "/shell/main")
public class ShellMainActivity extends FragmentActivity {

    @BindView(R2.id.shell_fragment_container)
    FrameLayout fragmentContainer;
    @BindView(R2.id.navigation_view)
    NavigationView navigationView;

    private Context context;
    private NoticeDialog dialog;
    private SystemBarTintManager tintManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_shell_main);

        ButterKnife.bind(this);

        initSystemBar();
        context = this;

        initView();
    }

    private void initView() {
        ArrayList<Fragment> fragments = new ArrayList<>();
        fragments.add(WYNewsFragment.getInstance("ssq"));
        fragments.add(new RecommendFragment());
        fragments.add(new OpenPrizeFragment());
        fragments.add(new TrendFragment());
        fragments.add(new MineFragment());
        navigationView.setFragments(fragments);
        navigationView.setFragmentManager(getSupportFragmentManager());
        navigationView.setContainerId(R.id.shell_fragment_container);
        ArrayList<TabModel> tabModels = new ArrayList<>();
        tabModels.add(new TabModel("首页", R.drawable.selector_home_tab_1));
        tabModels.add(new TabModel("推荐", R.drawable.selector_home_tab_2));
        tabModels.add(new TabModel("开奖", R.drawable.selector_home_tab_3));
        tabModels.add(new TabModel("走势", R.drawable.selector_home_tab_2));
        tabModels.add(new TabModel("我的", R.drawable.selector_home_tab_4));
        navigationView.setTabs(tabModels);
    }

    @Override
    public void onBackPressed() {
        quit();
    }

    /**
     * 退出程序
     *
     * @return
     */
    private void quit() {
        if (dialog == null) {
            initDialog();
        } else {
            dialog.show();
        }
    }

    private void initDialog() {
        dialog = NoticeDialogUtils.notice1(this, "真的要离开吗？", new NoticeDialog.OnNoticeClickListener() {
            @Override
            public void onNoticeClick(NoticeDialog dialog, int which) {
                switch (which){
                    case NoticeDialog.NOTICE_CONFIRM:
                        finish();
                        break;
                }
            }
        });
        dialog.show();
    }

    public void initSystemBar() {
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.KITKAT) {
            getWindow().addFlags(WindowManager.LayoutParams.FLAG_TRANSLUCENT_STATUS);
            if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.LOLLIPOP) {
                getWindow().addFlags(WindowManager.LayoutParams.FLAG_DRAWS_SYSTEM_BAR_BACKGROUNDS);
                getWindow().setStatusBarColor(Color.TRANSPARENT);// SDK21
            }
        }
        tintManager = new SystemBarTintManager(this);// 创建状态栏的管理实例
        tintManager.setStatusBarTintEnabled(true);// 激活状态栏设置
        tintManager.setNavigationBarTintEnabled(true);// 激活导航栏设置
        tintManager.setStatusBarTintColor(Color.TRANSPARENT);//设置状态栏颜色
        tintManager.setStatusBarDarkMode(false, this);//false 状态栏字体颜色是白色 true 颜色是黑色
    }
}
