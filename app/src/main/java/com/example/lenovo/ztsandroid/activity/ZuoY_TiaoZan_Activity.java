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
import com.example.lenovo.ztsandroid.adapter.Tiaoz_Adapter;
import com.example.lenovo.ztsandroid.adapter.Tiaoz_Zy_Adapter;
import com.example.lenovo.ztsandroid.adapter.ViewPagerAdapter;
import com.example.lenovo.ztsandroid.base.BaseActivity;
import com.example.lenovo.ztsandroid.cotract.YB_XiangQ_Cotract;
import com.example.lenovo.ztsandroid.cotract.zuoye.ZuoY_Yb_Cotract;
import com.example.lenovo.ztsandroid.fragment.DanCi_fragment;
import com.example.lenovo.ztsandroid.fragment.study.yb_sy.ZHYX_DanCi_fragment;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_Two_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_four_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_one_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_XQ_three_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_One_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_Three_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_Two_Bean;
import com.example.lenovo.ztsandroid.model.entity.YB_Zy_four_Bean;
import com.example.lenovo.ztsandroid.presenter.YB_Tiaoz_Presenter;
import com.example.lenovo.ztsandroid.presenter.zuoye.ZuoY_YB_One_presenter;
import com.example.lenovo.ztsandroid.utils.BackPopupUtils;
import com.example.lenovo.ztsandroid.utils.MyLog;

import java.util.ArrayList;

import butterknife.BindView;
import butterknife.ButterKnife;
import butterknife.OnClick;

/**
 * Created by Administrator on 2018/12/7.
 */
public class ZuoY_TiaoZan_Activity extends BaseActivity implements ZuoY_Yb_Cotract.View ,ZHYX_DanCi_fragment.FragmentToActivity {


    @BindView(R.id.back_jt)
    LinearLayout backJt;
    @BindView(R.id.title)
    TextView title;
    @BindView(R.id.imageView)
    ImageView imageView;
    @BindView(R.id.view_pager)
    ViewPager viewPager;
    private ViewPagerAdapter adapter;
    private ArrayList<Fragment> list = new ArrayList<>();
    private PopupWindow popupWindow;
    private ArrayList<YB_Zy_One_Bean.DataBean.TypeListBean> nlist = new ArrayList<>();
    private Tiaoz_Zy_Adapter Gadapter;
    private ListView listView;
    private ZuoY_Yb_Cotract.Presenter presenter;
    private String type;
    private String extra;
    private Bundle bundle;
    private String zuoYs;

    @Override
    protected int getLayoutId() {
        return R.layout.yb_tzyx;
    }

    @Override
    protected void initView() {

        Intent intent = getIntent();
        String yb_id = intent.getStringExtra("YB_id");
        String hw_answerId = intent.getStringExtra("hw_answerId");
        String hw_type = intent.getStringExtra("hw_type");
        String hw_content = intent.getStringExtra("hw_content");
        String hwid = intent.getStringExtra("hwid");
        String avgScores = intent.getStringExtra("avgScores");


        presenter = new ZuoY_YB_One_presenter(this);
        presenter.SetU(App.stuid,hwid,"1","",hw_type,hw_content,avgScores);
    }

    @Override
    public void initData() {
    }


    @Override
    public void loadData() {

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

        Gadapter = new Tiaoz_Zy_Adapter(App.activity, nlist);
        listView.setAdapter(Gadapter);
        Gadapter.notifyDataSetChanged();

        listView.setOnItemClickListener(new AdapterView.OnItemClickListener() {
            @Override
            public void onItemClick(AdapterView<?> parent, View view, int position, long id) {
                title.setText(nlist.get(position).getYb_word());
                Log.e("点击传上去的数据", nlist.get(position).getYb_word());
                popupWindow.dismiss();
                Gadapter.notifyDataSetChanged();
            }
        });

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
                BackPopupUtils.PopupW(view, "确认退出单词学习？退出后将保存进度");
                BackPopupUtils.PopupDimiss();
                break;
            case R.id.title:
                upPopupWindow(view);
                break;
        }
    }
    @Override
    public void getManagerOne(final YB_Zy_One_Bean yb_xq_one_bean) {
        App.activity.runOnUiThread(new Runnable() {
            @Override
            public void run() {

                for (int i = 0; i < yb_xq_one_bean.getData().getTypeList().size(); i++) {
                    ZHYX_DanCi_fragment danCi_fragment = new ZHYX_DanCi_fragment();
                    bundle = new Bundle();
                    bundle.putString("word",yb_xq_one_bean.getData().getTypeList().get(i).getYb_word());
                    bundle.putString("word_tran",yb_xq_one_bean.getData().getTypeList().get(i).getYb_translate());
                    bundle.putString("Relative_path",yb_xq_one_bean.getData().getTypeList().get(i).getRelative_path());
                    bundle.putString("word_video",yb_xq_one_bean.getData().getTypeList().get(i).getYb_Avideo());
                    bundle.putString("word_id", String.valueOf(yb_xq_one_bean.getData().getTypeList().get(i).getYb_wordId()));
                    bundle.putString("yema",yb_xq_one_bean.getData().getTypeList().size() +"");
                    bundle.putString("dangq",i+1+"");

                    MyLog.e("adasdsadsa",yb_xq_one_bean.getData().getTypeList().get(i).getYb_word() + ""+yb_xq_one_bean.getData().getTypeList().get(i).getYb_translate() );

                    danCi_fragment.setParams(bundle);
                    list.add(danCi_fragment);
                }
                adapter = new ViewPagerAdapter(getSupportFragmentManager(),list);
                viewPager.setAdapter(adapter);
                nlist.addAll(yb_xq_one_bean.getData().getTypeList());

            }
        });
    }

    @Override
    public void getManagerTwo(YB_Zy_Two_Bean yb_xq_two_bean) {

    }

    @Override
    public void getManagerThree(YB_Zy_Three_Bean yb_xq_three_bean) {

    }

    @Override
    public void getManagerFour(YB_Zy_four_Bean yb_xq_four_bean) {

    }

    @Override
    public void showmessage(String str) {

    }

    @Override
    public void huidiao(String str) {
        // 回调函数 取值
//        Toast.makeText(getApplicationContext(),"我是 Fragment3 回调函数执行了",Toast.LENGTH_SHORT).show();
        title.setText(str);
    }

    @Override
    public void setBasePresenter(ZuoY_Yb_Cotract.Presenter presenter) {

    }
}
