package com.example.lenovo.ztsandroid.fragment.task.er_ym;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.ViewPagerAdapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_Dc_Cotract;
import com.example.lenovo.ztsandroid.fragment.task.xq_ym.Zy_Dc_Fragment;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_dc_Bean;
import com.example.lenovo.ztsandroid.presenter.zuoye.ZuoY_Dc_presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/29.
 */
public class DC_ErJFragment extends BaseActivity implements ZuoY_Dc_Cotract.View {

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
    //    private ViewPager viewPager;
    private ArrayList<Fragment> nlist = new ArrayList<>();
    private ViewPagerAdapter adapter;
    private Bundle bundle;
    private ZuoY_Dc_Cotract.Presenter presenter;
    private String hw_type;
    private String hw_content;
    private String hwid;
    private String avgScores;

    @Override
    protected int getLayoutId() {
        return R.layout.zy_dc_fragment;
    }

    @Override
    protected void initView() {


    }

    @Override
    public void initData() {

        Intent intent = getIntent();
        hw_type = intent.getStringExtra("hw_type");
        hw_content = intent.getStringExtra("hw_content");
        hwid = intent.getStringExtra("hwid");
        avgScores = String.valueOf(intent.getDoubleExtra("avgScore", 1));


    }

    @Override
    public void loadData() {
        presenter = new ZuoY_Dc_presenter(this);
        presenter.SetUrl(App.stuid, hwid, "", "", hw_type, hw_content, avgScores);
    }


    private void JsonDemo(String string) {

        //第一步，string参数相当于一个JSON,依次解析下一步
        JSONArray json = null;
        JSONObject data = null;
        try {
            data = new JSONObject(string);

            JSONArray typeList = data.getJSONArray("typeList");


            for (int a = 0; a < typeList.length(); a++) {

                JSONObject value = null;

                value = typeList.getJSONObject(a);

                String word = value.optString("word");
                String word_tran = value.optString("word_tran");
                String hw_answerId = value.optString("hw_answerId");
                Zy_Dc_Fragment zuYYinBFragment = new Zy_Dc_Fragment();
                bundle = new Bundle();
                bundle.putString("DanCy", word);
                bundle.putString("DanCz", word_tran);
                bundle.putString("hw_answerId", hw_answerId);
                MyLog.e("DADT_____", word + word_tran);
                zuYYinBFragment.setParams(bundle);
                nlist.add(zuYYinBFragment);
            }

            adapter = new ViewPagerAdapter(getSupportFragmentManager(), nlist);
            viewPager.setAdapter(adapter);
            adapter.notifyDataSetChanged();

        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // TODO: add setContentView(...) invocation
        ButterKnife.bind(this);
    }

    @Override
    public void getManager(final ZuoY_dc_Bean zuoYDcBean) {


        MyLog.e("DSAHDKSAH", zuoYDcBean.getData().getTypeList().size() + "");

        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                for (int a = 0; a < zuoYDcBean.getData().getTypeList().size(); a++) {

                    String word = zuoYDcBean.getData().getTypeList().get(a).getWord();
                    String word_tran = zuoYDcBean.getData().getTypeList().get(a).getWord_tran();
                    String hw_answerId = zuoYDcBean.getData().getTypeList().get(a).getHw_answerId();

                    Zy_Dc_Fragment zuYYinBFragment = new Zy_Dc_Fragment();
                    bundle = new Bundle();
                    bundle.putString("DanCy", word);
                    bundle.putString("DanCz", word_tran);
                    bundle.putString("hw_answerId", hw_answerId);
                    bundle.putString("hw_type", hw_type);
                    bundle.putString("hw_content", hw_content);
                    bundle.putString("hwid", hwid);
                    MyLog.e("DADT_____", word + word_tran);
                    zuYYinBFragment.setParams(bundle);
                    nlist.add(zuYYinBFragment);
                }

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
    public void setBasePresenter(ZuoY_Dc_Cotract.Presenter presenter) {

    }

    @OnClick(R.id.back_jt)
    public void onViewClicked() {

        App.activity.onBackPressed();
    }


//    @Override
//    protected void loadData() {
//
//    }
//
//    @Override
//    public void setParams(Bundle bundle) {
//        this.bundle = bundle;
//    }
}
