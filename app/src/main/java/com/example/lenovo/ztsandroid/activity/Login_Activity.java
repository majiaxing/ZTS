package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.text.TextUtils;
import android.view.View;
import android.widget.Button;
import android.widget.EditText;
import android.widget.TextView;
import android.widget.Toast;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.Logincotract;
import com.example.lenovo.ztsandroid.model.entity.LoginBean;
import com.example.lenovo.ztsandroid.presenter.Login_Presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.example.lenovo.ztsandroid.utils.YZ_Utils;
import com.example.lenovo.ztsandroid.view.CircleImageView;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/10/29.
 */

public class Login_Activity extends BaseActivity implements Logincotract.View{

    @BindView(R.id.A_Image_TX)
    CircleImageView AImageTX;
    @BindView(R.id.A_edit_one)
    EditText AEditOne;
    @BindView(R.id.A_edit_two)
    EditText AEditTwo;
    @BindView(R.id.A_wangjiBtn)
    TextView AWangjiBtn;
    @BindView(R.id.loginBtn)
    Button loginBtn;

    private String UreName;
    private String PassWord;
    private Logincotract.Presenter presenter;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;

    @Override
    protected int getLayoutId() {
        return R.layout.login_activity;
    }

    @Override
    protected void initView() {
        sp = this.getSharedPreferences("userInfo", App.activity.MODE_PRIVATE);
        editor = sp.edit();

        App.stuid = sp.getString("stuid", "");

        if (App.stuid != ""){
            Intent intent = new Intent(App.activity,Mian_Activity.class);
//            intent.putExtra("stuid",stuid);
            startActivity(intent);
            finish();
        }

    }

    @Override
    public void initData() {
    }
    @Override
    public void loadData() {
        new Login_Presenter(this);
    }

    @OnClick({R.id.A_wangjiBtn, R.id.loginBtn})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.A_wangjiBtn:
                Intent intent = new Intent(this,WJ_Activity.class);
                startActivity(intent);
                break;
            case R.id.loginBtn:

                UreName = AEditOne.getText().toString().trim();
                PassWord = AEditTwo.getText().toString().trim();
                boolean result = YZ_Utils.isPhone(UreName);
                if (TextUtils.isEmpty(UreName)||TextUtils.isEmpty(PassWord)) {
                    Toast.makeText(this, "请输入手机号和密码", Toast.LENGTH_SHORT).show();
                    return;
                }else {
                    presenter.SetUrl(UreName, PassWord);
                }
                break;
        }
    }

    @Override
    public void getManager(LoginBean loginBean) {
        MyLog.e("TAG", loginBean.getMessage());

        if (loginBean.getMessage().equals("登录成功")){
            App.activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(App.activity,"登录成功",Toast.LENGTH_SHORT).show();
                }
            });
//
           int stuid = loginBean.getData().get(0).getStuid();
            App.stuid = String.valueOf(stuid);
            MyLog.e("stuid",App.stuid +"");
            Intent intent = new Intent(App.activity,Mian_Activity.class);
            startActivity(intent);
            finish();
            editor.putString("stuid", App.stuid);
            editor.commit();

        }else if (loginBean.getMessage().equals("密码输入错误")){

            App.activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(App.activity,"密码输入错误",Toast.LENGTH_SHORT).show();
                }
            });
        }else if (loginBean.getMessage().equals("用户名不存在")){

            App.activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
                    Toast.makeText(App.activity,"用户名不存在",Toast.LENGTH_SHORT).show();
                }
            });
        }

    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(Logincotract.Presenter presenter) {
        this.presenter = presenter;
    }
}
