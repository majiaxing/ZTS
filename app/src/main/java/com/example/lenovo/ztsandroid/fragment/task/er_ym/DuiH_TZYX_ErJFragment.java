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
import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_Dh_Cotract;
import com.example.lenovo.ztsandroid.fragment.task.xq_ym.Zy_DuiH_TZYX_Fragment;
import com.example.lenovo.ztsandroid.fragment.task.xq_ym.Zy_Duihua_Fragment;
import com.example.lenovo.ztsandroid.model.entity.Spinner_D_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_Dh_Bean;
import com.example.lenovo.ztsandroid.presenter.zuoye.ZuoY_Dh_presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;

/**
 * Created by Administrator on 2018/11/29.
 */
public class DuiH_TZYX_ErJFragment extends BaseActivity implements ZuoY_Dh_Cotract.View{

    @BindView(R.id.back_jt)
    LinearLayout backJt;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.LeiXin)
    TextView LeiXin;
    @BindView(R.id.YeShu)
    TextView YeShu;
    @BindView(R.id.Zongyeshu)
    TextView Zongyeshu;
    @BindView(R.id.LeiX)
    RelativeLayout LeiX;
    @BindView(R.id.viewPager)
    ViewPager viewPager;

    private ArrayList<Fragment> nlist = new ArrayList<>();
    private ArrayList<Spinner_D_Bean> mlist = new ArrayList();
    private ViewPagerAdapter adapter;

    private Bundle bundle;

    private ZuoY_Dh_Cotract.Presenter presenter;
    private String hw_type;
    private String hw_content;
    private String hwid;
    private String avgScores;
    private ArrayList<String> videolist = new ArrayList<>();

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
    avgScores = String.valueOf(intent.getDoubleExtra("avgScore",1));
}

    @Override
    public void initData() {
        presenter = new ZuoY_Dh_presenter(this);
        presenter.SetUrl(App.stuid,hwid,"","",hw_type,hw_content,avgScores);
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
    private Boolean isJS =false;
    @Override
    public void getManager(final ZuoY_Dh_Bean zuoYDyBean) {
        MyLog.e("DSAHDKSAH",zuoYDyBean.getData().getTypeList().size() + "");
        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                Zy_DuiH_TZYX_Fragment zuYYinBFragment = new Zy_DuiH_TZYX_Fragment();
                    bundle = new Bundle();

                for (int i = 0; i<zuoYDyBean.getData().getTypeList().size();i++ ) {
                    if (isJS){
                        zuoYDyBean.getData().getTypeList().get(i).setJS(isJS);
                        isJS =false;
                    }else {
                        zuoYDyBean.getData().getTypeList().get(i).setJS(isJS);
                        isJS =true;
                    }

                    videolist.add(zuoYDyBean.getData().getTypeList().get(i).getJuese_video());
                    bundle.putSerializable("Juese_videoList",videolist);
                    MyLog.e("listview 数据", zuoYDyBean.getData().toString() + "");

                }
                    bundle.putString("hw_type",hw_type);
                    bundle.putString("hw_content",hw_content);
                    bundle.putString("hwid",hwid);
                    bundle.putString("Relative_path",zuoYDyBean.getData().getRelative_path());
                    bundle.putSerializable("list", (Serializable) zuoYDyBean.getData().getTypeList());
                    zuYYinBFragment.setParams(bundle);
                    nlist.add(zuYYinBFragment);
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
    public void setBasePresenter(ZuoY_Dh_Cotract.Presenter presenter) {

    }
}
