package com.example.lenovo.ztsandroid.fragment.task.er_ym;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.ViewPagerAdapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.ZuoY_TingL_XZ_Cotract;
import com.example.lenovo.ztsandroid.fragment.task.xq_ym.Zy_TingL_TK_Fragment;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_TL_xz_Bean;
import com.example.lenovo.ztsandroid.presenter.zuoye.ZuoY_TL_presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/29.
 */
public class TingL_TK_ErJFragment extends BaseActivity implements ZuoY_TingL_XZ_Cotract.View {

    @BindView(R.id.back_jt)
    LinearLayout backJt;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.LeiXin)
    TextView LeiXin;
    @BindView(R.id.YeShu)
    TextView YeShu;

    @BindView(R.id.LeiX)
    RelativeLayout LeiX;
    @BindView(R.id.viewPager)
    ViewPager viewPager;
    private ArrayList<Fragment> nlist = new ArrayList<>();
    private ViewPagerAdapter adapter;
    private String hw_type;
    private String hw_content;
    private String avgScore;
    private String hwid;

    private ZuoY_TingL_XZ_Cotract.Presenter presenter;

    private Bundle bundle;


    @Override
    protected int getLayoutId() {
        return R.layout.zy_dc_fragment;
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();

        hw_type = intent.getStringExtra("hw_type");
        hw_content = intent.getStringExtra("hw_content");
        avgScore = String.valueOf(intent.getDoubleExtra("avgScore", 1));
        hwid = intent.getStringExtra("hwid");

        MyLog.e("AvgScore", avgScore + "");

//        JsonDemo(typeList);
//        adapter = new ViewPagerAdapter(getSupportFragmentManager(),nlist);
//        viewPager.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
    }

    @Override
    public void initData() {
        //        开始网络请求  初始化presenter  传参
        presenter = new ZuoY_TL_presenter(this);
        presenter.SetUrl(App.stuid, hwid, "", "2", hw_type, hw_content, avgScore);
    }

    @Override
    public void loadData() {

    }
    //请求成功的回调
    @Override
    public void getManager(final ZuoY_TL_xz_Bean zuoYDcBean) {


        final String listen_text = zuoYDcBean.getData().getTypeList().get(0).getListen_text();
        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                    //得到数据 在主线程里面 操作
                    // for循环 遍历 data 集合
                    // 创建fragment 传递数据
                    //bundle 传到 子页面
                    //初始化适配器 创建页面
                for (int i = 0; i < zuoYDcBean.getData().getTypeList().size(); i++) {

                    Zy_TingL_TK_Fragment fragment = new Zy_TingL_TK_Fragment();
                    bundle = new Bundle();
//                    bundle.putSerializable("list", (Serializable) zuoYDcBean.getData().getTypeList().get(0).getListen_questionList().get(i).getListen_optionList());

//                    bundle.putString("ertitle",zuoYDcBean.getData().getTypeList().get(0).getListen_questionList().get(i).getListen_question());
                    bundle.putString("title", listen_text);
//                    bundle.putString("relative_path", zuoYDcBean.getData().getTypeList().get(0).getListen_questionList().get(i).getHomeworkPath());
                    bundle.putSerializable("list", (Serializable) zuoYDcBean.getData().getTypeList());
                    bundle.putString("Relative_path", zuoYDcBean.getData().getRelative_path());
                    bundle.putString("listen_video", zuoYDcBean.getData().getTypeList().get(i).getListen_video());
                    bundle.putString("yema", zuoYDcBean.getData().getTypeList().size() + "");
                    bundle.putString("dangq", i + 1 + "");
                    fragment.setParams(bundle);
                    nlist.add(fragment);
                }
                String zuoYs = String.valueOf(zuoYDcBean.getData().getTypeList().size());
                YeShu.setText(zuoYs);
                LeiXin.setText("听力填空");
                adapter = new ViewPagerAdapter(getSupportFragmentManager(), nlist);
                viewPager.setAdapter(adapter);
                adapter.notifyDataSetChanged();
            }
        });


    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(ZuoY_TingL_XZ_Cotract.Presenter presenter) {
        this.presenter = presenter;
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @OnClick(R.id.back_jt)
    public void onViewClicked() {

        App.activity.onBackPressed();
    }

}
