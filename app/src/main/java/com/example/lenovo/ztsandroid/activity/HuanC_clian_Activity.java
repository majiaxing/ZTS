package com.example.lenovo.ztsandroid.activity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseActivity;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/23.
 */
public class HuanC_clian_Activity extends BaseActivity {


    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.Title)
    TextView Title;
    @BindView(R.id.Q_L_btn)
    Button QLBtn;
    @BindView(R.id.Sbh)
    LinearLayout Sbh;

    @Override
    protected int getLayoutId() {
        return R.layout.huanc_q_activity;
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

    @OnClick({R.id.back_jt, R.id.Q_L_btn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_jt:
                break;
            case R.id.Q_L_btn:
                break;
        }
    }
}
