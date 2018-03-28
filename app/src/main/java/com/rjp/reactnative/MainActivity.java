package com.rjp.reactnative;

import android.content.Intent;
import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.widget.TextView;

import com.rjp.shell.ui.ShellMainActivity;

import butterknife.BindView;
import butterknife.ButterKnife;

public class MainActivity extends AppCompatActivity{
    @BindView(R.id.text)
    TextView tvMsg;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        ButterKnife.bind(this);

        findViewById(R.id.text).setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View v) {
//                ARouter.getInstance().build("/shell/main").navigation();
                startActivity(new Intent(MainActivity.this, ShellMainActivity.class));
                finish();
            }
        });
    }
}
