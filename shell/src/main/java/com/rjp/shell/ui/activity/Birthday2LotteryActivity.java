package com.rjp.shell.ui.activity;

import android.content.Context;
import android.content.Intent;
import android.graphics.Color;
import android.os.Bundle;
import android.view.View;
import android.widget.Toast;

import com.bigkoo.pickerview.builder.TimePickerBuilder;
import com.bigkoo.pickerview.listener.OnTimeSelectListener;
import com.bigkoo.pickerview.view.TimePickerView;
import com.rjp.shell.R;
import com.rjp.shell.base.BaseActivity;

import java.util.Date;

/**
 * 生日选号页面
 */
public class Birthday2LotteryActivity extends BaseActivity {


    public static void trendTo(Context context){
        context.startActivity(new Intent(context, Birthday2LotteryActivity.class));
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_birthday_2_lottery);
    }

    @Override
    protected void initView() {
        setCommonTitle("生日选号");

        TimePickerView pvTime = new TimePickerBuilder(mContext, new OnTimeSelectListener() {
            @Override
            public void onTimeSelect(Date date, View v) {
                Toast.makeText(mContext, date.toString(), Toast.LENGTH_SHORT).show();
            }
        })
                .setSubmitColor(Color.parseColor("#eb1c42"))
                .setCancelColor(Color.parseColor("#eb1c42"))
                .build();
        pvTime.show();
    }
}
