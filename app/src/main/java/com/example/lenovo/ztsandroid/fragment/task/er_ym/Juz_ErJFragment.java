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
import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_Jz_Cotract;
import com.example.lenovo.ztsandroid.fragment.task.xq_ym.Zy_JuZ_Fragment;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_Jz_Bean;
import com.example.lenovo.ztsandroid.presenter.zuoye.ZuoY_Jz_presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/29.
 */
public class Juz_ErJFragment extends BaseActivity implements ZuoY_Jz_Cotract.View {

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

    private Bundle bundle;
    private String hw_type;
    private String hw_content;
    private String hwid;
    private String avgScores;
    private ZuoY_Jz_Cotract.Presenter presenter;

    @Override
    protected int getLayoutId() {
        return R.layout.zy_dc_fragment;
    }

    @Override
    protected void initView() {
        Intent intent = getIntent();
        hw_type = intent.getStringExtra("hw_type");
        hw_content = intent.getStringExtra("hw_content");
        hwid = intent.getStringExtra("hwid");
        avgScores = String.valueOf(intent.getDoubleExtra("avgScore", 1));
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {
        //        开始网络请求  初始化presenter  传参
        presenter = new ZuoY_Jz_presenter(this);
        presenter.SetUrl(App.stuid, hwid, "", "", hw_type, hw_content, avgScores);
    }

//    @Override
//    protected void init(View view) {
//
//        viewPager = view.findViewById(R.id.viewPager);
//
//        String typeList = bundle.getString("data");
//
//
//        String hw_type = bundle.getString("hw_type");
//        String hw_content = bundle.getString("hw_content");
//
//        App.map.put("hw_type",hw_type);
//        App.map.put("hw_content",hw_content);
//        App.map.put("answerList",App.arrayList);
//
//
//        if (App.mlist.size() == 0){
//            App.mlist.add(App.map);
//        }
//
//        MyLog.e("List数据",typeList + "");
//
//        JsonDemo(typeList);
//
//
//
//
//
//
////        for (int i = 0;i<list.size(); i++){
////
////            ZY_Yb_Fragment zyDanCFragment = new ZY_Yb_Fragment();
////            bundle.putSerializable("list",list.get(i).getYb_word());
////            zyDanCFragment.setParams(bundle);
////            nlist.add(zyDanCFragment);
////
////        }
//    }


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void getManager(final ZuoY_Jz_Bean zuoYDcBean) {

        MyLog.e("DSAHDKSAH", zuoYDcBean.getData().getTypeList().size() + "");

        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                //请求成功的回调
                //得到数据 在主线程里面 操作
                // for循环 遍历 data 集合
                // 创建fragment 传递数据
                //bundle 传到 子页面
                //初始化适配器 创建页面

                for (int a = 0; a < zuoYDcBean.getData().getTypeList().size(); a++) {

                    String word = zuoYDcBean.getData().getTypeList().get(a).getSentence_yw();
                    String word_tran = zuoYDcBean.getData().getTypeList().get(a).getSentence_zw();
                    String hw_answerId = zuoYDcBean.getData().getTypeList().get(a).getHw_answerId();

                    Zy_JuZ_Fragment zuYYinBFragment = new Zy_JuZ_Fragment();
                    bundle = new Bundle();
                    bundle.putString("DanCy", word);
                    bundle.putString("DanCz", word_tran);
                    bundle.putString("hw_answerId", hw_answerId);
                    bundle.putString("hw_type", hw_type);
                    bundle.putString("hw_content", hw_content);
                    bundle.putString("hwid", hwid);
                    bundle.putString("everyScore", String.valueOf(zuoYDcBean.getData().getTypeList().get(a).getEveryScore()));
                    bundle.putString("Word_video", zuoYDcBean.getData().getTypeList().get(a).getSentence_video());
                    bundle.putString("Relative_path", zuoYDcBean.getData().getRelative_path());
                    bundle.putString("yema", zuoYDcBean.getData().getTypeList().size() + "");
                    bundle.putString("dangq", a + 1 + "");
                    MyLog.e("DADT_____", word + word_tran);
                    zuYYinBFragment.setParams(bundle);
                    nlist.add(zuYYinBFragment);

                }
                String size = String.valueOf(zuoYDcBean.getData().getTypeList().size());
                YeShu.setText(size);
                LeiXin.setText("句子");
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
    public void setBasePresenter(ZuoY_Jz_Cotract.Presenter presenter) {

    }

    @OnClick(R.id.back_jt)
    public void onViewClicked() {
        App.activity.onBackPressed();
    }
}
