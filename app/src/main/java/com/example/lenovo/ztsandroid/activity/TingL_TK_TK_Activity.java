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
import com.example.lenovo.ztsandroid.model.entity.TingL_TK_Bean;
import com.example.lenovo.ztsandroid.model.entity.TingL_XQ_xz_Bean;
import com.example.lenovo.ztsandroid.presenter.TingL_Xq_xz_Presenter;
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

public class TingL_TK_TK_Activity extends BaseActivity implements TingL_XQ_xz_Cotract.View{


    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.danci_viewPager)
    ViewPager danciViewPager;
    private ViewPagerAdapter adapter;
    private ArrayList<Fragment> list = new ArrayList<>();
    private TingL_XQ_xz_Cotract.Presenter presenter;
    private String sentence_id;
    private String Title1;
    private Bundle bundle;
    @Override
    protected int getLayoutId() {
        return R.layout.tingl_tk_sy_activity;
    }

    @Override
    protected void initView() {


        Intent intent = getIntent();
        Title1 = intent.getStringExtra("title");
        sentence_id = intent.getStringExtra("listen_id");
        MyLog.e("AdsDSc传过来的数据",sentence_id);

    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {

        presenter = new TingL_Xq_xz_Presenter(this);
        presenter.SetU(sentence_id);
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
                break;
            case R.id.title:
                Xuanz_NR_Utils.upPopupWindow(view,title);
                break;
        }
    }



    @Override
    public void getManager(final TingL_XQ_xz_Bean xqbean) {

//
    }

    @Override
    public void getManager(final TingL_TK_Bean xqbean) {

        MyLog.e("QWE@#$",xqbean.toString()+"");


        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < xqbean.getData().size(); i++) {

                    TingL_XZ_Fragment fragment = new TingL_XZ_Fragment();
                    bundle = new Bundle();
                    bundle.putSerializable("list", (Serializable) xqbean.getData());
                    bundle.putString("title",xqbean.getData().get(0).getListen_text());
                    fragment.setParams(bundle);
                    list.add(fragment);
                }
                adapter = new ViewPagerAdapter(getSupportFragmentManager(), list);
                danciViewPager.setAdapter(adapter);
                adapter.notifyDataSetChanged();

            }
        });

    }

    @Override
    public void showmessage(String str) {

    }


    @Override
    public void setBasePresenter(TingL_XQ_xz_Cotract.Presenter presenter) {

    }
}
