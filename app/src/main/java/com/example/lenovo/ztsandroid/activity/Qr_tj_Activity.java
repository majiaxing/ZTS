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
 * Created by Administrator on 2018/11/23.
 */
public class Qr_tj_Activity extends BaseActivity {


    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.Dq_Nj)
    TextView DqNj;
    @BindView(R.id.YXq_date)
    TextView YXqDate;
    @BindView(R.id.Que_R)
    Button QueR;

    @Override
    protected int getLayoutId() {
        return R.layout.qr_tj_activity;
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

    @OnClick({R.id.back_jt, R.id.Que_R})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_jt:
                App.activity.onBackPressed();
                break;
            case R.id.Que_R:
                Intent intent = new Intent(App.activity,JiaR_BanJ_Activity.class);
                startActivity(intent);
                finish();
                break;
        }
    }
}
