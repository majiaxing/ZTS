package com.example.lenovo.ztsandroid.activity;

import android.content.Intent;
import android.graphics.drawable.BitmapDrawable;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.widget.AdapterView;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.List_duanY_Adapter;
import com.example.lenovo.ztsandroid.adapter.ViewPagerAdapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.Dy_erj_Cotract;
import com.example.lenovo.ztsandroid.fragment.Duany_Fragment;
import com.example.lenovo.ztsandroid.model.entity.Dy_Xq_Bean;
import com.example.lenovo.ztsandroid.presenter.Dy_Xq_Presenter;
import com.example.lenovo.ztsandroid.utils.BackPopupUtils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/7.
 */

public class DuanYu_Sy_Activity extends BaseActivity implements Dy_erj_Cotract.View {


    @BindView(R.id.back_jt)
    LinearLayout backJt;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.danci_viewPager)
    ViewPager danciViewPager;
    @BindView(R.id.linearLayout)
    LinearLayout linearLayout;
    private ViewPagerAdapter adapter;
    private ArrayList<Fragment> list = new ArrayList<>();
    private ArrayList<Dy_Xq_Bean.DataBean> nlist = new ArrayList<>();
    private List_duanY_Adapter Gadapter;
    private ListView listView;
    private PopupWindow popupWindow;
    private Dy_erj_Cotract.Presenter presenter;
    private String type;
    private String extra;
    private Bundle bundle;

    @Override
    protected int getLayoutId() {
        return R.layout.duany_sy_activity;
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        type = intent.getStringExtra("type");
        extra = intent.getStringExtra("extra");


    }

    @Override
    public void initData() {

    }

    public void upPopupWindow(View view) {
        View v = LayoutInflater.from(App.activity).inflate(R.layout.danc_popup_qh, null);
        popupView(v);
        popupWindow = new PopupWindow(v, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // 响应返回键必须的语句
        popupWindow.showAsDropDown(view, 0, 0);

    }

    public void popupView(View v) {

        listView = v.findViewById(R.id.popup_listview);


        Gadapter = new List_duanY_Adapter(App.activity, nlist);
        listView.setAdapter(Gadapter);


        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                title.setText(nlist.get(position).getPhrase());
                Log.e("点击传上去的数据", nlist.get(position).getPhrase());
                popupWindow.dismiss();
                Gadapter.notifyDataSetChanged();
            }
        });

    }


    @Override
    public void loadData() {

        presenter = new Dy_Xq_Presenter(this);
        presenter.setUrl(extra, type, App.stuid);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }


    @OnClick({R.id.back_jt,R.id.linearLayout})
    public void onViewClicked(View view) {
        switch (view.getId()) {
            case R.id.back_jt:
                BackPopupUtils.PopupW(view, "确认退出短语学习？退出后将保存进度");
                BackPopupUtils.PopupDimiss();
                break;
            case R.id.linearLayout:
                upPopupWindow(view);
                break;
        }
    }

    @Override
    public void getManager(final Dy_Xq_Bean xqBean) {

        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for (int i = 0; i < xqBean.getData().size(); i++) {

                    Duany_Fragment duany_fragment = new Duany_Fragment();
                    bundle = new Bundle();
                    bundle.putString("yin", xqBean.getData().get(i).getPhrase());
                    bundle.putString("han", xqBean.getData().get(i).getPhrase_tran());
                    bundle.putString("word_id",xqBean.getData().get(i).getPhrase_id());
                    bundle.putString("type",xqBean.getData().get(i).getType());

                    bundle.putString("Relative_path",xqBean.getData().get(i).getRelative_path());
                    bundle.putString("word_video",xqBean.getData().get(i).getPhrase_video());

                    duany_fragment.setParams(bundle);
                    list.add(duany_fragment);
                }
                adapter = new ViewPagerAdapter(getSupportFragmentManager(), list);
                danciViewPager.setAdapter(adapter);
                adapter.notifyDataSetChanged();


                nlist.addAll(xqBean.getData());
            }
        });


    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(Dy_erj_Cotract.Presenter presenter) {

    }


}
