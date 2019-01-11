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
import com.example.lenovo.ztsandroid.fragment.TingL_TK_Fragment;
import com.example.lenovo.ztsandroid.model.entity.Spinner_Bean;
import com.example.lenovo.ztsandroid.model.entity.TiLi_BaoC_Bean;
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
 * Created by Administrator on 2018/11/22.
 */
public class TingL_TK_Activity extends BaseActivity implements TingL_XQ_xz_Cotract.View {


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
    private String listen_id;
    private String Title1;
    private Bundle bundle;
    private ArrayList<Spinner_Bean> nlist = new ArrayList<>();
    private String relative_path;
    private String type;

    @Override
    protected int getLayoutId() {
        return R.layout.tingl_tk_sy_activity;
    }

    @Override
    protected void initView() {
//        接收参数
        Intent intent = getIntent();
        Title1 = intent.getStringExtra("title");
        listen_id = intent.getStringExtra("listen_id");
        relative_path = intent.getStringExtra("relative_path");
        type = intent.getStringExtra("type");
        MyLog.e("AdsDSc传过来的数据", listen_id);

        title.setText("听力填空");

    }

    @Override
    public void initData() {
//        开始网络请求
        presenter = new TingL_Xq_xz_Presenter(this);
        presenter.SetU(listen_id);
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

    @OnClick(R.id.back_jt)
    public void onViewClicked() {
    }

    @Override
    public void getManager(final TingL_XQ_xz_Bean xqbean) {

        MyLog.e("QWE@#$", xqbean.toString() + "");

//            主线程进行操作
        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < xqbean.getData().size(); i++) {

                    TingL_TK_Fragment fragment = new TingL_TK_Fragment();
                    bundle = new Bundle();
                    bundle.putSerializable("list", (Serializable) xqbean.getData());
//                    bundle.putString("title",xqbean.getData().get(0).getListen_name());

                    bundle.putString("word_video", xqbean.getData().get(0).getListen_video());
                    bundle.putString("Relative_path",relative_path);
                    bundle.putString("listen_id",listen_id);
                    bundle.putString("type",type);
                    bundle.putString("yema",xqbean.getData().size() +"");

                    bundle.putString("dangq",i+1+"");
                    MyLog.e("传过去的路经 ——文件名",xqbean.getData().get(0).getListen_video() + ""+relative_path);



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
    public void getManager(TingL_TK_Bean xqbean) {

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

    @OnClick({R.id.back_jt, R.id.title})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_jt:
                BackPopupUtils.PopupW(view, "确认退出填空练习？退出后将保存进度");
                BackPopupUtils.PopupDimiss();
                break;
            case R.id.title:
                Xuanz_NR_Utils.upPopupWindow(view,title ,nlist);
                break;
        }
    }
}
