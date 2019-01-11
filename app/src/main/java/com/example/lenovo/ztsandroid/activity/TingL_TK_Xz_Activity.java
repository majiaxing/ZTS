package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.view.View;
import android.widget.ImageView;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.ViewPagerAdapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.TingL_XQ_xz_Cotract;
import com.example.lenovo.ztsandroid.fragment.TingL_XZ_Fragment;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;
import com.example.lenovo.ztsandroid.model.entity.TiLi_BaoC_Bean;
import com.example.lenovo.ztsandroid.model.entity.TingL_TK_Bean;
import com.example.lenovo.ztsandroid.model.entity.TingL_XQ_xz_Bean;
import com.example.lenovo.ztsandroid.presenter.TingL_TK_Presenter;
import com.example.lenovo.ztsandroid.utils.BackPopupUtils;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.example.lenovo.ztsandroid.utils.Xuanz_NR_Utils;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/7.
 */

public class TingL_TK_Xz_Activity extends BaseActivity implements TingL_XQ_xz_Cotract.View {


    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.danci_viewPager)
    ViewPager danciViewPager;
    @BindView(R.id.Text_X)
    TextView TextX;
    private ViewPagerAdapter adapter;
    private ArrayList<Fragment> list = new ArrayList<>();
    private TingL_XQ_xz_Cotract.Presenter presenter;
    private String listen_id;
    private String Title1;
    private Bundle bundle;
    private String relative_path;
    private ArrayList<Spinner_Bean> nlist = new ArrayList<>();
    private String type;

    @Override
    protected int getLayoutId() {
        return R.layout.tingl_tk_sy_activity;
    }

    @Override
    protected void initView() {

//        接受参数
        Intent intent = getIntent();
        Title1 = intent.getStringExtra("title");
        listen_id = intent.getStringExtra("listen_id");
        relative_path = intent.getStringExtra("relative_path");

        type = intent.getStringExtra("type");
        MyLog.e("AdsDSc传过来的数据", listen_id);


    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

//        开启网络请求
        presenter = new TingL_TK_Presenter(this);
        presenter.SetU(listen_id);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }
    @OnClick({R.id.back_jt, R.id.title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_jt:
                BackPopupUtils.PopupW(view, "确认退出选择练习？退出后将保存进度");
                BackPopupUtils.PopupDimiss();
                break;
            case R.id.title:
                Xuanz_NR_Utils.upPopupWindow(TextX, title, nlist);
                break;
        }
    }
    @Override
    public void getManager(final TingL_XQ_xz_Bean xqbean) {


    }

    @Override
    public void getManager(final TingL_TK_Bean xqbean) {

        MyLog.e("QWE@#$", xqbean.toString() + "");

//        主线程操作
        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                遍历传值
                for (int i = 0; i < xqbean.getData().get(0).getListen_questionList().size(); i++) {
                    TingL_XZ_Fragment fragment = new TingL_XZ_Fragment();
                    bundle = new Bundle();
                    bundle.putSerializable("list", (Serializable) xqbean.getData().get(0).getListen_questionList().get(i).getListen_optionList());
                    bundle.putString("title", xqbean.getData().get(0).getListen_text());
                    bundle.putString("ertitle", xqbean.getData().get(0).getListen_questionList().get(i).getListen_question());
                    bundle.putString("relative_path", relative_path);
                    bundle.putString("listen_answer",xqbean.getData().get(0).getListen_questionList().get(i).getListen_answer());
                    bundle.putString("listen_id",listen_id);
                    bundle.putString("type",type);
                    bundle.putString("Listen_questId",xqbean.getData().get(0).getListen_questionList().get(i).getListen_questId());
                    bundle.putString("avgScore",xqbean.getData().get(0).getListen_questionList().get(i).getAvgScore());
                    if (!xqbean.getData().get(0).getListen_video().equals("")){
                        bundle.putString("word_video",xqbean.getData().get(0).getListen_video());
                    }else if (!xqbean.getData().get(0).getListen_questionList().get(i).getListen_questVideo().equals("")){
                        bundle.putString("word_video",xqbean.getData().get(0).getListen_questionList().get(i).getListen_questVideo());
                    }
                    bundle.putString("yema",xqbean.getData().get(0).getListen_questionList().size() +"");
                    bundle.putString("dangq",i+1+"");
                    MyLog.e("WYFL",xqbean.getData().get(0).getListen_video());
                    fragment.setParams(bundle);
                    list.add(fragment);
                }
                adapter = new ViewPagerAdapter(getSupportFragmentManager(), list);
                danciViewPager.setAdapter(adapter);
                danciViewPager.setOffscreenPageLimit(2);
                adapter.notifyDataSetChanged();
            }
        });

    }

    @Override
    public void getManagerTiJ(TiLi_BaoC_Bean tiLi_baoC_bean) {

    }

    @Override
    public void showmessage(String str) {

    }


    @Override
    public void setBasePresenter(TingL_XQ_xz_Cotract.Presenter presenter) {
    }
}
