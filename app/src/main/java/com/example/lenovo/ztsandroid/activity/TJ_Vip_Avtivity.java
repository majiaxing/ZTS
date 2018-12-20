package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.TiJ_Vip_Cotract;
import com.example.lenovo.ztsandroid.model.entity.TiJ_Vip_Bean;
import com.example.lenovo.ztsandroid.presenter.TiJ_Vip_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/10/31.
 */
public class TJ_Vip_Avtivity extends BaseActivity implements TiJ_Vip_Cotract.View{
    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.Use_name)
    EditText UseName;
    @BindView(R.id.Pas_ward)
    EditText PasWard;
    @BindView(R.id.T_jiao)
    Button TJiao;
    private TiJ_Vip_Cotract.Presenter presenter;
    @Override
    protected int getLayoutId() {
        return R.layout.tj_vip_activity;
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

    @OnClick({R.id.back_jt, R.id.T_jiao})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_jt:
                App.activity.onBackPressed();
                break;
            case R.id.T_jiao:

                if (UseName.getText().toString().isEmpty()||PasWard.getText().toString().isEmpty()) {
                    Toast.makeText(App.activity,"卡号密码不能为空",Toast.LENGTH_SHORT).show();
                }else {
                    presenter = new TiJ_Vip_Presenter(this);
                    presenter.SetUrl(App.stuid,UseName.getText().toString(),PasWard.getText().toString());
                }
                break;
        }
    }

    @Override
    public void getManager(TiJ_Vip_Bean xqbean) {

        final String flag = xqbean.getData().getFlag();

        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(App.activity,flag,Toast.LENGTH_SHORT).show();
            }
        });
        Intent intent = new Intent(App.activity,Qr_tj_Activity.class);
        startActivity(intent);
    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(TiJ_Vip_Cotract.Presenter presenter) {

    }
}
