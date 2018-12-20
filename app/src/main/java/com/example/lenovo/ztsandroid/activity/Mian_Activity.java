package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.FragmentManager;
import android.view.View;
import android.widget.FrameLayout;
import android.widget.LinearLayout;
import android.widget.RadioButton;
import android.widget.RadioGroup;
import android.widget.Toast;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.fragment.myself.Myself_fragment;
import com.example.lenovo.ztsandroid.fragment.study.Study_fragment;
import com.example.lenovo.ztsandroid.fragment.task.Task_bj_Fragment;
import com.example.lenovo.ztsandroid.fragment.task.Task_fragment;
import com.example.lenovo.ztsandroid.utils.ConfigFragment;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.example.lenovo.ztsandroid.utils.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/10/26.
 */

public class Mian_Activity extends BaseActivity {


    @BindView(R.id.FrameLayout)
    android.widget.FrameLayout FrameLayout;
    @BindView(R.id.btn_Study)
    RadioButton btnStudy;
    @BindView(R.id.btn_task)
    RadioButton btnTask;
    @BindView(R.id.btn_Myself)
    RadioButton btnMyself;
    @BindView(R.id.FrameLayout_contentGroup)
    RadioGroup FrameLayoutContentGroup;
    @BindView(R.id.activity_main)
    LinearLayout activityMain;
    private FragmentManager fragmentmanager;
    private String stuid;
   private Study_fragment study_fragment;
    private Bundle bundle;
    private SharedPreferences preferences;
    @Override
    protected int getLayoutId() {
        return R.layout.activity_zhuyemian;
    }

    @Override
    protected void initView() {



        fragmentmanager = getSupportFragmentManager();

        preferences = getSharedPreferences("data",1);
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {
        ConfigFragment.getInstance().init().start(Study_fragment.class).build();
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    private int mBackKeyPressedTimes = 0;

    // 按下Back按钮自动触发此函数
    @Override
    public void onBackPressed() {

        // 判断Back按键次数
        if (mBackKeyPressedTimes == 0) {
            Toast.makeText(this, "再按一次退出程序 ", Toast.LENGTH_SHORT).show();
            mBackKeyPressedTimes = 1; // 修改变量为Back按下一次
            // 开启一个新的线程
            new Thread() {
                @Override
                public void run() {
                    try {
                        // 线程暂停2秒钟
                        Thread.sleep(2000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    } finally {
                        // 线程结束后修改变量为0
                        mBackKeyPressedTimes = 0;
                    }
                }
            }.start();
            return;
        } else {
            // Back按键次数为2次时就关闭当前Activity，调用finish()方法实现
            this.finish();
        }
        super.onBackPressed();


        FragmentManager.BackStackEntry entryAt = fragmentmanager.getBackStackEntryAt(fragmentmanager.getBackStackEntryCount() - 1);
        //得到每一个位于栈顶的类的名字，然后执行Finish方法进行弹栈
        String name = entryAt.getName();
        if ("Study_fragment".equals(name) ||
                "Task_fragment".equals(name) ||
                "Myself_fragment".equals(name)
                ) {
//           finish();
            Process.killProcess(Process.myPid());
            System.exit(0);
        } else {
            if (fragmentmanager.getBackStackEntryCount() > 1) {
                fragmentmanager.popBackStackImmediate();//执行弹栈，立马执行
                //否则记录得到位于栈顶的类名字
                String simpleName = fragmentmanager.getBackStackEntryAt(fragmentmanager.getBackStackEntryCount() - 1).getName();
                //记录做标记，标记为上一个Fragment,点击back键刷新lastFragment
                App.lastFragment = (BaseFragment) fragmentmanager.findFragmentByTag(simpleName);
            }
        }
    }

    //执行完毕退出
    @Override
    protected void onDestroy() {
        super.onDestroy();
        Process.killProcess(Process.myPid());//获取pid
        System.exit(0);
//        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);

        super.onDestroy();
    }


    @OnClick({R.id.btn_Study, R.id.btn_task, R.id.btn_Myself})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_Study:
                initView();
                ConfigFragment.getInstance().init().start(Study_fragment.class).build();
                break;
            case R.id.btn_task:
                initView();

                String uid = preferences.getString("ZT", "");

                if (uid.isEmpty()){
                    ConfigFragment.getInstance().init().start(Task_fragment.class).build();
                }else {
                    ConfigFragment.getInstance().init().start(Task_bj_Fragment.class).build();
                }
                break;
            case R.id.btn_Myself:
                initView();
                ConfigFragment.getInstance().init().start(Myself_fragment.class).build();
                break;
        }
    }
}
