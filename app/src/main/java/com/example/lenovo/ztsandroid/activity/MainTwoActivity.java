package com.example.lenovo.ztsandroid.activity;

import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.Button;
import android.widget.FrameLayout;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.fragment.CSFragment;
import com.example.lenovo.ztsandroid.fragment.CSTwofragment;
import com.example.lenovo.ztsandroid.utils.ConfigFragment;

/**
 * Created by Lenovo on 2018/10/24.
 */

public class MainTwoActivity extends BaseActivity {

    private Button btnOne,btnTwo;
    private FrameLayout Framelayout;
    private FragmentManager fragmentmanager;

    @Override
    protected int getLayoutId() {
        return R.layout.activity_main;
    }

    @Override
    protected void initView() {
        btnOne = (Button) findViewById(R.id.btnOne);
        btnTwo = (Button) findViewById(R.id.btnTwo);
        Framelayout = (FrameLayout) findViewById(R.id.FrameLayout);
    }

    @Override
    public void initData() {
        btnOne.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentmanager= getSupportFragmentManager();
                ConfigFragment.getInstance().init().start(CSFragment.class).build();
            }
        });
        btnTwo.setOnClickListener(new View.OnClickListener() {
            @Override
            public void onClick(View view) {
                fragmentmanager= getSupportFragmentManager();
                ConfigFragment.getInstance().init().start(CSTwofragment.class).build();
            }
        });
    }

    @Override
    public void loadData() {
        ConfigFragment.getInstance().init().start(CSFragment.class).build();

    }
}
