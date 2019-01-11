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
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.ListView;
import android.widget.PopupWindow;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.List_Danc_Adapter;
import com.example.lenovo.ztsandroid.adapter.List_Juz_Adapter;
import com.example.lenovo.ztsandroid.adapter.LunBotuAdapter;
import com.example.lenovo.ztsandroid.adapter.ViewPagerAdapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.Juz_XQ_Cotract;
import com.example.lenovo.ztsandroid.fragment.DanCi_fragment;
import com.example.lenovo.ztsandroid.fragment.Duany_Fragment;
import com.example.lenovo.ztsandroid.model.entity.Dc_Xq_Bean;
import com.example.lenovo.ztsandroid.model.entity.Juz_Xq_Bean;
import com.example.lenovo.ztsandroid.presenter.Juz_XQ_Presenter;
import com.example.lenovo.ztsandroid.utils.BackPopupUtils;
import com.example.lenovo.ztsandroid.utils.MyLog;
import com.example.lenovo.ztsandroid.utils.Xuanz_NR_Utils;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/7.
 */

public class JuZ_Sy_Activity extends BaseActivity implements Juz_XQ_Cotract.View ,Duany_Fragment.FragmentToActivity {


    @BindView(R.id.back_jt)
    LinearLayout backJt;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.danci_viewPager)
    ViewPager danciViewPager;
    private ViewPagerAdapter adapter;
    private ArrayList<Fragment> list = new ArrayList<>();
    private Juz_XQ_Cotract.Presenter presenter;
    private String sentence_id;
    private String Title1;
    private Bundle bundle;


    private PopupWindow popupWindow;
    private ArrayList<Juz_Xq_Bean.DataBean> nlist = new ArrayList<>();
    private List_Juz_Adapter Gadapter;
    private ListView listView;
    private String type;
    private String relative_path;

    @Override
    protected int getLayoutId() {
        return R.layout.duany_sy_activity;
    }

    @Override
    protected void initView() {

//        得到父级页面传过来的参数
        Intent intent = getIntent();
        Title1 = intent.getStringExtra("title");
        sentence_id = intent.getStringExtra("sentence_id");
        type = intent.getStringExtra("type");
        relative_path = intent.getStringExtra("Relative_path");

    }
//    设置弹窗  点击 下拉列表 展示所有的内容
    public void upPopupWindow(View view) {
        View v = LayoutInflater.from(App.activity).inflate(R.layout.danc_popup_qh, null);
        popupView(v);
        popupWindow = new PopupWindow(v, LinearLayout.LayoutParams.MATCH_PARENT, LinearLayout.LayoutParams.WRAP_CONTENT);
        popupWindow.setFocusable(true);
        popupWindow.setBackgroundDrawable(new BitmapDrawable()); // 响应返回键必须的语句
        popupWindow.showAsDropDown(view, 0, 0);

    }
//初始化弹窗的控件
    public void popupView(View v) {

        listView = v.findViewById(R.id.popup_listview);
        Gadapter = new List_Juz_Adapter(App.activity, nlist);
        listView.setAdapter(Gadapter);
        Gadapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                title.setText(nlist.get(position).getSentence_yw());
                Log.e("点击传上去的数据", nlist.get(position).getSentence_yw());
                popupWindow.dismiss();
                Gadapter.notifyDataSetChanged();
            }
        });

    }


    @Override
    public void initData() {

    }

    @Override
    public void loadData() {
//      开启网络请求 初始化presenter 传参
        presenter = new Juz_XQ_Presenter(this);
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
                BackPopupUtils.PopupW(view, "确认退出句子学习？退出后将保存进度");
                BackPopupUtils.PopupDimiss();
                break;
            case R.id.title:
                upPopupWindow(view);
                break;
        }
    }
//    请求成功的会低
    @Override
    public void getManager(final Juz_Xq_Bean xqbean) {
//        在主线程中操作
        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
//                for 遍历data 创建页面
                for (int i = 0; i < xqbean.getData().size(); i++) {
//                    初始化 fragment  传参
                    Duany_Fragment fragment = new Duany_Fragment();
                    bundle = new Bundle();
                    bundle.putString("yin",xqbean.getData().get(i).getSentence_yw());
                    bundle.putString("han",xqbean.getData().get(i).getSentence_zw());
                    MyLog.e("句子数据",xqbean.getData().get(i).getSentence_yw());
                    bundle.putString("word_id",sentence_id);
                    bundle.putString("word_video",xqbean.getData().get(i).getSentence_video());
                    bundle.putString("Relative_path",relative_path);
                    bundle.putString("type",type);
                    bundle.putString("yema",xqbean.getData().size() +"");
                    bundle.putString("dangq",i+1+"");
                    fragment.setParams(bundle);
//                    添加fragment  创建页面
                    list.add(fragment);
                }
//                初始化适配器  加载viewpager 页面
                adapter = new ViewPagerAdapter(getSupportFragmentManager(),list);
                danciViewPager.setAdapter(adapter);
                adapter.notifyDataSetChanged();
//                把内容加载到下拉列表上
                nlist.addAll(xqbean.getData());

            }
        });


    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void setBasePresenter(Juz_XQ_Cotract.Presenter presenter) {

    }
//    子页面回调过来的 内容
    @Override
    public void huidiao(String str) {
        title.setText("句子");
    }
}
