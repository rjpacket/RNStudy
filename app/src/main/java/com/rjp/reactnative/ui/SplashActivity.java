package com.rjp.reactnative.ui;

import android.content.Context;
import android.content.Intent;
import android.os.Bundle;
import android.os.Handler;
import android.support.v4.app.FragmentActivity;
import android.widget.ImageView;

import com.alibaba.fastjson.JSONObject;
import com.rjp.reactnative.MainActivity;
import com.rjp.reactnative.R;
import com.rjp.shell.bluetooth.BluetoothActivity;
import com.rjp.shell.network.NetFailureCallback;
import com.rjp.shell.network.NetSuccessCallback;
import com.rjp.shell.network.NetUtils;

public class SplashActivity extends FragmentActivity {

    private Context mContext;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_splash);

        ImageView imageView = (ImageView) findViewById(R.id.image_view);
        imageView.setImageResource(R.drawable.wellcome_page);

        mContext = this;

//        getAppInfo();
        skipBluetooth();
    }

    private void skipBluetooth() {
        startActivity(new Intent(this, BluetoothActivity.class));
    }

    private void getAppInfo() {
        String url = "http://www.27305.com/frontApi/getAboutUs?appid=1804011404";
        NetUtils.getInstance().get(mContext, url, new NetSuccessCallback() {
            @Override
            public void onSuccess(String result) {
                JSONObject jsonObject = JSONObject.parseObject(result);
                int isshowwap = jsonObject.getIntValue("isshowwap");
                if (isshowwap == 1) {
                    //加载url
                    final String wapurl = jsonObject.getString("wapurl");
                    new Handler().postDelayed(new Runnable() {
                        @Override
                        public void run() {
                            Intent intent = new Intent(mContext, WebViewActivity.class);
                            intent.putExtra("url", wapurl);
                            startActivity(intent);
                            finish();
                        }
                    }, 2000);
                } else if (isshowwap == 2) {
                    //原生
                    skipLocalMain();
                }
            }
        }, new NetFailureCallback() {
            @Override
            public void onFailure(String errorMsg) {
                skipLocalMain();
            }
        });
    }

    /**
     * 跳转本地的main
     */
    private void skipLocalMain() {
        new Handler().postDelayed(new Runnable() {
            @Override
            public void run() {
                MainActivity.trendTo(mContext);
                finish();
            }
        }, 2000);
    }
}
