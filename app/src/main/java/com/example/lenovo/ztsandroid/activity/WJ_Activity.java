package com.example.lenovo.ztsandroid.activity;

import android.os.Bundle;
import android.text.TextUtils;
import android.view.Gravity;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.Toast;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.WangJ_Cotract;
import com.example.lenovo.ztsandroid.model.entity.WangJ_Bean;
import com.example.lenovo.ztsandroid.model.entity.XiuG_CG_Bean;
import com.example.lenovo.ztsandroid.presenter.WangJ_Password_Presenter;
import com.example.lenovo.ztsandroid.presenter.WangJ_Presenter;
import com.example.lenovo.ztsandroid.utils.CountDownButton;
import com.example.lenovo.ztsandroid.utils.YZ_Utils;

import java.util.Timer;
import java.util.TimerTask;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/10/29.
 */
public class WJ_Activity extends BaseActivity implements WangJ_Cotract.View{
    @BindView(R.id.back_jt)
    LinearLayout back_jt;
    @BindView(R.id.SJH_)
    EditText SJH;
    @BindView(R.id.YZM_)
    EditText YZM;
    @BindView(R.id.HQ_)
    CountDownButton HQ;
    @BindView(R.id.CZ_)
    Button CZ;
    @BindView(R.id.YHM_)
    EditText YHM;
    @BindView(R.id.ZC_Sr_password)
    EditText ZCSrPassword;

    private String shouji;
    private String yanzhengma;
    private Boolean rult;
    private WangJ_Cotract.Presenter presenter;
    private String yhm;
    private String password;

    @Override
    protected int getLayoutId() {
        return R.layout.wj_activity;
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

    private Boolean boo = false;
    @OnClick({R.id.back_jt, R.id.HQ_, R.id.CZ_})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_jt:
                App.activity.onBackPressed();
                break;
            case R.id.HQ_:

                if (boo){
                   Timer timer = new Timer();
                                 timer.schedule(new TimerTask() {
                                  @Override
                               public void run() {
                                            //do something\
                                      boo = false;
                                        }
                             },1000*60);//延时1s执行
                    Toast toast = Toast.makeText(App.activity, "正在获取验证码", Toast.LENGTH_LONG);
                        toast.setGravity(Gravity.CENTER,0,0);
                        toast.show();
                }else {

                    shouji = SJH.getText().toString().trim();
                    if (TextUtils.isEmpty(shouji)) {
//                    Toast.makeText(this, "请输入手机号", Toast.LENGTH_SHORT).show();
                        Toast toast = Toast.makeText(App.activity, "请输入手机号", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();

                        return;
                    }

                    rult = YZ_Utils.isPhone(shouji);
                    if (rult == false) {
//                    Toast.makeText(this, "请输入正确的手机号", Toast.LENGTH_SHORT).show();

                        Toast toast = Toast.makeText(App.activity, "请输入正确的手机号", Toast.LENGTH_SHORT);
                        toast.setGravity(Gravity.CENTER, 0, 0);
                        toast.show();

                        return;
                    }

                    presenter = new WangJ_Presenter(this);
                    presenter.setUrl(shouji, "2");
                    boo = true;
                }


                break;
            case R.id.CZ_:
                shouji = SJH.getText().toString().trim();
                yanzhengma = YZM.getText().toString().trim();
                yhm = YHM.getText().toString().trim();
                password = ZCSrPassword.getText().toString().trim();
                if (TextUtils.isEmpty(yhm)){
//                    Toast.makeText(this, "请输入用户名", Toast.LENGTH_SHORT).show();
                    Toast toast = Toast.makeText(App.activity, "请输入用户名", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                    return;
                }
                if (TextUtils.isEmpty(shouji) &&TextUtils.isEmpty(yanzhengma)) {
//                    Toast.makeText(this, "请输入手机号和验证码", Toast.LENGTH_SHORT).show();

                    Toast toast = Toast.makeText(App.activity, "请输入手机号和验证码", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();


                    return;
                }

                if (TextUtils.isEmpty(password)){
                    Toast.makeText(this, "请新的密码", Toast.LENGTH_SHORT).show();
                    Toast toast = Toast.makeText(App.activity, "请输入新的密码", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                    return;
                }

//                rult = YZ_Utils.isPhone(shouji);
//                Boolean yanz = YZ_Utils.isYanzheng(yanzhengma);
//                if (rult == false || yanz == false) {
//                    Toast.makeText(this, "请输入正确的手机号和验证码", Toast.LENGTH_SHORT).show();
//                } else {
                    presenter = new WangJ_Password_Presenter(this);
                    presenter.setUrls("5",yhm,password,yanzhengma,shouji);
//                }
                break;
        }
    }

    @Override
    public void getManager(WangJ_Bean wangJBean) {

        if (wangJBean.getData().getMsg0().equals("发送成功")){
            //这里判断是否倒计时结束，避免在倒计时时多次点击导致重复请求接口
            if (HQ.isFinish()) {
                //发送验证码请求成功后调用
                HQ.start();
            }
        }

    }

    @Override
    public void getManagerO(final XiuG_CG_Bean string) {

        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                if (string.getMessage().equals("")){
                    App.activity.finish();
//                    Toast.makeText(App.activity, string.getData().getSmg0(),Toast.LENGTH_SHORT).show();

                    Toast toast = Toast.makeText(App.activity, string.getData().getSmg0(), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();


                }else if (string.getMessage().equals("验证码不存在")){
//                    Toast.makeText(App.activity, string.getMessage(),Toast.LENGTH_SHORT).show();

                    Toast toast = Toast.makeText(App.activity,string.getMessage(), Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                }
            }
        });






    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(WangJ_Cotract.Presenter presenter) {

    }
}
