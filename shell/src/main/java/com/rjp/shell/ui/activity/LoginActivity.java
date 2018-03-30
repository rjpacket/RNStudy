package com.rjp.shell.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.EditText;
import android.widget.TextView;

import com.rjp.shell.R;
import com.rjp.shell.R2;
import com.rjp.shell.base.BaseActivity;

import butterknife.BindView;

public class LoginActivity extends BaseActivity {

    @BindView(R2.id.et_login_username)
    EditText etUserName;
    @BindView(R2.id.et_login_pwd)
    EditText etPassword;
    @BindView(R2.id.tv_login)
    TextView tvLogin;

    public static void trendTo(Context context){
        context.startActivity(new Intent(context, LoginActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_login);
    }

    @Override
    protected void initView() {
        setCommonTitle("登录");
        setRightFunction0("注册");

        tvLogin.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etUserName.getText().toString().trim();
                String pwd = etPassword.getText().toString().trim();
                if(TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)){
                    toast("用户名或者密码不能为空");
                }else{
                    toast("用户名或者密码错误");
                }
            }
        });
    }

    @Override
    protected void onFunction0Click() {
        RegisterActivity.trendTo(mContext);
    }
}
