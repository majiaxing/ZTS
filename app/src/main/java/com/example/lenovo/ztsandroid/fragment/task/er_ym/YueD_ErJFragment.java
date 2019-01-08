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
import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_Yd_Cotract;
import com.example.lenovo.ztsandroid.fragment.task.xq_ym.Zy_YueDu_Fragment;
import com.example.lenovo.ztsandroid.model.entity.Spinner_T_Bean;
import com.example.lenovo.ztsandroid.model.entity.ZuoY_Yd_Bean;
import com.example.lenovo.ztsandroid.presenter.zuoye.ZuoY_YD_presenter;
import com.example.lenovo.ztsandroid.utils.MyLog;

import org.json.JSONArray;
import org.json.JSONException;
import org.json.JSONObject;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/11/29.
 */
public class YueD_ErJFragment extends BaseActivity implements ZuoY_Yd_Cotract.View {


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
    private ArrayList<Spinner_T_Bean> list = new ArrayList<>();
    private Bundle bundle;
    private Zy_YueDu_Fragment zy_yueDu_fragment = new Zy_YueDu_Fragment();

    private String hw_type;
    private String hw_content;
    private String hwid;
    private String avgScores;
    private ZuoY_Yd_Cotract.Presenter presenter;
    private String read_content;
    private String hw_answerId;
    private String zuoYs;

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
        LeiXin.setText("阅读");
    }

    @Override
    public void initData() {

    }

    @Override
    public void loadData() {
        presenter = new ZuoY_YD_presenter(this);
        presenter.SetUrl(App.stuid, hwid, "", "", hw_type, hw_content, avgScores);
    }

//    @Override
//    protected void init(View view) {
//
//        viewPager = view.findViewById(R.id.viewPager);
//
//        final String typeList = bundle.getString("data");
//
//        MyLog.e("List数据",typeList + "");
//
//
//
//        new Thread(new Runnable() {
//            @Override
//            public void run() {
//
//
//            }
//        }).start();
//        JsonDemo(typeList);
//
//        adapter = new ViewPagerAdapter(getChildFragmentManager(),nlist);
//        viewPager.setAdapter(adapter);
//        adapter.notifyDataSetChanged();
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

    public void OnShow(Boolean b) {
        zy_yueDu_fragment.Onshow(b);
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

                String word = value.optString("read_content");
                String everyScore = value.optString("everyScore");

                JSONArray read_questionList = value.getJSONArray("read_questionList");

                for (int i = 0; i < read_questionList.length(); i++) {
                    String valueO = read_questionList.getJSONObject(i).getString("read_question");
                    String read_answer = read_questionList.getJSONObject(i).getString("read_answer");
                    JSONObject valueT = read_questionList.getJSONObject(i);
                    JSONArray read_optionList = valueT.getJSONArray("read_optionList");

                    JSONObject jsonObjectA = read_optionList.getJSONObject(0);
                    String read_optionA = jsonObjectA.getString("read_option");
                    String read_optionTextA = jsonObjectA.getString("read_optionText");

                    JSONObject jsonObjectB = read_optionList.getJSONObject(1);
                    String read_optionB = jsonObjectB.getString("read_option");
                    String read_optionTextB = jsonObjectB.getString("read_optionText");

                    JSONObject jsonObjectC = read_optionList.getJSONObject(2);
                    String read_optionC = jsonObjectC.getString("read_option");
                    String read_optionTextC = jsonObjectC.getString("read_optionText");

                    JSONObject jsonObjectD = read_optionList.getJSONObject(3);
                    String read_optionD = jsonObjectD.getString("read_option");
                    String read_optionTextD = jsonObjectD.getString("read_optionText");


//                        list.add(new Spinner_T_Bean(valueO,read_optionA,read_optionTextA,read_optionB,read_optionTextB,read_optionC,read_optionTextC,read_optionD,read_optionTextD,read_answer));

                }
                zy_yueDu_fragment = new Zy_YueDu_Fragment();
                bundle = new Bundle();
                bundle.putString("KWy", word);
                bundle.putSerializable("mapO", (Serializable) list);
                bundle.putString("everyScore", everyScore);
                zy_yueDu_fragment.setParams(bundle);
                nlist.add(zy_yueDu_fragment);
            }


        } catch (JSONException e) {
            e.printStackTrace();
        }


    }

    @Override
    public void getManager(final ZuoY_Yd_Bean zuoYDcBean) {
        MyLog.e("DSAHDKSAH", zuoYDcBean.getData().getTypeList().size() + "");

        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {
                ArrayList<ZuoY_Yd_Bean.DataBean.TypeListBean> mlist = (ArrayList<ZuoY_Yd_Bean.DataBean.TypeListBean>) zuoYDcBean.getData().getTypeList();
                for (int a = 0; a < mlist.size(); a++) {

                    String word = mlist.get(a).getRead_content();
                    ArrayList<ZuoY_Yd_Bean.DataBean.TypeListBean.ReadQuestionListBean> read_questionList = (ArrayList<ZuoY_Yd_Bean.DataBean.TypeListBean.ReadQuestionListBean>) mlist.get(a).getRead_questionList();
                    for (int i = 0; i < read_questionList.size(); i++) {
                        List<ZuoY_Yd_Bean.DataBean.TypeListBean.ReadQuestionListBean.ReadOptionListBean> read_optionList = read_questionList.get(i).getRead_optionList();
                        hw_answerId = read_questionList.get(i).getHw_answerId();

                        MyLog.e("hw_answerId", hw_answerId);

                        String read_question = read_questionList.get(i).getRead_question();
                        String read_answer = read_questionList.get(i).getRead_answer();


                        String read_optionA = read_optionList.get(0).getRead_option();
                        String read_optionTextA = read_optionList.get(0).getRead_optionText();

                        String read_optionB = read_optionList.get(1).getRead_option();
                        String read_optionTextB = read_optionList.get(1).getRead_optionText();

                        String read_optionC = read_optionList.get(2).getRead_option();
                        String read_optionTextC = read_optionList.get(2).getRead_optionText();

                        String read_optionD = read_optionList.get(3).getRead_option();
                        String read_optionTextD = read_optionList.get(3).getRead_option();


                        list.add(new Spinner_T_Bean(read_question, read_optionA, read_optionTextA, read_optionB, read_optionTextB, read_optionC, read_optionTextC, read_optionD, read_optionTextD, read_answer, hw_answerId));

                    }
                    zy_yueDu_fragment = new Zy_YueDu_Fragment();
                    bundle = new Bundle();
                    bundle.putString("KWy", word);
                    bundle.putSerializable("mapO", (Serializable) list);
                    bundle.putString("hw_type", hw_type);
                    bundle.putString("hw_content", hw_content);
                    bundle.putString("hwid", hwid);
                    bundle.putString("EveryScore", String.valueOf(zuoYDcBean.getData().getTypeList().get(0).getEveryScore()));
                    bundle.putString("hw_answerId", hw_answerId);
                    zuoYs = String.valueOf(mlist.size());
                    zy_yueDu_fragment.setParams(bundle);
                    nlist.add(zy_yueDu_fragment);
                }

                YeShu.setText(zuoYs);
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
    public void setBasePresenter(ZuoY_Yd_Cotract.Presenter presenter) {

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
