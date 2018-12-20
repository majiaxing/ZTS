package com.example.lenovo.ztsandroid.fragment.task.er_ym;

import android.content.Intent;
import android.os.Bundle;
import android.support.v4.app.Fragment;
import android.support.v4.view.ViewPager;
import android.widget.ImageView;
import android.widget.RelativeLayout;
import android.widget.TextView;

import com.example.lenovo.ztsandroid.App;
import com.example.lenovo.ztsandroid.R;
import com.example.lenovo.ztsandroid.adapter.ViewPagerAdapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_Yd_Cotract;
import com.example.lenovo.ztsandroid.fragment.task.xq_ym.ZY_Kw_Fragment;
import com.example.lenovo.ztsandroid.fragment.task.xq_ym.Zy_YueDu_Fragment;
import com.example.lenovo.ztsandroid.model.entity.Spinner_T_Bean;
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
public class TingL_TK_ErJFragment extends BaseActivity {

    @BindView(R.id.back_jt)
    ImageView backJt;
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
    private ViewPagerAdapter adapter;

    private Bundle bundle;

    private ArrayList<Spinner_T_Bean> list = new ArrayList<>();
    private Zy_YueDu_Fragment zy_yueDu_fragment = new Zy_YueDu_Fragment();

    private String hw_type;
    private String hw_content;
    private String hwid;
    private String avgScores;
    private ZuoY_Yd_Cotract.Presenter presenter;
    private String read_content;
    private String hw_answerId;


    @Override
    protected int getLayoutId() {
        return R.layout.zy_dc_fragment;
    }

    @Override
    protected void initView() {

    }

    @Override
    public void initData() {
        String typeList = bundle.getString("data");


        Intent intent = getIntent();
        hw_type = intent.getStringExtra("hw_type");
        hw_content = intent.getStringExtra("hw_content");
        hwid = intent.getStringExtra("hwid");
        avgScores = String.valueOf(intent.getDoubleExtra("avgScore", 1));


        MyLog.e("List数据", typeList + "");
    }

    @Override
    public void loadData() {

    }


    private void JsonDemo(String string) {
//
//        Gson gson = new Gson();
//        java.lang.reflect.Type type = new TypeToken<ZuoY_dc_Bean>() {}.getType();
//        ZuoY_dc_Bean jsonBean = gson.fromJson(string, type);
//        List<ZuoY_dc_Bean.TypeListBean> list = jsonBean.getTypeList();
//        for (int i = 0; i<  list.size(); i++){
//            Zy_Dc_Fragment zuYYinBFragment = new Zy_Dc_Fragment();
//                bundle = new Bundle();
//                bundle.putString("DanCy",list.get(i).getWord());
//                bundle.putString("DanCz",list.get(i).getWord_tran());
//
//                MyLog.e("解析出来的单词数据",list.get(i).getWord() + "");
//
//                zuYYinBFragment.setParams(bundle);
//                nlist.add(zuYYinBFragment);
//        }


        //第一步，string参数相当于一个JSON,依次解析下一步
        JSONArray json = null;
        JSONObject data = null;
        try {
            data = new JSONObject(string);

            JSONArray typeList = data.getJSONArray("typeList");


            for (int a = 0; a < typeList.length(); a++) {

                JSONObject value = null;

                value = typeList.getJSONObject(a);

                String word = value.optString("text_yw");
                String word_tran = value.optString("text_zw");

                ZY_Kw_Fragment zuYYinBFragment = new ZY_Kw_Fragment();
                bundle = new Bundle();
                bundle.putString("KWy", word);
                bundle.putString("KWz", word_tran);
                zuYYinBFragment.setParams(bundle);
                nlist.add(zuYYinBFragment);
            }

            adapter = new ViewPagerAdapter(App.activity.getSupportFragmentManager(), nlist);
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

    @OnClick(R.id.back_jt)
    public void onViewClicked() {
    }
}
