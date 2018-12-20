package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/6.
 */
public class ZN_Zw_xq_Activity extends BaseActivity {


    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.Zw_title)
    TextView ZwTitle;
    @BindView(R.id.relativeLayout)
    RelativeLayout relativeLayout;
    @BindView(R.id.textView2)
    TextView textView2;
    @BindView(R.id.ZW_JS_H)
    TextView ZWJSH;
    @BindView(R.id.ZW_JS_Y)
    TextView ZWJSY;
    @BindView(R.id.PZ_DT)
    LinearLayout PZDT;

    @Override
    protected int getLayoutId() {
        return R.layout.zw_xq_activity;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        String Extra = intent.getStringExtra("title");
        Log.e("智能作文标题", Extra);
        ZwTitle.setText(Extra);

    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick({R.id.back_jt, R.id.PZ_DT})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_jt:
                App.activity.onBackPressed();
                break;
            case R.id.PZ_DT:
                break;
        }
    }
}
