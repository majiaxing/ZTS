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
import com.example.lenovo.ztsandroid.fragment.XuanZ_Fragment;
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
public class TingL_XZ_ErJFragment extends BaseActivity implements ZuoY_TingL_XZ_Cotract.View {

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
    private String zuoYs;


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
        presenter = new ZuoY_TL_presenter(this);
        presenter.SetUrl(App.stuid, hwid, "", "1", hw_type, hw_content, avgScore);
    }

    @Override
    public void loadData() {

    }

    @Override
    public void getManager(final ZuoY_TL_xz_Bean zuoYDcBean) {


        final String listen_text = zuoYDcBean.getData().getTypeList().get(0).getListen_text();
        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < zuoYDcBean.getData().getTypeList().get(0).getListen_questionList().size(); i++) {

                    XuanZ_Fragment fragment = new XuanZ_Fragment();
                    bundle = new Bundle();
                    bundle.putSerializable("list", (Serializable) zuoYDcBean.getData().getTypeList().get(0).getListen_questionList().get(i).getListen_optionList());
                    bundle.putString("title", listen_text);
                    bundle.putString("ertitle", zuoYDcBean.getData().getTypeList().get(0).getListen_questionList().get(i).getListen_question());
                    bundle.putString("relative_path", zuoYDcBean.getData().getTypeList().get(0).getListen_questionList().get(i).getHomeworkPath());
                    MyLog.e("将要传过去的数据", zuoYDcBean.getData().getTypeList().get(0).getListen_questionList().get(i).getListen_question());
                    bundle.putString("Relative_path", zuoYDcBean.getData().getRelative_path());

                    if (!zuoYDcBean.getData().getTypeList().get(0).getListen_video().equals("")) {
                        bundle.putString("listen_video", zuoYDcBean.getData().getTypeList().get(0).getListen_video());
                    } else if (!zuoYDcBean.getData().getTypeList().get(0).getListen_questionList().get(i).getListen_questVideo().equals("")) {
                        bundle.putString("listen_video", zuoYDcBean.getData().getTypeList().get(0).getListen_questionList().get(i).getListen_questVideo());
                    }
                    bundle.putString("yema", zuoYDcBean.getData().getTypeList().get(0).getListen_questionList().size() + "");
                    bundle.putString("dangq", i + 1 + "");
                    zuoYs = String.valueOf(zuoYDcBean.getData().getTypeList().get(0).getListen_questionList().size());
                    fragment.setParams(bundle);
                    nlist.add(fragment);

                }
                YeShu.setText(zuoYs);
                LeiXin.setText("听力选择");
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
