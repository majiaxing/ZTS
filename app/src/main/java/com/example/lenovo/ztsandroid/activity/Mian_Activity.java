package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Process;
import android.support.v4.app.FragmentManager;
import android.view.KeyEvent;
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
import com.example.lenovo.ztsandroid.config.FragmantBuilder;
import com.example.lenovo.ztsandroid.cotract.My_Xinx_Cotract;
import com.example.lenovo.ztsandroid.fragment.myself.Myself_fragment;
import com.example.lenovo.ztsandroid.fragment.study.Study_fragment;
import com.example.lenovo.ztsandroid.fragment.task.Task_bj_Fragment;
import com.example.lenovo.ztsandroid.fragment.task.Task_fragment;
import com.example.lenovo.ztsandroid.model.entity.Student_Xinx_Bean;
import com.example.lenovo.ztsandroid.presenter.My_Xinx_Presenter;
import com.example.lenovo.ztsandroid.utils.ConfigFragment;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.example.lenovo.ztsandroid.utils.StatusBarUtil;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/10/26.
 */

public class Mian_Activity extends BaseActivity implements My_Xinx_Cotract.View{


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
    private My_Xinx_Cotract.Presenter presenter;
    private String classId;

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
        presenter  = new My_Xinx_Presenter(this);
        presenter.seturl(App.stuid);
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
    private long mExitTime;
    public boolean onKeyDown(int keyCode, KeyEvent event) {
        if (keyCode == KeyEvent.KEYCODE_BACK) {

            FragmentManager manager = getSupportFragmentManager();
            FragmentManager.BackStackEntry entry = manager.getBackStackEntryAt(manager.getBackStackEntryCount() - 1);
            String name = entry.getName();
            if ("Study_fragment".equals(name)
                    || "Task_bj_Fragment".equals(name)
                    || "Task_fragment".equals(name)
                    ||"Myself_fragment".equals(name)) {
                //System.exit(0);
                if ((System.currentTimeMillis() - mExitTime) > 2000) {
                    Object mHelperUtils;
                    Toast.makeText(this, "再按一次退出程序", Toast.LENGTH_SHORT).show();
                    mExitTime = System.currentTimeMillis();

                } else {
                    finish();
                }
            } else {
                if (getSupportFragmentManager().getBackStackEntryCount() > 1) {
                    manager.popBackStackImmediate();
                    String fragmentName = manager.getBackStackEntryAt(manager.getBackStackEntryCount() - 1).getName();
                    BaseFragment fragment = (BaseFragment) manager.findFragmentByTag(fragmentName);
                    FragmantBuilder.getInstance().setLastFragment(fragment);
                } else {
                    super.onBackPressed();
                }
            }


            return true;
        }
        return super.onKeyDown(keyCode, event);
    }



//    //执行完毕退出
//    @Override
//    protected void onDestroy() {
//        super.onDestroy();
//        Process.killProcess(Process.myPid());//获取pid
//        System.exit(0);
////        LocalBroadcastManager.getInstance(this).unregisterReceiver(mMessageReceiver);
//
//        super.onDestroy();
//    }


    @OnClick({R.id.btn_Study, R.id.btn_task, R.id.btn_Myself})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.btn_Study:
                initView();
                ConfigFragment.getInstance().init().start(Study_fragment.class).build();
                break;
            case R.id.btn_task:
                initView();

//                ConfigFragment.getInstance().init().start(Task_bj_Fragment.class).build();

//                String uid = preferences.getString("ZT", "");
//
//                if (uid.isEmpty()){
//                    ConfigFragment.getInstance().init().start(Task_fragment.class).build();
//                }else {
//                    ConfigFragment.getInstance().init().start(Task_bj_Fragment.class).build();
//                }

                if (classId == null){
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

    @Override
    public void getManager(Student_Xinx_Bean xq_bean) {

        if (xq_bean.getData().getClassId() != null){
            classId = xq_bean.getData().getClassId();
            MyLog.e("加入的班级ID",classId  + "");
        }
    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(My_Xinx_Cotract.Presenter presenter) {

    }
}
