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
import com.rjp.shell.base.MySharedPreferences;

import butterknife.BindView;

public class RegisterActivity extends BaseActivity {

    @BindView(R2.id.et_register_username)
    EditText etUserName;
    @BindView(R2.id.et_register_pwd)
    EditText etPassword;
    @BindView(R2.id.tv_register)
    TextView tvRegister;

    public static void trendTo(Context context){
        context.startActivity(new Intent(context, RegisterActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_register);
    }

    @Override
    protected void initView() {
        setCommonTitle("注册");

        tvRegister.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
                String name = etUserName.getText().toString().trim();
                String pwd = etPassword.getText().toString().trim();
                if(TextUtils.isEmpty(name) || TextUtils.isEmpty(pwd)){
                    toast("用户名或者密码不能为空");
                }else{
                    toast("仅限内部用户使用");
                }
            }
        });
    }
}
