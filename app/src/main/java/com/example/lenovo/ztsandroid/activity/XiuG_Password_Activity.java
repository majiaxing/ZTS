package com.example.lenovo.ztsandroid.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.Toast;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.XiuG_password_Cotract;
import com.example.lenovo.ztsandroid.model.entity.XiuG_Bean;
import com.example.lenovo.ztsandroid.presenter.XiuG_password_Presenter;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/23.
 */
public class XiuG_Password_Activity extends BaseActivity implements XiuG_password_Cotract.View{


    @BindView(R.id.Back)
    ImageView Back;
    @BindView(R.id.YHM_)
    EditText YHM;
    @BindView(R.id.SJH_)
    EditText SJH;
    @BindView(R.id.YZM_)
    EditText YZM;
    @BindView(R.id.ZC_Sr_password)
    EditText ZCSrPassword;
    @BindView(R.id.CZ_)
    Button CZ;
    private String shouji;
    private String yanzhengma;
    private Boolean rult;

    private XiuG_password_Cotract.Presenter presenter;
    private String yhm;
    private String sjh;
    private String o_password;
    private String t_password;

    @Override
    protected int getLayoutId() {
        return R.layout.xiugai_activity;
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



    @OnClick({R.id.Back, R.id.CZ_})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.Back:
                App.activity.onBackPressed();
                break;
            case R.id.CZ_:

                yhm = YHM.getText().toString().trim();
                sjh = SJH.getText().toString().trim();
                o_password = YZM.getText().toString().trim();
                t_password = ZCSrPassword.getText().toString().trim();


                if (TextUtils.isEmpty(yhm)){
                    Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    return;
                }
                if (TextUtils.isEmpty(sjh)){
                    Toast.makeText(this, "请输入密码", Toast.LENGTH_SHORT).show();
                    return;
                }

                if (TextUtils.isEmpty(o_password)){
                    Toast.makeText(App.activity,"请输入新密码",Toast.LENGTH_SHORT).show();
                    return;
                }

                 if (TextUtils.isEmpty(t_password)){
                                    Toast.makeText(App.activity,"请再次输入密码",Toast.LENGTH_SHORT).show();
                                    return;
                                }


                if (o_password.equals(t_password)){
                    presenter = new XiuG_password_Presenter(this);
                    presenter.setUrl(App.stuid,yhm,sjh,o_password);
                }else {
                    Toast.makeText(App.activity,"新密码请输入一致",Toast.LENGTH_SHORT).show();
                }


                break;
        }
    }
//    修改密码成功的回调
    @Override
    public void getManager(XiuG_Bean s) {

        App.activity.finish();
        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast.makeText(App.activity,"修改成功",Toast.LENGTH_SHORT).show();
            }
        });


    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(XiuG_password_Cotract.Presenter presenter) {

    }
}
