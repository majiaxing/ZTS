package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/10/31.
 */
public class E_Ka_X_Activity extends BaseActivity {


    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.sj_btn)
    Button sjBtn;
    @BindView(R.id.ChanPJS)
    TextView ChanPJS;

    @Override
    protected int getLayoutId() {
        return R.layout.e_ka_xq;
    }

    @Override
    protected void initView() {

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

    @OnClick({R.id.back_jt, R.id.sj_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_jt:
                App.activity.onBackPressed();
                break;
            case R.id.sj_btn:
                Intent intent = new Intent(App.activity, Qrdd_Activity.class);
                App.activity.startActivity(intent);
                break;
        }
    }

}
