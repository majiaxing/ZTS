package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.config.ActivityManager;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/23.
 */
public class SheZ_Activity extends BaseActivity {


    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.Title)
    TextView Title;
    @BindView(R.id.textView4)
    TextView textView4;
    @BindView(R.id.XiuG_password)
    LinearLayout XiuGPassword;
    @BindView(R.id.Chang_Yong_Sb)
    LinearLayout ChangYongSb;
    @BindView(R.id.HuanC_gl)
    LinearLayout HuanCGl;
    @BindView(R.id.JC_Gx)
    LinearLayout JCGx;
    @BindView(R.id.Gy_mine)
    LinearLayout GyMine;
    @BindView(R.id.TuiC_login)
    TextView TuiCLogin;
    private SharedPreferences sp;
    private SharedPreferences.Editor editor;
    @Override
    protected int getLayoutId() {
        return R.layout.shezhi_activity;
    }

    @Override
    protected void initView() {

        sp = this.getSharedPreferences("userInfo", App.activity.MODE_WORLD_READABLE);
//        sp = getSharedPreferences("data",1);
        editor = sp.edit();



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


    @OnClick({R.id.back_jt, R.id.XiuG_password, R.id.Chang_Yong_Sb, R.id.HuanC_gl, R.id.JC_Gx, R.id.Gy_mine, R.id.TuiC_login})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_jt:
                App.activity.onBackPressed();
                break;
            case R.id.XiuG_password:
//                修改密码
                Intent intent = new Intent(App.activity,XiuG_Password_Activity.class);
                startActivity(intent);
                break;
            case R.id.Chang_Yong_Sb:
//                常用设备
                Intent intent1 = new Intent(App.activity,ChY_SB_Activity.class);
                startActivity(intent1);
                break;
            case R.id.HuanC_gl:
//                清理缓存
                Intent intent2 = new Intent(App.activity,HuanC_clian_Activity.class);
                startActivity(intent2);
                break;
            case R.id.JC_Gx:
                break;
            case R.id.Gy_mine:
                break;
            case R.id.TuiC_login:
//                退出登录
                editor.clear();
                editor.commit();
                Intent intent3 = new Intent(App.activity,Login_Activity.class);
                startActivity(intent3);
                ActivityManager.getInstance().exit();
                break;
        }
    }
}
