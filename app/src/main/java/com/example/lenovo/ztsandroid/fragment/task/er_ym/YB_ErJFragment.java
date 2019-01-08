package com.example.lenovo.ztsandroid.fragment.task.er_ym;

import android.content.Intent;
import android.os.Bundle;
import android.support.design.widget.TabLayout;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.util.Log;
import android.view.LayoutInflater;
import android.view.View;
import android.view.ViewGroup;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.ViewPagerAdapter;
import com.example.lenovo.ztsandroid.adapter.YB_FragmentAdapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.base.BaseFragment;
import com.example.lenovo.ztsandroid.fragment.study.yb_sy.YB_four_fragment;
import com.example.lenovo.ztsandroid.fragment.study.yb_sy.YB_xq_one_fragment;
import com.example.lenovo.ztsandroid.fragment.study.yb_sy.YB_xq_three_fragment;
import com.example.lenovo.ztsandroid.fragment.study.yb_sy.YBxq_two_fragment;
import com.example.lenovo.ztsandroid.fragment.task.xq_ym.YB_zy_four_fragment;
import com.example.lenovo.ztsandroid.fragment.task.xq_ym.YB_zy_one_fragment;
import com.example.lenovo.ztsandroid.fragment.task.xq_ym.YB_zy_three_fragment;
import com.example.lenovo.ztsandroid.fragment.task.xq_ym.YB_zy_two_fragment;
import com.example.lenovo.ztsandroid.fragment.task.xq_ym.ZY_Yb_Fragment;
import com.example.lenovo.ztsandroid.utils.MyLog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;
import butterknife.Unbinder;

/**
 * Created by Administrator on 2018/11/29.
 */
public class YB_ErJFragment extends BaseActivity {

    @BindView(R.id.back_jt)
    ImageView backJt;
    @BindView(R.id.YB_xq_title)
    TextView YBXqTitle;
    @BindView(R.id.YB_Tablayout)
    TabLayout YBTablayout;
    @BindView(R.id.YB_viewPager)
    ViewPager YBViewPager;
    private List<Fragment> fragments = new ArrayList<>();
    private YB_FragmentAdapter adapter;
    private Bundle bundle;
    private String hw_type;
    private String hw_content;
    private String hwid;
    private String avgScores;

    @Override
    protected int getLayoutId() {
        return R.layout.yin_b_xq_activity;
    }
    @Override
    protected void initView() {


        Intent intent = getIntent();
        hw_type = intent.getStringExtra("hw_type");
        hw_content = intent.getStringExtra("hw_content");
        hwid = intent.getStringExtra("hwid");
        avgScores = String.valueOf(intent.getDoubleExtra("avgScore",1));
        bundle = new Bundle();

        YB_zy_one_fragment fragment1 = new YB_zy_one_fragment();
        bundle.putString("hw_type",hw_type);
        bundle.putString("hw_content",hw_content);
        bundle.putString("hwid",hwid);
        bundle.putString("avgScores",avgScores);
        fragment1.setParams(bundle);

        YB_zy_two_fragment fragment2 = new YB_zy_two_fragment();
        bundle.putString("hw_type",hw_type);
        bundle.putString("hw_content",hw_content);
        bundle.putString("hwid",hwid);
        bundle.putString("avgScores",avgScores);
        fragment2.setParams(bundle);

        YB_zy_three_fragment fragment3 = new YB_zy_three_fragment();
        bundle.putString("hw_type",hw_type);
        bundle.putString("hw_content",hw_content);
        bundle.putString("hwid",hwid);
        bundle.putString("avgScores",avgScores);
        fragment3.setParams(bundle);

        YB_zy_four_fragment fragment4 = new YB_zy_four_fragment();
        bundle.putString("hw_type",hw_type);
        bundle.putString("hw_content",hw_content);
        bundle.putString("hwid",hwid);
        bundle.putString("avgScores",avgScores);
        fragment4.setParams(bundle);

        fragments.add(fragment1);
        fragments.add(fragment2);
        fragments.add(fragment3);
        fragments.add(fragment4);

        adapter = new YB_FragmentAdapter(getSupportFragmentManager(),fragments);
        YBViewPager.setAdapter(adapter);
        YBTablayout.setupWithViewPager(YBViewPager);

    }

    @Override
    public void initData() {

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
        App.activity.onBackPressed();
    }

}
