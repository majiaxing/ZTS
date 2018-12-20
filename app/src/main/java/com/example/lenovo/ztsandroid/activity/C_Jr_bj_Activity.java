package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
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
public class C_Jr_bj_Activity extends BaseActivity {
    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.Jiar_bj)
    TextView JiarBj;

    private SharedPreferences preferences;
    private SharedPreferences.Editor editor;

    @Override
    protected int getLayoutId() {
        return R.layout.cg_jiar_bj_activity;
    }

    @Override
    protected void initView() {

        preferences = getSharedPreferences("data",1);
        editor = preferences.edit();

        editor.putString("ZT","5");
        editor.commit();




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

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        Intent intent = new Intent(App.activity,Mian_Activity.class);
        startActivity(intent);
        finish();
    }

    @OnClick(R.id.back_jt)
    public void onViewClicked() {
        Intent intent = new Intent(App.activity,Mian_Activity.class);
        startActivity(intent);
        finish();
    }

}
