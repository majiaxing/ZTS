package com.example.lenovo.ztsandroid.activity;

import android.content.Context;
import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Process;
import android.text.TextUtils;
import android.util.Log;
import android.view.Gravity;
import android.view.MotionEvent;
import android.view.View;
import android.view.inputmethod.InputMethodManager;
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
import com.tencent.android.tpush.XGIOperateCallback;
import com.tencent.android.tpush.XGPushManager;

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

//        AEditOne.setFocusable(false);
//        AEditTwo.setFocusable(false);
//        隐藏 光标
        AEditOne.setFocusable(true);
        AEditOne.setFocusableInTouchMode(true);
        AEditOne.requestFocus();

//        隐藏 光标
        AEditTwo.setFocusable(true);
        AEditTwo.setFocusableInTouchMode(true);
        AEditTwo.requestFocus();


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

//    监听 屏幕  强制隐藏键盘
    @Override
    public boolean dispatchTouchEvent(MotionEvent ev) {
        if (ev.getAction() == MotionEvent.ACTION_DOWN) {
            View v = getCurrentFocus();
            if (isShouldHideInput(v, ev)) {

                InputMethodManager imm = (InputMethodManager) getSystemService(Context.INPUT_METHOD_SERVICE);
                if (imm != null) {

                    imm.hideSoftInputFromWindow(v.getWindowToken(), 0); //强制隐藏键盘
                }
            }
            return super.dispatchTouchEvent(ev);
        }
        // 必不可少，否则所有的组件都不会有TouchEvent了
        if (getWindow().superDispatchTouchEvent(ev)) {
            return true;
        }
        return onTouchEvent(ev);
    }
    public  boolean isShouldHideInput(View v, MotionEvent event) {
        if (v != null && (v instanceof EditText)) {
            int[] leftTop = { 0, 0 };
            //获取输入框当前的location位置
            v.getLocationInWindow(leftTop);
            int left = leftTop[0];
            int top = leftTop[1];
            int bottom = top + v.getHeight();
            int right = left + v.getWidth();
            if (event.getX() > left && event.getX() < right
                    && event.getY() > top && event.getY() < bottom) {
                // 点击的是输入框区域，保留点击EditText的事件
                return false;
            } else {
                return true;
            }
        }
        return false;
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
                //忘记密码按钮
                Intent intent = new Intent(this,WJ_Activity.class);
                startActivity(intent);
                break;
            case R.id.loginBtn:
                //登录按钮
                UreName = AEditOne.getText().toString().trim();
                PassWord = AEditTwo.getText().toString().trim();
                boolean result = YZ_Utils.isPhone(UreName);
                if (TextUtils.isEmpty(UreName)||TextUtils.isEmpty(PassWord)) {
//                    Toast.makeText(this, "请输入手机号和密码", Toast.LENGTH_SHORT).show();

                    Toast toast = Toast.makeText(App.activity, "请输入手机号和密码", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

                    return;
                }else {
                    presenter.SetUrl(UreName, PassWord,"5");
                }
                break;
        }
    }

    @Override
    public void getManager(final LoginBean loginBean) {

        MyLog.e("TAG", loginBean.getMessage());
        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                Toast toast = Toast.makeText(App.activity, loginBean.getMessage(), Toast.LENGTH_SHORT);
                toast.setGravity(Gravity.CENTER,0,0);
                toast.show();
            }
        });

        if (loginBean.getMessage().equals("登录成功")){

            XGPushManager.setTag(getApplicationContext(),"Student");
            String user_banji_d = loginBean.getData().getUser().getUser_banji_d();
            if ( user_banji_d !=(null)){
                String[] split = user_banji_d.split(",");
                for (int i = 0; i < split.length ; i++) {
                    String s = split[i];
                    XGPushManager.setTag(this,s);
                }
//                XGPushManager.bindAccount(this,"5#"+loginBean.getData().getId());
            }

            App.activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
//                    Toast.makeText(App.activity,"登录成功",Toast.LENGTH_SHORT).show();
                    Toast toast = Toast.makeText(App.activity, "登录成功", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();
                }
            });
           int stuid = loginBean.getData().getId();
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
//                    Toast.makeText(App.activity,"密码输入错误",Toast.LENGTH_SHORT).show();
                    Toast toast = Toast.makeText(App.activity, "密码输入错误", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();


                }
            });
        }else if (loginBean.getMessage().equals("用户名不存在")){

            App.activity.runOnUiThread(new Runnable() {
                @Override
                public void run() {
//                    Toast.makeText(App.activity,"用户名不存在",Toast.LENGTH_SHORT).show();

                    Toast toast = Toast.makeText(App.activity, "用户名不存在", Toast.LENGTH_SHORT);
                    toast.setGravity(Gravity.CENTER, 0, 0);
                    toast.show();

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

    @Override
    public void onBackPressed() {
        super.onBackPressed();

        Process.killProcess(Process.myPid());
//        System.exit(0);
    }
}
